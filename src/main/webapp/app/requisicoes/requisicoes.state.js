(function () {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('requisicoes', {
            abstract: true,
            parent: 'app'
        });
    }
})();
