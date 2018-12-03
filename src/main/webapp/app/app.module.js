(function() {
    'use strict';

    angular
        .module('licitacaoWebApp', [
            'ngStorage',
            'ngResource',
            'ngCookies',
            'ngAria',
            'ngCacheBuster',
            'ngFileUpload',
            'ui.bootstrap',
            'ui.bootstrap.datetimepicker',
            'ui.router',
            'infinite-scroll',
            // jhipster-needle-angularjs-add-module JHipster will add new module here
            'angular-loading-bar',
            'ngMaterial',
            'md.data.table',
            'ngAnimate',
            'ngSanitize',
            'ngTable',
            'angular-growl'

        ])
        .run(run);

    run.$inject = ['stateHandler'];

    function run(stateHandler) {
        stateHandler.initialize();
    }
})();

//TESTAR SEM A DIRETIVA LICITACAO DIRETIVA

(function() {
    'use strict';
        angular.module('licitacaoWebApp').config(['$mdDateLocaleProvider', function($mdDateLocaleProvider) {
            $mdDateLocaleProvider.formatDate = function(date) {
                return moment(date).format('DD-MM-YYYY');
            };
        }]);
})();
