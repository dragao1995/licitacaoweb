(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('tb-contato', {
            parent: 'entity',
            url: '/tb-contato',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbContatoes'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-contato/tb-contatoes.html',
                    controller: 'TbContatoController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('tb-contato-detail', {
            parent: 'tb-contato',
            url: '/tb-contato/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbContato'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-contato/tb-contato-detail.html',
                    controller: 'TbContatoDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'TbContato', function($stateParams, TbContato) {
                    return TbContato.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'tb-contato',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('tb-contato-detail.edit', {
            parent: 'tb-contato-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-contato/tb-contato-dialog.html',
                    controller: 'TbContatoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbContato', function(TbContato) {
                            return TbContato.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-contato.new', {
            parent: 'tb-contato',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-contato/tb-contato-dialog.html',
                    controller: 'TbContatoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                email: null,
                                telefone: null,
                                contato: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('tb-contato', null, { reload: 'tb-contato' });
                }, function() {
                    $state.go('tb-contato');
                });
            }]
        })
        .state('tb-contato.edit', {
            parent: 'tb-contato',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-contato/tb-contato-dialog.html',
                    controller: 'TbContatoDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbContato', function(TbContato) {
                            return TbContato.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-contato', null, { reload: 'tb-contato' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-contato.delete', {
            parent: 'tb-contato',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-contato/tb-contato-delete-dialog.html',
                    controller: 'TbContatoDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['TbContato', function(TbContato) {
                            return TbContato.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-contato', null, { reload: 'tb-contato' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
