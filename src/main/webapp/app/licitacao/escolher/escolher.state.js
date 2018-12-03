(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('escolherLicitacao', {
            parent: 'licitacao',
            url: '/escolherLicitacao',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Escolher Licitação'
            },
            views: {
                'content@': {
                    templateUrl: 'app/licitacao/escolher/escolher.html',
                    controller: 'escolherLicitacaoController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
