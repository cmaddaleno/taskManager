var module = angular.module('mpApp.public');


module.factory('autoResource', function ($resource, comm) {
    return $resource(comm.url + '/automovil/:id', {
            id : '@id'
        }, {
        'queryAll': {
            method: 'GET',
            isArray: true
        },
        'query' : {
                method : 'GET',
                isArray : false
        },
        'update' : {
            method : 'PUT'
        }
//        'persistImage' : {
//            method : 'POST',
//            url: 'rest/protected/organizations/persist-image'
//        }
    });
});

