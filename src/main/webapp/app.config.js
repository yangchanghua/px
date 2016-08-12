/**
 * Created by ych on 8/11/16.
 */


ocApp.config('$routeProvider', function($routeProvider){
    $routeProvider.when(
        '/oclist', {
            templateUrl: 'ocs.html',
            controller: 'StudyRecordsCtrl'
        }
    );
});