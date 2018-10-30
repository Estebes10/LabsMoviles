angular.module('app.controllers', [])

.controller('homeCtrl', ['$scope', '$stateParams', '$http',// The following is the constructor function for this page's controller. See https://docs.angularjs.org/guide/controller
// You can include any angular dependencies as parameters for this function
// TIP: Access Route Parameters for your page via $stateParams.parameterName
function ($scope, $stateParams, $http) {
  api_key = 'XOSHM9SHFSYVSOFG';
  company = $stateParams.name;
  $scope.name = company;
  //url = 'https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=MSFT&apikey=demo';
  url = 'https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol='+company+'&apikey=XOSHM9SHFSYVSOFG'

  $http.get(url).then(function(response){
    price = response.data["Global Quote"]["05. price"];
    previous = response.data["Global Quote"]["08. previous close"];
    $scope.symbol = response.data["Global Quote"]["01. symbol"];
    $scope.price = price
    $scope.date = response.data["Global Quote"]["07. latest trading day"];
    $scope.previous = price - previous;

    if((price - previous) < 0){
      $scope.recommendation = "Sell";
      $scope.color = 'red';
    }else{
      $scope.recommendation = "Keep the stock";
      $scope.color = 'black';
    }
  }, function(error){
    alert("Unable to retrieve information!");
  });
}])

.controller('signupCtrl', ['$scope', '$stateParams', // The following is the constructor function for this page's controller. See https://docs.angularjs.org/guide/controller
// You can include any angular dependencies as parameters for this function
// TIP: Access Route Parameters for your page via $stateParams.parameterName
function ($scope, $stateParams) {


}])
