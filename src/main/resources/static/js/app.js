var app = (function () {
    let idRestaurant;

    function login(username, passwd){
        apiclient.getUserByName(username, passwd, (req,res) => {
            //login succefully
            if (res==true){
                console.log("Valid");
                goToSite("restaurant.html");
            }else{
                alert("The user doesn't exists or the email/password are invalids");
            }
        });
    }

    function signUp(name,age,phonenumber, email, password,repassword){
        if (name === "" || email === "" || password==="") alert("The name, email and password can't be empty");
        else {
            if (validateDataSignUp(name, email, password,repassword)){
                apiclient.addNewUser(name,age,phonenumber,email,password,false,(req,res) => {
                    if (res){
                        goToSite("index.html");
                    }
                });
            }
        }
    }

    function validateDataSignUp(name,email,password,repassword){
        let isValid = false;
        let validation_email = email.toLowerCase().match(/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
        if (validation_email==null)alert("Insert an valid email");
        else {
            if(password.localeCompare(repassword)){
                alert("The passwords are not the same");
            }else{isValid=true;}
        }
        return isValid;
    }

    function getTablesByRestaurant(idRestaurant){
        apiclient.getTablesByRestaurant(idRestaurant, (req,res)=>{

        });
    }

    function getMenusByRestaurant(){
        var link = window.location.href;
        idRestaurant = link.replace("http://localhost:8080/menuLists.html?","");
        console.log(idRestaurant);
        apiclient.getMenusByRestaurant(idRestaurant,(req,res)=>{
            createTableMenus(res);
        });
    }

    function getRestaurants(){
        apiclient.getRestaurants((req,res)=>{
            createTable(res);
        });
    }

    function createTableMenus(data){
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
          datanew.forEach(({name, price,calories}) => {

          elemento.innerHTML +=
                    `<div class="col-lg-4 menu-item">
                     <a href="img/menu/menu-item-1.png" class="glightbox"><img src="img/menu/menu-item-1.png" class="menu-img img-fluid" alt=""></a>
                     <h4>${name}</h4>
                     <p class="ingredients">
                       Lorem, deren, trataro, filede, nerada
                     </p>
                     <p class="price">
                       ${price}
                     </p>
                   </div><!-- Menu Item -->`

           })
       }console.log(elemento.innerHTML);
       }

    function createTable(data){
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
              console.log(datanew);
              datanew.forEach(({id,name, address, phonenumber}) => {
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

    function setIdRestaurant(newid){
        idRestaurant=newid;
        console.log("menuLists.html?"+idRestaurant);
        goToSite("menuLists.html?"+idRestaurant);
    }

    function getMenuList(){

    }

    function addNewName(){

    }

    function goToSite(page){
        window.location.replace(page);
    }




  return {
    addNewName : addNewName,
    login : login,
    signUp : signUp,
    getMenusByRestaurant : getMenusByRestaurant,
    getRestaurants : getRestaurants,
    setIdRestaurant : setIdRestaurant
  };

})();