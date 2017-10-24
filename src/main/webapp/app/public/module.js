
var module = angular.module('mpApp.public', ['mpApp.ui', 'ui.router', 'ngResource']);

module.constant('comm', {
    url: '/taskManager/rest'
});


module.config(function ($urlRouterProvider, $stateProvider) {
    $urlRouterProvider.otherwise('/')
    $stateProvider.state('public', {
        abstract: true,
        data: {
            title: 'MP Enterprise'
        }
    });

    
    $stateProvider.state('public.tarea', {
        url: '/tarea',
        data: {
            title: 'Tareas'
        },
        views: {
            "root@app": {
                controller: 'searchTareaController',
                templateUrl: 'app/public/tarea/search.html'
            }
        }, resolve: {
            searchTareaFiles: function ($ocLazyLoad) {
                return $ocLazyLoad.load(['app/public/tarea/tarea-controller.js',
                    'app/public/tarea/tarea-resource.js']);
            }
        }
    });

    $stateProvider.state('public.tarea.new', {
        url: '/new-tarea',
        views: {
            "root@app": {
                templateUrl: 'app/public/tarea/detail.html',
                controller: 'newTareaController'
            }
        }, resolve: {
            searchTareaFiles: function ($ocLazyLoad) {
                return $ocLazyLoad.load(['app/public/tarea/tarea-controller.js',
                    'app/public/tarea/tarea-resource.js']);
            }
        }

    });

    $stateProvider.state('public.tarea.edit', {
        url: '/update-tarea/:id',
        views: {
            "root@app": {
                templateUrl: 'app/public/tarea/detail.html',
                controller: 'editTareaController'
            }
        }, resolve: {
            searchTareasFiles: function ($ocLazyLoad) {
                return $ocLazyLoad.load(['app/public/tarea/tarea-controller.js',
                    'app/public/automovil/tarea-resource.js']);
            }
        }

    });


});
