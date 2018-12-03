(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('buscarServico', {
            parent: 'servico',
            url: '/buscarServico',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Buscar Serviço'
            },
            views: {
                'content@': {
                    templateUrl: 'app/servico/buscar/buscaServico.html',
                    controller: 'buscarServicoController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
