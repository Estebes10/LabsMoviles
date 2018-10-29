angular.module('app.routes', [])

.config(function($stateProvider, $urlRouterProvider) {

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider


      .state('home', {
    url: '/home',
    templateUrl: 'templates/home.html',
    params: {
      input1: null,
      input2: null,
      input3: null,
      check: null,
      radio1: null,
      radio2: null,
      range1: null,
    },
    controller: 'homeCtrl'
  })

  .state('profile', {
    url: '/profile',
    templateUrl: 'templates/profile.html',
    controller: 'profileCtrl'
  })

  .state('signup', {
    url: '/page3',
    templateUrl: 'templates/signup.html',
    controller: 'signupCtrl'
  })

  .state('galery', {
    url: '/galery',
    templateUrl: 'templates/galery.html',
    controller: 'galeryCtrl'
  })

$urlRouterProvider.otherwise('/page3')


});
