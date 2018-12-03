(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('tb-licitacao', {
            parent: 'entity',
            url: '/tb-licitacao',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbLicitacaos'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-licitacao/tb-licitacaos.html',
                    controller: 'TbLicitacaoController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('tb-licitacao-detail', {
            parent: 'tb-licitacao',
            url: '/tb-licitacao/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbLicitacao'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-licitacao/tb-licitacao-detail.html',
                    controller: 'TbLicitacaoDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'TbLicitacao', function($stateParams, TbLicitacao) {
                    return TbLicitacao.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'tb-licitacao',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('tb-licitacao-detail.edit', {
            parent: 'tb-licitacao-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-licitacao/tb-licitacao-dialog.html',
                    controller: 'TbLicitacaoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbLicitacao', function(TbLicitacao) {
                            return TbLicitacao.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-licitacao.new', {
            parent: 'tb-licitacao',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-licitacao/tb-licitacao-dialog.html',
                    controller: 'TbLicitacaoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                uasg: null,
                                modalidade: null,
                                funcaoResponsavel: null,
                                identificador: null,
                                situacaoAviso: null,
                                objeto: null,
                                informcoesGerais: null,
                                numeroProcesso: null,
                                tipoRecurso: null,
                                numeroItens: null,
                                dataPublicacao: null,
                                dataEntregaedital: null,
                                nomeResponsavel: null,
                                enderecoEntregaEdital: null,
                                dataEntregaProposta: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('tb-licitacao', null, { reload: 'tb-licitacao' });
                }, function() {
                    $state.go('tb-licitacao');
                });
            }]
        })
        .state('tb-licitacao.edit', {
            parent: 'tb-licitacao',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-licitacao/tb-licitacao-dialog.html',
                    controller: 'TbLicitacaoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbLicitacao', function(TbLicitacao) {
                            return TbLicitacao.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-licitacao', null, { reload: 'tb-licitacao' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-licitacao.delete', {
            parent: 'tb-licitacao',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-licitacao/tb-licitacao-delete-dialog.html',
                    controller: 'TbLicitacaoDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['TbLicitacao', function(TbLicitacao) {
                            return TbLicitacao.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-licitacao', null, { reload: 'tb-licitacao' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
