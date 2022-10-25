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
        apiclient.getMenusByRestaurant("",(req,res)=>{
            console.log(res);
        });
    }

    function getRestaurants(){
        apiclient.getRestaurants((req,res)=>{
            console.log(res);
            createTable(res);
        });
    }

    function createTable(data){

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