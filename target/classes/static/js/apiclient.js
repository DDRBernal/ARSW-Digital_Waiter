apiclient=(function(){

	return {
	    //dg/login/prueba@gmail.com/123456
		getUserByName:function(name, password, callback){
           const get_request = $.get({
                url: "/dg/login/"+name+"/"+password,
                contentType: "application/json",
            });
            get_request.then(function (data) {
                callback(data,data,data);
              }, function (error) {
                alert("The user doesn't exists !")
              }
            );
		},

        addNewUser:function(name,age,phonenumber,email,password,isRestaurant,callback){
            const post_request = $.ajax({
                url: "dg/addUser/"+name+"/"+age+"/"+phonenumber+"/"+email+"/"+password+"/"+isRestaurant,
                type: "POST",
                data: '{"name":'+name+',"age:"'+age+',"phonenumber:"'+phonenumber+',"email":'+email+',"password:":'+password+',"isRestaurant:"'+isRestaurant+'}',
                contentType: "application/json",
            });
            post_request.then(function (data) {
                callback(true,true,true,true,true,true,true);
              }, function (error) {
                alert("Couldn't add the user")
              }
            );
        },

        getTablesByRestaurant:function(idRestaurant,callback){
        const get_request = $.get({
                url: "dg/tablesByR/"+idRestaurant,
                contentType: "application/json",
            });
            get_request.then(function (data) {
                console.log(data);
                callback(data,data);
              }, function (error) {
                alert("The user doesn't exists !")
              }
            );
        },

        getMenusByRestaurant:function(idRestaurant,callback){
            const get_request = $.get({
                url: "dg/allMenus",
                contentType: "application/json",
            });
            get_request.then(function (data) {
                console.log(data);
                callback(data,data);
              }, function (error) {
                alert("The user doesn't exists !")
              }
            );
        },

	}

})();