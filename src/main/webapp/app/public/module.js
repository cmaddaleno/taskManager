
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

    
    $stateProvider.state('public.vehicle', {
        url: '/autos',
        data: {
            title: 'Vehicle'
        },
        views: {
            "root@app": {
                controller: 'searchAutoController',
                templateUrl: 'app/public/automovil/search.html'
            }
        }, resolve: {
            searchVehicleFiles: function ($ocLazyLoad) {
                return $ocLazyLoad.load(['app/public/automovil/auto-controller.js',
                    'app/public/automovil/auto-resource.js']);
            }
        }
    });

    $stateProvider.state('public.vehicle.new', {
        url: '/new-auto',
        views: {
            "root@app": {
                templateUrl: 'app/public/automovil/detail.html',
                controller: 'newAutoController'
            }
        }, resolve: {
            searchVehicleFiles: function ($ocLazyLoad) {
                return $ocLazyLoad.load(['app/public/automovil/auto-controller.js',
                    'app/public/automovil/auto-resource.js']);
            }
        }

    });

    $stateProvider.state('public.vehicle.edit', {
        url: '/update-vehicle/:id',
        views: {
            "root@app": {
                templateUrl: 'app/public/automovil/detail.html',
                controller: 'editAutoController'
            }
        }, resolve: {
            searchVehicleFiles: function ($ocLazyLoad) {
                return $ocLazyLoad.load(['app/public/automovil/auto-controller.js',
                    'app/public/automovil/auto-resource.js']);
            }
        }

    });

//
//module.config(function($routeProvider, $locationProvider){
//    $locationProvider.hashPrefix();
//    $routeProvider
//    .when('/posts', {
//        templateUrl: 'app/public/posts/search.html',
//        controller: 'searchPostController'
//    })
//    .when('/new-post', {
//        templateUrl: 'app/public/posts/detail.html',
//        controller: 'newPostController'
//    })
//    .when('/update-post/:id', {
//        templateUrl: 'app/public/posts/detail.html',
//        controller: 'editPostController'
//    })
//    .when('/promises', {
//        templateUrl: 'app/public/promises/detail.html',
//        controller: 'promisesController'
//    }).when('/demo', {
//        templateUrl: 'app/public/demo/demo.html',
//        controller: 'demoController'
//    })
//    .when('/demo-directives', {
//        templateUrl: 'app/public/demo-directives/demo-directives.html',
//        controller: 'demoDirectivesController'
//    });
});
