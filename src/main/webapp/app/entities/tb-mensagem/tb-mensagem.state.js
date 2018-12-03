(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('tb-mensagem', {
            parent: 'entity',
            url: '/tb-mensagem',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbMensagems'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-mensagem/tb-mensagems.html',
                    controller: 'TbMensagemController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('tb-mensagem-detail', {
            parent: 'tb-mensagem',
            url: '/tb-mensagem/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbMensagem'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-mensagem/tb-mensagem-detail.html',
                    controller: 'TbMensagemDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'TbMensagem', function($stateParams, TbMensagem) {
                    return TbMensagem.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'tb-mensagem',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('tb-mensagem-detail.edit', {
            parent: 'tb-mensagem-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-mensagem/tb-mensagem-dialog.html',
                    controller: 'TbMensagemDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbMensagem', function(TbMensagem) {
                            return TbMensagem.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-mensagem.new', {
            parent: 'tb-mensagem',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-mensagem/tb-mensagem-dialog.html',
                    controller: 'TbMensagemDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                dataInicio: null,
                                dataFinal: null,
                                descricao: null,
                                descricaoContentType: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('tb-mensagem', null, { reload: 'tb-mensagem' });
                }, function() {
                    $state.go('tb-mensagem');
                });
            }]
        })
        .state('tb-mensagem.edit', {
            parent: 'tb-mensagem',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-mensagem/tb-mensagem-dialog.html',
                    controller: 'TbMensagemDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbMensagem', function(TbMensagem) {
                            return TbMensagem.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-mensagem', null, { reload: 'tb-mensagem' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-mensagem.delete', {
            parent: 'tb-mensagem',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-mensagem/tb-mensagem-delete-dialog.html',
                    controller: 'TbMensagemDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['TbMensagem', function(TbMensagem) {
                            return TbMensagem.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-mensagem', null, { reload: 'tb-mensagem' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
