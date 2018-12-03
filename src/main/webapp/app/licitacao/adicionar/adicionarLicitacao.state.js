(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('adicionarLicitacao', {
            parent: 'licitacao',
            url: '/adicionarLicitacao',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Adicionar Licitacão'
            },
            views: {
                'content@': {
                    templateUrl: 'app/licitacao/adicionar/adicionarLicitacao.html',
                    controller: 'AdicionarLicitacaoController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
