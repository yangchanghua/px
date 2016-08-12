/**
 * Created by ych on 8/12/16.
 */

exports.config = {
    framework: 'jasmine',
    seleniumAddress: 'http://localhost:4444/wd/hub',
    baseUrl: 'http://localhost:8080',
    specs: ['scenario_project_list.js'],
    capabilities: {
        browserName: 'chrome'
    }
}