/**
 * Created by ych on 8/11/16.
 */
ocApp.controller('StudyRecordsCtrl', function StudyRecordsCtrl($scope, $http, $log) {
    $scope.newProj = {};
    $scope.newPractice = {
        project: 0,
        hours: 3,
        date: moment(),
        note: 'bootstrap dialog,form,button;angular-datepicker;moment v.s. date'
    };
    $scope.formValues = {
        startDate: moment()
    };
    $scope.today = moment();
    $scope.getProjects = function () {
        $http.get('http://localhost:8080/rest/ocs/list')
            .then(
                function successCallback(response) {
                    if (response.data) {
                        response.data.forEach(function (e, i, a) {
                            //$log.log(e);
                            $scope.projects.unshift(e);
                        })
                    }
                }, function errorCallback(response) {
                    $log.error('cannot fetch projects' + response);
                });
    };
    $scope.doNewProject = function (project) {
        $http.post('http://localhost:8080/rest/ocs/new', project)
            .then(function successCallback(response) {
                project.id = response.data;
                $scope.projects.push(angular.copy(project));
            })
    }
    $scope.projects = [];
    $scope.getProjects();

    $scope.defaultProjects = [
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
    $scope.newProject = function () {
        // $scope.newProj.startDate = $scope.startDate.toDate();
        $scope.newProj.startDate = $scope.formValues.startDate.clone().toDate();
        $scope.doNewProject($scope.newProj);
    }
    $scope.addPractice = function () {
        $log.log($scope.newPractice.project);
        $scope.records.unshift(
            {
                project: $scope.projects[$scope.newPractice.project],
                hours: $scope.newPractice.hours,
                date: $scope.newPractice.date.clone().toDate(),
                note: $scope.newPractice.note
            }
        )
    }
    $scope.deleteProject = function (p) {
        $http.get('http://localhost:8080/rest/ocs/delete/' + p.id)
            .then(function success(response) {
                $log.log(response.data);
                var index = $scope.projects.indexOf(p)
                if (index > -1) {
                    $scope.projects.splice(index, 1);
                }
            })
    }
})