(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('atualizar-dados', {
            parent: 'admin',
            url: '/atualizar-dados',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Atualizar Dados'
            },
            views: {
                'content@': {
                    templateUrl: 'app/admin/atualizar-dados/atualizar-dados.html',
                    controller: 'AtualizarDadosController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
