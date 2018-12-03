(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('tb-material', {
            parent: 'entity',
            url: '/tb-material',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbMaterials'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-material/tb-materials.html',
                    controller: 'TbMaterialController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('tb-material-detail', {
            parent: 'tb-material',
            url: '/tb-material/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbMaterial'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-material/tb-material-detail.html',
                    controller: 'TbMaterialDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'TbMaterial', function($stateParams, TbMaterial) {
                    return TbMaterial.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'tb-material',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('tb-material-detail.edit', {
            parent: 'tb-material-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-material/tb-material-dialog.html',
                    controller: 'TbMaterialDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbMaterial', function(TbMaterial) {
                            return TbMaterial.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-material.new', {
            parent: 'tb-material',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-material/tb-material-dialog.html',
                    controller: 'TbMaterialDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                codigo: null,
                                descricao: null,
                                status: false,
                                sustentavel: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('tb-material', null, { reload: 'tb-material' });
                }, function() {
                    $state.go('tb-material');
                });
            }]
        })
        .state('tb-material.edit', {
            parent: 'tb-material',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-material/tb-material-dialog.html',
                    controller: 'TbMaterialDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbMaterial', function(TbMaterial) {
                            return TbMaterial.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-material', null, { reload: 'tb-material' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-material.delete', {
            parent: 'tb-material',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-material/tb-material-delete-dialog.html',
                    controller: 'TbMaterialDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['TbMaterial', function(TbMaterial) {
                            return TbMaterial.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-material', null, { reload: 'tb-material' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
