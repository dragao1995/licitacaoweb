(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('tb-servico', {
            parent: 'entity',
            url: '/tb-servico',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbServicos'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-servico/tb-servicos.html',
                    controller: 'TbServicoController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('tb-servico-detail', {
            parent: 'tb-servico',
            url: '/tb-servico/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbServico'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-servico/tb-servico-detail.html',
                    controller: 'TbServicoDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'TbServico', function($stateParams, TbServico) {
                    return TbServico.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'tb-servico',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('tb-servico-detail.edit', {
            parent: 'tb-servico-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-servico/tb-servico-dialog.html',
                    controller: 'TbServicoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbServico', function(TbServico) {
                            return TbServico.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-servico.new', {
            parent: 'tb-servico',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-servico/tb-servico-dialog.html',
                    controller: 'TbServicoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                codigo: null,
                                descricao: null,
                                unidadeMedida: null,
                                cpc: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('tb-servico', null, { reload: 'tb-servico' });
                }, function() {
                    $state.go('tb-servico');
                });
            }]
        })
        .state('tb-servico.edit', {
            parent: 'tb-servico',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-servico/tb-servico-dialog.html',
                    controller: 'TbServicoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbServico', function(TbServico) {
                            return TbServico.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-servico', null, { reload: 'tb-servico' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-servico.delete', {
            parent: 'tb-servico',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-servico/tb-servico-delete-dialog.html',
                    controller: 'TbServicoDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['TbServico', function(TbServico) {
                            return TbServico.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-servico', null, { reload: 'tb-servico' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
