(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('PesquisarAtas', {
            parent: 'atas',
            url: '/PesquisarAtas',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Pesquisar Atas'
            },
            views: {
                'content@': {
                    templateUrl: 'app/atas/pesquisa/atasPregao.html',
                    controller: 'PesquisarAtasController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
