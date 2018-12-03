(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('tb-pessoa', {
            parent: 'entity',
            url: '/tb-pessoa',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbPessoas'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-pessoa/tb-pessoas.html',
                    controller: 'TbPessoaController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('tb-pessoa-detail', {
            parent: 'tb-pessoa',
            url: '/tb-pessoa/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'TbPessoa'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/tb-pessoa/tb-pessoa-detail.html',
                    controller: 'TbPessoaDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'TbPessoa', function($stateParams, TbPessoa) {
                    return TbPessoa.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'tb-pessoa',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('tb-pessoa-detail.edit', {
            parent: 'tb-pessoa-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-pessoa/tb-pessoa-dialog.html',
                    controller: 'TbPessoaDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbPessoa', function(TbPessoa) {
                            return TbPessoa.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-pessoa.new', {
            parent: 'tb-pessoa',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-pessoa/tb-pessoa-dialog.html',
                    controller: 'TbPessoaDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                nome: null,
                                login: null,
                                senha: null,
                                telefone: null,
                                tipo: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('tb-pessoa', null, { reload: 'tb-pessoa' });
                }, function() {
                    $state.go('tb-pessoa');
                });
            }]
        })
        .state('tb-pessoa.edit', {
            parent: 'tb-pessoa',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-pessoa/tb-pessoa-dialog.html',
                    controller: 'TbPessoaDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['TbPessoa', function(TbPessoa) {
                            return TbPessoa.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-pessoa', null, { reload: 'tb-pessoa' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('tb-pessoa.delete', {
            parent: 'tb-pessoa',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/tb-pessoa/tb-pessoa-delete-dialog.html',
                    controller: 'TbPessoaDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['TbPessoa', function(TbPessoa) {
                            return TbPessoa.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('tb-pessoa', null, { reload: 'tb-pessoa' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
