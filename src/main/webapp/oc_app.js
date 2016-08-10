/**
 * Created by ricyang on 16-8-5.
 */
var ocApp = angular.module('ocApp', []);

ocApp.controller('ocListController', function ocListController($scope) {
    $scope.ocs = [
        {name: "doctor"},
        {name: "nurse"}
    ];
});