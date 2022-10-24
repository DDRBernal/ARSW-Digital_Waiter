var app = (function () {

  let name;

    function login(username, passwd){
        apiclient.getUserByName(username, passwd, (req,res) => {

        });
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
    addNewName : addNewName
  };

})();