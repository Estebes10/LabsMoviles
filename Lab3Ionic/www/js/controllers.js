angular.module('app.controllers', [])

.controller('homeCtrl', ['$scope', '$stateParams', '$http', // The following is the constructor function for this page's controller. See https://docs.angularjs.org/guide/controller
// You can include any angular dependencies as parameters for this function
// TIP: Access Route Parameters for your page via $stateParams.parameterName
function ($scope, $stateParams, $http) {
  appid = '2cebc1aabf8946224192ad17c81d55bd';
  city = $stateParams.city;
  url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + appid + "&units=metric";

  $http.get(url).then(function(response){
    $scope.cityname = response.data.name;
    $scope.temperature = response.data.main.temp;
    $scope.commentary = response.data.weather[0].description;
    $scope.icon = response.data.weather[0].icon;
  }, function(error){
    alert("Unable to retrieve weather!");
  });

}])

.controller('profileCtrl', ['$scope', '$stateParams', // The following is the constructor function for this page's controller. See https://docs.angularjs.org/guide/controller
// You can include any angular dependencies as parameters for this function
// TIP: Access Route Parameters for your page via $stateParams.parameterName
function ($scope, $stateParams) {


}])

.controller('signupCtrl', ['$scope', '$stateParams', // The following is the constructor function for this page's controller. See https://docs.angularjs.org/guide/controller
// You can include any angular dependencies as parameters for this function
// TIP: Access Route Parameters for your page via $stateParams.parameterName
function ($scope, $stateParams) {
  $scope.city = {};

}])

.controller('galeryCtrl', ['$scope', '$stateParams', // The following is the constructor function for this page's controller. See https://docs.angularjs.org/guide/controller
// You can include any angular dependencies as parameters for this function
// TIP: Access Route Parameters for your page via $stateParams.parameterName
function ($scope, $stateParams) {


}])
