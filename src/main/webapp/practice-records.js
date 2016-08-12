/**
 * Created by ych on 8/11/16.
 */
ocApp.controller('StudyRecordsCtrl', function StudyRecordsCtrl($scope) {
    $scope.newProj = {};
    $scope.formValues = {
        startDate: moment()
    };
    $scope.today = moment();
    $scope.projects = [
        {
            domain: 'programming',
            subDomain: 'angularJS',
            hours: 120,
            startDate: new Date('2016-02-23')
        },
        {
            domain: 'programming',
            subDomain: 'html+css',
            hours: 40,
            startDate: new Date('2016-02-23')
        },
        {
            domain: 'programming',
            subDomain: 'java',
            hours: 23,
            startDate: new Date('2016-06-23')
        },
    ]
    $scope.records = [
        {
            project: $scope.projects[0],
            hours: 3,
            date: '2016-03-23',
            note: 'multi view: ngRoute first time to use. Picking up things took 2 hours..'
        },
        {
            project: $scope.projects[0],
            hours: 3,
            date: '2016-03-23',
            note: 'reading source code: providers are factories. the modules are instantiated and injected when they are used,'
        },
        {
            project: $scope.projects[0],
            hours: 3,
            date: '2016-03-23',
            note: 'multi view: ngRoute; build a simple study recording app'
        },
        {
            project: $scope.projects[0],
            hours: 3,
            date: '2016-03-23',
            note: 'multi view: ngRoute; build a simple study recording app'
        },
        {
            project: $scope.projects[0],
            hours: 3,
            date: '2016-03-23',
            note: 'multi view: ngRoute; build a simple study recording app'
        },

    ];
    $scope.newProject = function() {
        // $scope.newProj.startDate = $scope.startDate.toDate();
        $scope.newProj.startDate = $scope.formValues.startDate.clone().toDate();
        $scope.projects.push(angular.copy($scope.newProj));
    }
})