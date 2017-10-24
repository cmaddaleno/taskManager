
var module = angular.module('mpApp.public', ['mpApp.ui', 'ui.router', 'ngResource']);

module.constant('comm', {
    url: '/taskManager/rest'
});


var public = 'public.';
var tabla = 'Tarea';
var estado = public.concat(tabla);



module.config(function ($urlRouterProvider, $stateProvider) {
    $urlRouterProvider.otherwise('/')
    $stateProvider.state('public', {
        abstract: true,
        data: {
            title: 'MP Enterprise'
        }
    });

    
    
    $stateProvider.state(estado, {
        url: '/'.concat(tabla),
        data: {
            title: ''.concat(tabla).concat('s')
        },
        views: {
            "root@app": {
                controller: 'search'.concat(tabla).concat('Controller'),
                templateUrl: 'app/public/'.concat(tabla).concat('/search.html')
            }
        }, resolve: {
            searchTareaFiles: function ($ocLazyLoad) {
                return $ocLazyLoad.load(['app/public/'.concat(tabla).concat('/').concat(tabla).concat('-controller.js'),
                     'app/public/'.concat(tabla).concat('/').concat(tabla).concat('-resource.js')]);
            }
        }
    });

    $stateProvider.state('public.'.concat(tabla).concat('.new'), {
        url: '/new-'.concat(tabla),
        views: {
            "root@app": {
                templateUrl: 'app/public/'.concat(tabla).concat('/detail.html'),
                controller: 'new'.concat(tabla).concat('Controller')
            }
        }, resolve: {
            searchTareaFiles: function ($ocLazyLoad) {
                return $ocLazyLoad.load(['app/public/'.concat(tabla).concat('/').concat(tabla).concat('-controller.js'),
                    'app/public/'.concat(tabla).concat('/').concat(tabla).concat('-resource.js')]);
            }
        }

    });

    $stateProvider.state('public.'.concat(tabla).concat('.edit'), {
        url: '/update-'.concat(tabla).concat('/:id'),
        views: {
            "root@app": {
                templateUrl: 'app/public/'.concat(tabla).concat('/detail.html'),
                controller: 'edit'.concat(tabla).concat('Controller')
            }
        }, resolve: {
            searchTareasFiles: function ($ocLazyLoad) {
                 return $ocLazyLoad.load(['app/public/'.concat(tabla).concat('/').concat(tabla).concat('-controller.js'),
                    'app/public/'.concat(tabla).concat('/').concat(tabla).concat('-resource.js')]);
            }
        }

    });


});
