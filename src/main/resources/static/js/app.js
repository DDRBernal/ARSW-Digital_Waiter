var app = (function() {
    let idRestaurant;

    function login(username, passwd) {
        apiclient.getUserByName(username, passwd, (req, res) => {
            //login succefully
            if (res == true) {
                console.log("Valid");
                sessionStorage.setItem('usuario', username); // Here we save the user name
                //check if the user is a restaurant or not
                apiclient.imIAdmin(username, (req, res) => {
                    if (res) {
                        goToSite("restaurant.html");
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

    function getTablesByRestaurant() {

        apiclient.getTablesByRestaurant(sessionStorage.getItem("idRestaurant"), (req, res) => {
            addTableRestaurant(res);
        });
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
            createRestaurants(res);
        });
    }

    function createTableMenus(data) {
        //row-starters gy-5
        let table = $("#fl-table1 tbody");
        table.empty();
        var elemento = document.getElementById("Today's menu");
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
                     <a href="img/menu/menu-item-1.png" class="glightbox"><img src="img/menu/menu-item-1.png" class="menu-img img-fluid" alt=""></a>
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

    function addTableRestaurant(data) {
        //row-starters gy-5
        console.log(data);
        let table = $("#fl-table1 tbody");
        table.empty();
        var elemento = document.getElementById("starters");
        if (data !== undefined) {
            const datanew = data.map((table) => {
                return {
                    id: table.id,
                    name: table.name,
                    zone: table.zone,
                    disponibility: table.disponibility,7
                    idRestaurant: table.idRestaurant
                }
            });
            datanew.forEach(({ id, name, zone, disponibility, idRestaurant }) => {
                var image = "table_avaliable.png";
                if (!disponibility) { image = "table_not_avaliable.png"; }
                elemento.innerHTML +=
                    `<div class="col-lg-4 menu-item">
                     <a href="img/menu/menu-item-1.png" class="glightbox"><img src="img/${image}" class="menu-img img-fluid" alt=""></a>
                     <h4>Mesa ${name}</h4>
                     <button type="button" onclick="app.tableAvaliableSelected('${id}')" class="btn btn-outline-danger">Seleccionar</button>
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
        goToSite("menuLists.html?" + idRestaurant);
    }

    function setTableRestaurant(idRestaurant, name_menu) {
        sessionStorage.setItem('name_menu', name_menu); // Here we save the id restaurant
        goToSite("tables.html?" + idRestaurant);
    }

    function tableAvaliableSelected(idTable) {
        var menu_selected = sessionStorage.getItem('name_menu');
        //We check if one menu was selected
        var idRestaurant = sessionStorage.getItem('idRestaurant');
        var sesion = false;
        apiclient.setTableDisponibilityByRestaurant(idTable, idRestaurant, sesion, (req, res) => {
            console.log(res);
        });
        if (menu_selected === undefined) {
            //alert("No olvides seleccionar un menu para poder continuar con el proceso!");
        } else {}
    }
    function addDataRestaurant(data) {
            //row-starters gy-5
            console.log(data);
            let table = $("#fl-table1 tbody");
            table.empty();
            var elemento = document.getElementById("starters");
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
                        `<div class="col-lg-4 menu-item">
                         <a href="img/menu/menu-item-1.png" class="glightbox"><img src="img/${image}" class="menu-img img-fluid" alt=""></a>
                         <h4>Mesa ${name}</h4>
                         <button type="button" onclick="app.tableAvaliableSelected('${id}')" class="btn btn-outline-danger">Seleccionar</button>
                       </div><!-- Menu Item -->`
                })
            }
        }
    function goToSite(page) {
        window.location.replace(page);
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
        tableAvaliableSelected: tableAvaliableSelected
    };

})();