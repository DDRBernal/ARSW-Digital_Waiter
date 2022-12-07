apiclient = (function() {

    return {
        //dg/login/prueba@gmail.com/123456
        getUserByName: function(name, password, callback) {
            const get_request = $.get({
                url: "/dg/login/" + name + "/" + password,
                contentType: "application/json",
            });
            get_request.then(function(data) {
                callback(data, data, data);
            }, function(error) {
                alert("The user doesn't exists !")
            });
        },

        getUserByEmail: function(email, callback) {
            const get_request = $.get({
                url: "/dg/user/" + email,
                contentType: "application/json",
            });
            get_request.then(function(data) {
                callback(data, data);
            }, function(error) {
                alert("The user doesn't exists !")
            });
        },

        addNewUser: function(name, age, phonenumber, email, password, isRestaurant, callback) {
            const post_request = $.ajax({
                url: "dg/addUser/" + name + "/" + age + "/" + phonenumber + "/" + email + "/" + password + "/" + isRestaurant,
                type: "POST",
                data: '{"name":' + name + ',"age:"' + age + ',"phonenumber:"' + phonenumber + ',"email":' + email + ',"password:":' + password + ',"isRestaurant:"' + isRestaurant + '}',
                contentType: "application/json",
            });
            post_request.then(function(data) {
                callback(true, true, true, true, true, true, true);
            }, function(error) {
                alert("Couldn't add the user")
            });
        },

        getTablesByRestaurant: function(idRestaurant, callback) {
            const get_request = $.ajax({
                url: "dg/tablesByR/" + idRestaurant,
                contentType: "application/json",
            });
            get_request.then(function(data) {
                callback(data, data);
            }, function(error) {
                alert("The user doesn't exists !")
            });
        },

        getMenusByRestaurant: function(idRestaurant, callback) {
            const get_request = $.ajax({
                url: "/dg/menusByR/" + idRestaurant,
                contentType: "application/json",
            });
            get_request.then(function(data) {
                callback(data, data);
            }, function(error) {

            });
        },

        imIAdmin: function(email, callback) {
            const get_request = $.get({
                url: "/dg/imIAdmin/" + email,
                contentType: "application/json",
            });
            get_request.then(function(data) {
                callback(data, data);
            }, function(error) {
                alert("Couldn't find the restaurant in the Database !")
            });
        },

        getRestaurants: function(callback) {
            const get_request = $.get({
                url: "/dg/allRestaurants/",
                contentType: "application/json",
            });
            get_request.then(function(data) {
                callback(data, data);
            }, function(error) {
                alert("There aren't restaurants in the Database !")
            });
        },

        setTableDisponibilityByRestaurant: function(idTable, idRestaurant, state, callback) {
            const post_request = $.ajax({
                url: "dg/setTableByR/" + idTable + "/" + idRestaurant + "/" + state,
                type: "POST",
                data: '{"idTable":' + idTable + ',"idRestaurant:"' + idRestaurant + ',"state:"' + state + '}',
                contentType: "application/json",
            });
            post_request.then(function(data) {
                callback(true, true, true, true);
            }, function(error) {
                alert("Couldn't set the table")
            });
        },

        addNewteableRestaurant: function(nameTable, idRestaurant, callback) {
            const post_request = $.ajax({
                url: "dg/addTableR/" + nameTable + "/" + idRestaurant,
                type: "POST",
                data: '{"nameTable":' + nameTable + ',"idRestaurant:"' + idRestaurant + '}',
                contentType: "application/json",
            });
            post_request.then(function(data) {
                callback(true, true, true);
            }, function(error) {
                alert("Couldn't set the table")
            });
        },


    }

})();