(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('tb-instituicao', {
            parent: 'entity',
            url: '/tb-instituicao',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbInstituicaos'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-instituicao/tb-instituicaos.html',
                    controller: 'TbInstituicaoController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('tb-instituicao-detail', {
            parent: 'tb-instituicao',
            url: '/tb-instituicao/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbInstituicao'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-instituicao/tb-instituicao-detail.html',
                    controller: 'TbInstituicaoDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'TbInstituicao', function($stateParams, TbInstituicao) {
                    return TbInstituicao.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'tb-instituicao',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('tb-instituicao-detail.edit', {
            parent: 'tb-instituicao-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-instituicao/tb-instituicao-dialog.html',
                    controller: 'TbInstituicaoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbInstituicao', function(TbInstituicao) {
                            return TbInstituicao.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-instituicao.new', {
            parent: 'tb-instituicao',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-instituicao/tb-instituicao-dialog.html',
                    controller: 'TbInstituicaoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                nome: null,
                                obeservacao: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('tb-instituicao', null, { reload: 'tb-instituicao' });
                }, function() {
                    $state.go('tb-instituicao');
                });
            }]
        })
        .state('tb-instituicao.edit', {
            parent: 'tb-instituicao',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-instituicao/tb-instituicao-dialog.html',
                    controller: 'TbInstituicaoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbInstituicao', function(TbInstituicao) {
                            return TbInstituicao.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-instituicao', null, { reload: 'tb-instituicao' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-instituicao.delete', {
            parent: 'tb-instituicao',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-instituicao/tb-instituicao-delete-dialog.html',
                    controller: 'TbInstituicaoDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['TbInstituicao', function(TbInstituicao) {
                            return TbInstituicao.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-instituicao', null, { reload: 'tb-instituicao' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
