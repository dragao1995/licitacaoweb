(function () {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
            .state('analisarRequisicoes', {
                    parent: 'requisicoes',
                    url: '/analisarRequisicoes',
                    data: {
                        authorities: ['ROLE_USER'],
                        pageTitle: 'Analisar Requisições'
                    },
                    views: {
                        'content@': {
                            templateUrl: 'app/requisicoes/analisar/analisar.html',
                            controller: 'analisarRequisicoesController',
                            controllerAs: 'vm'
                        }
                    }
                }
            ).state('confirmarAnalise', {
                parent: 'requisicoes',
                url: '/confirmarAnalise',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'Confirmar Analise de Requisições'
                },
                views: {
                    'content@': {
                        templateUrl: 'app/requisicoes/analisar/confirmarAnalise.html',
                        controller: 'analisarRequisicoesController',
                        controllerAs: 'vm'
                    }
                }
            }
        )
        ;
    }
})();
