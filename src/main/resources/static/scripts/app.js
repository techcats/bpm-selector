angular.module('BPMSelector', ['ngAnimate','ngCookies','ngResource','ngRoute','ngSanitize'])
.config(function($routeProvider, $locationProvider) {
    $routeProvider
        .when('/', {
            templateUrl: '/views/main.html'
        })
        .when('/about', {
            templateUrl: '/views/about.html'
        });
    $locationProvider.html5Mode(true);
});