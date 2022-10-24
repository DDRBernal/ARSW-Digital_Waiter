apiclient=(function(){

	return {
		getUserByName:function(name,password){
           const get_request = $.get({
                url: "/users/" + name,
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