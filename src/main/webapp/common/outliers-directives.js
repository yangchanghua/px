/**
 * Created by ricyang on 16-8-17.
 */
ocApp.directive('modalDialog', function(){
    return {
        templateUrl: 'common/modal-dialog.tpl.html',
        scope: {
            dialogTitle: '@',
            noClose: '@'
        },
        transclude: {
            'body': '?dialogBody',
            'footer': '?dialogFooter'
        },
        replace: true
    }
}).directive('formGroup', function() {
    return {
        templateUrl: 'common/form-group.tpl.html',
        scope: {
            for: '@',
            label: '@'
        },
        transclude: true,
        replace: true
    }
})