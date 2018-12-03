(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('quantidade', {
            parent: 'licitacao',
            url: '/quantidade',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Quantidade'
            },
            views: {
                'content@': {
                    templateUrl: 'app/licitacao/quantidade/quantidade.html',
                    controller: 'QuantidadeController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
