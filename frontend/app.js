var app = angular.module("StringCalculatorApp", []);

app.controller("CalculatorController", function ($scope, $http) {
  $scope.numbers = "";
  $scope.result = "";
  $scope.error = "";
  $scope.callCount = "";

  $scope.calculate = function () {
    console.log("Add button clicked!");
    $scope.error = "";
    $scope.result = "";
    console.log("input: ", $scope.numbers);
    $http
      .post("http://localhost:8080/api/add", $scope.numbers, {
        headers: { "Content-Type": "text/plain" },
      })
      .then(function (response) {
        $scope.result = response.data.result;
        $scope.callCount = response.data.callCount;
      })
      .catch(function (error) {
        console.error("Error:", error);
        $scope.error = error.data?.error || "Server error";
      });
  };
});
