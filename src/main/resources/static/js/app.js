var app = (function() {
    let idRestaurant;

    var stompClient = null;

    function login(username, passwd) {
        apiclient.getUserByName(username, passwd, (req, res) => {
            //login succefully
            if (res == true) {
                console.log("Valid");
                sessionStorage.setItem('usuario', username); // Here we save the user name
                //check if the user is a restaurant or not
                apiclient.imIAdmin(username, (req, res) => {
                    if (res) {
                        goToSite("restaurant_admin.html");
                    } else {
                        goToSite("restaurant.html");
                    }
                });
            } else {
                alert("The user doesn't exists or the email/password are invalids");
            }
        });
    }

    function checkCookies() {
        var email_user = sessionStorage.getItem('usuario');
        apiclient.getUserByEmail(email_user, (req, res) => {
            var string_res = JSON.stringify(res[0]);
            var parse_res = JSON.parse(string_res);
            document.getElementById("username").textContent = parse_res.name;
        });
    }

    function signUp(name, age, phonenumber, email, password, repassword) {
        var checkedValue = document.getElementById('isRestaurant').checked;
        console.log(checkedValue);
        if (name === "" || email === "" || password === "") alert("The name, email and password can't be empty");
        else {
            if (validateDataSignUp(name, email, password, repassword)) {
                apiclient.addNewUser(name, age, phonenumber, email, password, checkedValue, (req, res) => {
                    if (res) {
                        goToSite("index.html");
                    }
                });
            }
        }
    }

    function validateDataSignUp(name, email, password, repassword) {
        let isValid = false;
        let validation_email = email.toLowerCase().match(/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
        if (validation_email == null) alert("Insert an valid email");
        else {
            if (password.localeCompare(repassword)) {
                alert("The passwords are not the same");
            } else { isValid = true; }
        }
        return isValid;
    }

    function connect() {
        console.info('Connecting to WS...');
        var idRestaurant = sessionStorage.getItem("idRestaurant");
        console.log(idRestaurant);
        var socket = new SockJS("/stomp/tablesByR/");
        stompClient = Stomp.over(socket);
        //"/TableByR/body"
        stompClient.connect({}, function(frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/stomp/table', function(eventbody) {
                var response = JSON.parse(eventbody.body);
                console.log(response.body);
                console.log(typeof response.body);
                addTableRestaurant(response.body);
            });
        });

        if (stompClient.connected) {
            stompClient.send("/app/tablesByR/", {}, idRestaurant);
        }
    }

    function sendResponse() {
        var idRestaurant = sessionStorage.getItem("idRestaurant");
        stompClient.send("/app/tablesByR/", {}, idRestaurant);
    }

    //init
    function getTablesByRestaurant() {
        connect();
        //apiclient.getTablesByRestaurant(sessionStorage.getItem("idRestaurant"), (req, res) => {
        //addTableRestaurant(res);
        //});
    }

    function getMenusByRestaurant() {
        //var link = window.location.href;
        //idRestaurant = link.replace("http://localhost:8080/menuLists.html?", "");
        //sessionStorage.setItem('idRestaurant', idRestaurant); // Here we save the id restaurant
        console.log(sessionStorage.getItem("idRestaurant"));
        apiclient.getMenusByRestaurant(sessionStorage.getItem("idRestaurant"), (req, res) => {
            createTableMenus(res);
        });
    }

    function getRestaurants() {
        apiclient.getRestaurants((req, res) => {
            addDataRestaurant(res);
        });
    }

    function createTableMenus(data) {
        //row-starters gy-5
        let table = $("#fl-table1 tbody");
        table.empty();
        var elemento = document.getElementById("starters");
        if (data !== undefined) {
            const datanew = data.map((menu) => {
                return {
                    name: menu.name,
                    price: menu.price,
                    calories: menu.calories
                }
            });
            datanew.forEach(({ name, price, calories }) => {
                //var link = window.location.href
                idRestaurant = sessionStorage.getItem("idRestaurant");
                //link.replace("http://localhost:8080/menuLists.html?", "");
                elemento.innerHTML +=
                    `<div class="col-lg-4 menu-item">
                     <a href="../img/menu/menu-item-1.png" class="glightbox"><img src="../img/menu/menu-item-1.png" class="menu-img img-fluid" alt=""></a>
                     <h4>${name}</h4>
                     <p class="ingredients">
                       Calorias: ${calories}
                     </p>
                     <p class="price">
                       ${price}$
                     </p>
                     <button type="button" class="btn btn-outline-danger" onclick="app.setTableRestaurant('${idRestaurant}','${name}')">Seleccionar</button>
                   </div><!-- Menu Item -->`
            })
        }
    }

    /**
     * Method to add the tables in the front
     * @param {*} data 
     */
    function addTableRestaurant(data) {
        //row-starters gy-5
        console.log(typeof data);
        let table = $("#fl-table1 tbody");
        table.empty();
        var elemento = document.getElementById("tables");
        elemento.innerHTML = `<div></div>`;
        var select_table = "Seleccionar";
        if (sessionStorage.getItem('tableAvaliable')) { select_table = "Liberar Mesa"; }
        data.sort(function(a, b) {
            return parseFloat(a.name) - parseFloat(b.name);
        });
        if (data !== undefined) {
            const datanew = data.map((table) => {
                return {
                    id: table.id,
                    name: table.name,
                    zone: table.zone,
                    disponibility: table.disponibility,
                    idRestaurant: table.idRestaurant
                }
            });
            datanew.forEach(({ id, name, zone, disponibility, idRestaurant }) => {
                var image = "table_avaliable.png";
                if (!disponibility) { image = "table_not_avaliable.png"; }
                elemento.innerHTML +=
                    `<div class="col-lg-4 menu-item">
                     <a href="../img/menu/menu-item-1.png" class="glightbox"><img src="../img/${image}" class="menu-img img-fluid" alt=""></a>
                     <h4>Mesa ${name}</h4>
                     <button type="button" onclick="app.tableAvaliableSelected('${id}');app.sendResponse()" class="btn btn-outline-danger">${select_table}</button>
                   </div><!-- Menu Item -->`
            })
        }
    }

    function createRestaurants(data) {
        let table = $("#fl-table tbody");
        table.empty();
        if (data !== undefined) {
            const datanew = data.map((restaurant) => {
                return {
                    id: restaurant.id,
                    name: restaurant.name,
                    address: restaurant.address,
                    phonenumber: restaurant.phonenumber
                }
            });
            datanew.forEach(({ id, name, address, phonenumber }) => {
                table.append(
                    `<tr>
                        <td>${name}</td>
                        <td>${address}</td>
                        <td>${phonenumber}</td>
                        <td><button onclick="app.setIdRestaurant('${id}')">Seleccionar</button></td></tr>
                      `
                );
            })
        }
    }

    function setIdRestaurant(idRestaurant) {
        sessionStorage.setItem('idRestaurant', idRestaurant); // Here we save the id restaurant
        console.log(username);
        apiclient.imIAdmin(sessionStorage.getItem('usuario'), (req, res) => {
            if (res) {
                goToSite("menuLists_admin.html");
            } else {
                goToSite("menuLists.html?" + idRestaurant);
            }
        });

    }

    function setTableRestaurant(idRestaurant, name_menu) {
        sessionStorage.setItem('name_menu', name_menu); // Here we save the id restaurant
        apiclient.imIAdmin(sessionStorage.getItem('usuario'), (req, res) => {
            if (res) {
                goToSite("tables_admin.html");
            } else {
                goToSite("tables.html?" + idRestaurant);
            }
        });
    }

    function setTableAvaliable() {
        sessionStorage.setItem('tableAvaliable', true);
    }

    function tableAvaliableSelected(idTable) {
        var menu_selected = sessionStorage.getItem('name_menu');
        // We check if one menu was selected
        var idRestaurant = sessionStorage.getItem('idRestaurant');
        var sesion = false;
        if (sessionStorage.getItem('tableAvaliable')) { sesion = true; }
        apiclient.setTableDisponibilityByRestaurant(idTable, idRestaurant, sesion, (req, res) => {
            console.log(res);
        });
    }

    function addDataRestaurant(data) {
        //row-starters gy-5
        console.log(data);
        let table = $("#fl-table1 tbody");
        table.empty();
        var elemento = document.getElementById("sectionRestaurant");
        if (data !== undefined) {
            const datanew = data.map((restaurant) => {
                return {
                    id: restaurant.id,
                    name: restaurant.name,
                    address: restaurant.address,
                    phonenumber: restaurant.phonenumber
                }
            });
            datanew.forEach(({ id, name, address, phonenumber }) => {
                elemento.innerHTML +=
                    `<div class="row gx-lg-5">
                     <div class="col-lg-6 col-xxl-4 mb-5">
                     <div class="card bg-light border-0 h-100">
                     <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                     <div class="feature bg-primary bg-gradient text-white rounded-3 mb-4 mt-n4">
                     <img src="../img/restaurante1.jpg" alt="restaurante1" width="420" height="300"></div>
                     <h2 class="fs-4 fw-bold">${name}</h2>
                     <p class="mb-0">${address}</p>
                     <p class="mb-0">${phonenumber}</p>
                     <button class="btn btn-outline-success" onclick="app.setIdRestaurant('${id}')">Seleccionar</button>
                     </div>
                     </div>
                     </div>
                     </div>`
            })
        }
    }

    function goToSite(page) {
        window.location.replace(page);
    }

    function cleanCookies() {
        sessionStorage.setItem('usuario', undefined);
        sessionStorage.setItem('idRestaurant', undefined);
        sessionStorage.setItem('name_menu', undefined);
        sessionStorage.setItem('tableAvaliable', undefined);
        goToSite("index.html");
    }

    function addNewteableRestaurant(nameTable) {
        apiclient.addNewteableRestaurant(nameTable, sessionStorage.getItem('idRestaurant'), (req, res) => {
            if (res) {
                sendResponse();
            }
        });
    }

    function openForm() {
        document.getElementById("myForm").style.display = "block";
    }

    function closeForm() {
        document.getElementById("myForm").style.display = "none";
    }

    return {
        login: login,
        signUp: signUp,
        getMenusByRestaurant: getMenusByRestaurant,
        getRestaurants: getRestaurants,
        setIdRestaurant: setIdRestaurant,
        checkCookies: checkCookies,
        getTablesByRestaurant: getTablesByRestaurant,
        setTableRestaurant: setTableRestaurant,
        tableAvaliableSelected: tableAvaliableSelected,
        sendResponse: sendResponse,
        setTableAvaliable: setTableAvaliable,
        cleanCookies: cleanCookies,
        addNewteableRestaurant: addNewteableRestaurant,
        openForm: openForm,
        closeForm: closeForm
    };

})();