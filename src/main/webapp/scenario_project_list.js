/**
 * Created by ych on 8/12/16.
 */
describe('Project list', function(){
    it('should list the projects with correct information', function(){
        browser.get('/#records');
        expect(element.all(by.repeater('f in projects')).count()).toEqual(3);
    })
})