var app = angular.module('BPMSelector', ['ngAnimate','ngCookies','ngResource','ngRoute','ngSanitize','ngMaterial','ngMessages'])
.config(function($routeProvider, $locationProvider) {
    $routeProvider
        .when('/', {
            templateUrl: '/views/front.html'
        })
        .when('/dashboard',  {
            templateUrl: '/views/main.html'
        })
        .when('/about', {
            templateUrl: '/views/about.html'
        });
    $locationProvider.html5Mode(true);
});