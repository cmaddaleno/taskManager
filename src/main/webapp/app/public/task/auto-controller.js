
var module = angular.module('mpApp.public');


module.controller('searchAutoController', function ($scope, $log, autoResource) {
    var pc = this;
    
    pc.autos = [];
    
    pc.search = function(){
        var successCallback = function(data, responseHeaders) {
            pc.autos = data;
        };

        var errorCallback = function(responseHeaders) {
            $log.error('search error ' + responseHeaders);
        };

         autoResource.queryAll({}, successCallback, errorCallback);
    };
    
    pc.delete = function(id){
        
    };
    
    pc.search();
});


module.controller('editAutoController', function ($scope, $log, $stateParams, $location, autoResource) {
    $scope.location = $location.path();
    $scope.auto = {};
    $scope.get = function(){
        var successCallback = function(data, responseHeaders) {
            $log.info('retrieved successfuly ' + JSON.stringify(data));
            $scope.auto = data;
        };

        var errorCallback = function(responseHeaders) {
            $log.error('error while searching ' + responseHeaders);
        };
        
        autoResource.query({id:$stateParams.id}, successCallback, errorCallback);
    };

    $scope.save = function () {

        var successCallback = function(data, responseHeaders) {
            $log.info('updating successfuly ' + data);
            $location.path('/autos');
        };

        var errorCallback = function(responseHeaders) {
            $log.error('error while persisting');
        };

         //autoResource.update($scope.auto, successCallback, errorCallback);
         
         $scope.auto.$update(successCallback, errorCallback);

    };
    
    $scope.delete = function () {

        var successCallback = function(data, responseHeaders) {
            $log.info('removed successfuly ' + data);
            $location.path('/autos');
        };

        var errorCallback = function(responseHeaders) {
            $log.error('error while persisting');
        };

         //autoResource.update($scope.auto, successCallback, errorCallback);
         
         $scope.auto.$remove(successCallback, errorCallback);

    };
    
    $scope.get();

});

module.controller('newAutoController', function ($scope, $log, autoResource) {

    $scope.auto = {};

    $scope.save = function () {

        var successCallback = function(data, responseHeaders) {
            $log.info('saved successfuly ' + data);
        };

        var errorCallback = function(responseHeaders) {
            $log.error('error while persisting');
        };

         autoResource.save($scope.auto, successCallback, errorCallback);

    };
    
    $scope.cancel = function () {
        $scope.auto = {};
    };

});