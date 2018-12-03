(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('tb-documento', {
            parent: 'entity',
            url: '/tb-documento',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbDocumentos'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-documento/tb-documentos.html',
                    controller: 'TbDocumentoController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('tb-documento-detail', {
            parent: 'tb-documento',
            url: '/tb-documento/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbDocumento'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-documento/tb-documento-detail.html',
                    controller: 'TbDocumentoDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'TbDocumento', function($stateParams, TbDocumento) {
                    return TbDocumento.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'tb-documento',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('tb-documento-detail.edit', {
            parent: 'tb-documento-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-documento/tb-documento-dialog.html',
                    controller: 'TbDocumentoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbDocumento', function(TbDocumento) {
                            return TbDocumento.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-documento.new', {
            parent: 'tb-documento',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-documento/tb-documento-dialog.html',
                    controller: 'TbDocumentoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                documento: null,
                                documentoContentType: null,
                                status: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('tb-documento', null, { reload: 'tb-documento' });
                }, function() {
                    $state.go('tb-documento');
                });
            }]
        })
        .state('tb-documento.edit', {
            parent: 'tb-documento',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-documento/tb-documento-dialog.html',
                    controller: 'TbDocumentoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbDocumento', function(TbDocumento) {
                            return TbDocumento.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-documento', null, { reload: 'tb-documento' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-documento.delete', {
            parent: 'tb-documento',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-documento/tb-documento-delete-dialog.html',
                    controller: 'TbDocumentoDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['TbDocumento', function(TbDocumento) {
                            return TbDocumento.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-documento', null, { reload: 'tb-documento' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
