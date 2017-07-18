(function(){
    'use strict';

    var app = angular.module('myApp');
    //$http service is to make the ajax call. Here in this example we have used
    //min safe array and writing the $http as parameter of the function is called as
    //dependency injection [DI].
    app.controller('DataController',['$http',DataController]);

    function DataController($http){
        var vm=this;

        $http.get('data/data.json').success(function(edata){ //call back function
            vm.empl = edata;

        });
    }
})();

//$http service is used to fetch data from JSON file.
//$http is used call RESTFul WEB API. It is used to get,put, post or delete the data.
//$http returns Promise. Promise is object used for asynchronous js.
//$http.get(url/api path).success(function-cb(data){
//}