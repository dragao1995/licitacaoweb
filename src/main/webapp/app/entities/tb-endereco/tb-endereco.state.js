(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('tb-endereco', {
            parent: 'entity',
            url: '/tb-endereco',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbEnderecos'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-endereco/tb-enderecos.html',
                    controller: 'TbEnderecoController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('tb-endereco-detail', {
            parent: 'tb-endereco',
            url: '/tb-endereco/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbEndereco'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-endereco/tb-endereco-detail.html',
                    controller: 'TbEnderecoDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'TbEndereco', function($stateParams, TbEndereco) {
                    return TbEndereco.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'tb-endereco',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('tb-endereco-detail.edit', {
            parent: 'tb-endereco-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-endereco/tb-endereco-dialog.html',
                    controller: 'TbEnderecoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbEndereco', function(TbEndereco) {
                            return TbEndereco.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-endereco.new', {
            parent: 'tb-endereco',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-endereco/tb-endereco-dialog.html',
                    controller: 'TbEnderecoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                uF: null,
                                cidade: null,
                                municipio: null,
                                endereco: null,
                                observacao: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('tb-endereco', null, { reload: 'tb-endereco' });
                }, function() {
                    $state.go('tb-endereco');
                });
            }]
        })
        .state('tb-endereco.edit', {
            parent: 'tb-endereco',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-endereco/tb-endereco-dialog.html',
                    controller: 'TbEnderecoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbEndereco', function(TbEndereco) {
                            return TbEndereco.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-endereco', null, { reload: 'tb-endereco' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-endereco.delete', {
            parent: 'tb-endereco',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-endereco/tb-endereco-delete-dialog.html',
                    controller: 'TbEnderecoDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['TbEndereco', function(TbEndereco) {
                            return TbEndereco.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-endereco', null, { reload: 'tb-endereco' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
