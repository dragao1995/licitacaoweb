(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('tb-cabecalho', {
            parent: 'entity',
            url: '/tb-cabecalho',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbCabecalhos'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-cabecalho/tb-cabecalhos.html',
                    controller: 'TbCabecalhoController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('tb-cabecalho-detail', {
            parent: 'tb-cabecalho',
            url: '/tb-cabecalho/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbCabecalho'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-cabecalho/tb-cabecalho-detail.html',
                    controller: 'TbCabecalhoDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'TbCabecalho', function($stateParams, TbCabecalho) {
                    return TbCabecalho.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'tb-cabecalho',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('tb-cabecalho-detail.edit', {
            parent: 'tb-cabecalho-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-cabecalho/tb-cabecalho-dialog.html',
                    controller: 'TbCabecalhoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbCabecalho', function(TbCabecalho) {
                            return TbCabecalho.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-cabecalho.new', {
            parent: 'tb-cabecalho',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-cabecalho/tb-cabecalho-dialog.html',
                    controller: 'TbCabecalhoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                cabecalho: null,
                                cabecalhoContentType: null,
                                iniciado: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('tb-cabecalho', null, { reload: 'tb-cabecalho' });
                }, function() {
                    $state.go('tb-cabecalho');
                });
            }]
        })
        .state('tb-cabecalho.edit', {
            parent: 'tb-cabecalho',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-cabecalho/tb-cabecalho-dialog.html',
                    controller: 'TbCabecalhoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbCabecalho', function(TbCabecalho) {
                            return TbCabecalho.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-cabecalho', null, { reload: 'tb-cabecalho' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-cabecalho.delete', {
            parent: 'tb-cabecalho',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-cabecalho/tb-cabecalho-delete-dialog.html',
                    controller: 'TbCabecalhoDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['TbCabecalho', function(TbCabecalho) {
                            return TbCabecalho.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-cabecalho', null, { reload: 'tb-cabecalho' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
