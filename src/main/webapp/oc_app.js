/**
 * Created by ricyang on 16-8-5.
 */
var ocApp = angular.module('ocApp', ['ngRoute', 'datePicker']);

ocApp.config(['$routeProvider', function config($routeProvider){
    $routeProvider.when(
        '/records', {
            templateUrl: 'records.html'
        }
    );
}]);
