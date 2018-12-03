(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('tb-item', {
            parent: 'entity',
            url: '/tb-item',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbItems'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-item/tb-items.html',
                    controller: 'TbItemController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('tb-item-detail', {
            parent: 'tb-item',
            url: '/tb-item/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbItem'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-item/tb-item-detail.html',
                    controller: 'TbItemDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'TbItem', function($stateParams, TbItem) {
                    return TbItem.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'tb-item',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('tb-item-detail.edit', {
            parent: 'tb-item-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-item/tb-item-dialog.html',
                    controller: 'TbItemDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbItem', function(TbItem) {
                            return TbItem.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-item.new', {
            parent: 'tb-item',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-item/tb-item-dialog.html',
                    controller: 'TbItemDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                uasg: null,
                                codigoItemMaterial: null,
                                codigoItemServico: null,
                                descricaoItem: null,
                                numeroLicitacao: null,
                                quantidade: null,
                                unidade: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('tb-item', null, { reload: 'tb-item' });
                }, function() {
                    $state.go('tb-item');
                });
            }]
        })
        .state('tb-item.edit', {
            parent: 'tb-item',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-item/tb-item-dialog.html',
                    controller: 'TbItemDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbItem', function(TbItem) {
                            return TbItem.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-item', null, { reload: 'tb-item' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-item.delete', {
            parent: 'tb-item',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-item/tb-item-delete-dialog.html',
                    controller: 'TbItemDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['TbItem', function(TbItem) {
                            return TbItem.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-item', null, { reload: 'tb-item' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
