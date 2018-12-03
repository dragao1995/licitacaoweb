(function () {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
            .state('repostaRequisicao', {
                    parent: 'requisicoes',
                    url: '/repostaRequisicao',
                    data: {
                        authorities: ['ROLE_USER'],
                        pageTitle: 'Reposta Requisições'
                    },
                    views: {
                        'content@': {
                            templateUrl: 'app/requisicoes/resposta/resposta.html',
                            controller: 'analisarRequisicoesController',
                            controllerAs: 'vm'
                        }
                    }
            });
    }
})();
