
var module = angular.module('mpApp.public');


module.controller('searchTareaController', function ($scope, $log, tareaResource, filterFilter) {
    var pc = this;
    
    $scope.indiceActual      = 0;
    $scope.tipoActual        = "pendientes";
    
    $scope.tareasActivas     = tareaResource.get("activas");
    $scope.tareasPendientes  = tareaResource.get("pendientes");
    $scope.tareasFinalizadas = tareaResource.get("finalizadas");
    
    
    pc.tareas = [];
    
    pc.search = function(){
        var successCallback = function(data, responseHeaders) {
            pc.tareas = data;
        };

        var errorCallback = function(responseHeaders) {
            $log.error('search error ' + responseHeaders);
        };

         tareaResource.queryAll({}, successCallback, errorCallback);
    };
    
    pc.delete = function(id){
        
    };
    
    pc.search();
});


module.controller('editTareaController', function ($scope, $log, $stateParams, $location, tareaResource) {
    $scope.location = $location.path();
    $scope.tarea = {};
    $scope.get = function(){
        var successCallback = function(data, responseHeaders) {
            $log.info('retrieved successfuly ' + JSON.stringify(data));
            $scope.tarea = data;
        };

        var errorCallback = function(responseHeaders) {
            $log.error('error while searching ' + responseHeaders);
        };
        
        tareaResource.query({id:$stateParams.id}, successCallback, errorCallback);
    };

    $scope.save = function () {

        var successCallback = function(data, responseHeaders) {
            $log.info('updating successfuly ' + data);
            $location.path('/autos');
        };

        var errorCallback = function(responseHeaders) {
            $log.error('error while persisting');
        };

         //tareaResource.update($scope.tarea, successCallback, errorCallback);
         
         $scope.tarea.$update(successCallback, errorCallback);

    };
    
    $scope.delete = function () {

        var successCallback = function(data, responseHeaders) {
            $log.info('removed successfuly ' + data);
            $location.path('/autos');
        };

        var errorCallback = function(responseHeaders) {
            $log.error('error while persisting');
        };

         //tareaResource.update($scope.tarea, successCallback, errorCallback);
         
         $scope.tarea.$remove(successCallback, errorCallback);

    };
    
    $scope.get();

});

module.controller('newTareaController', function ($scope, $log, tareaResource) {

    $scope.tarea = {};

    $scope.save = function () {

        var successCallback = function(data, responseHeaders) {
            $log.info('saved successfuly ' + data);
        };

        var errorCallback = function(responseHeaders) {
            $log.error('error while persisting');
        };

         tareaResource.save($scope.tarea, successCallback, errorCallback);

    };
    
    $scope.cancel = function () {
        $scope.tarea = {};
    };

});