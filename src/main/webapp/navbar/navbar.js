/**
 * Created by ych on 8/11/16.
 */
ocApp.directive('navbar', function () {
    return {
        templateUrl: 'navbar/navbar.tpl.html'
    }
});
ocApp.controller('PxNavbarController', function ($scope) {
    $scope.menus = [
        {
            name: 'My practices',
            href: '#/records'
        },
        {
            name: 'reports',
            href: '#/reports'
        },
        {
            name: 'ocs',
            href: '/rest/ocs/list'
        },
        {
            name: 'new',
            href: '/rest/ocs/new'
        },
        {
            name: 'count',
            href: '/rest/ocs/count'
        }
    ]
});