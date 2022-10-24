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

        addNewUser:function(name,nickname,password,callback){
            const put_request = $.ajax({
                url: "/users/"+name+"/"+nickname+"/"+password,
                type: "POST",
                data: '{"name":'+name+',"nickname":'+nickname+',"password:":'+password+'}',
                contentType: "application/json",
            }); callback(null,name,name);
        },

	}

})();