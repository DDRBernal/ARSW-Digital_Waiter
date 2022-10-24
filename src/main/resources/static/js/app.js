var app = (function () {

  let name;

    function login(username, passwd){
        apiclient.getUserByName(username, passwd, (req,res) => {
            //login succefully
            if (res==true){
                console.log("Valid");
                window.location.replace("menuLists.html");
            }else{
                alert("The user doesn't exists or the email/password are invalids");
            }
        });
    }

    function verifyUser(email,passwd){

    }

    function getNameAuthor(name) {
        apiclient.getUserByName( name, (req,res)=>{
            //in construction
        });
    }

    function getMenuList(){

    }

    function addNewName(){

    }


  return {
    getNameAuthor: getNameAuthor,
    addNewName : addNewName,
    login : login
  };

})();