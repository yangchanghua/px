/**
 * Created by ricyang on 16-8-5.
 */
var ocApp = angular.module('ocApp', ['ngRoute', 'datePicker']);


ocApp.directive('recordDetail', function () {
    return {
        templateUrl: 'recordDetail.tpl.html',
        scope: {
            record: '='
        }
    }
});

ocApp.config(['$routeProvider', function config($routeProvider){
    $routeProvider.when(
        '/records', {
            templateUrl: 'records.html'
        }
    );
}]);
