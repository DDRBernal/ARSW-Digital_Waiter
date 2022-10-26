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
        apiclient.getMenusByRestaurant("r001",(req,res)=>{
            createTableMenus(res);

        });
    }

    function getRestaurants(){
        apiclient.getRestaurants((req,res)=>{

        });
    }

    function createTableMenus(data){
        let table = $("#fl-table1 tbody");
        table.empty();
        if (data !== undefined) {
          const datanew = data.map((menu) => {
              return {
                  name: menu.name,
                  price: menu.price,
                  calories: menu.calories
              }
          });
          console.log(datanew);
          datanew.forEach(({name, price,calories}) => {
          console.log(name);
          table.append(
                    `<div class="menu-content">
                     <div class="row">
                         <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                             <div class="dish-img"><a href="#"><img src="http://via.placeholder.com/70x70" alt="" class="img-circle"></a></div>
                         </div>
                         <div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
                             <div class="dish-content">
                                 <h5 class="dish-title"><a href="#">${name}</a></h5>
                                 <span class="dish-meta"> Calories: ${calories}</span>
                                 <div class="dish-price">
                                     <p>${price}</p>
                                 </div>
                             </div>
                         </div>
                     </div>
                 </div>`

              );
          })
      }

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
    getRestaurants : getRestaurants
  };

})();