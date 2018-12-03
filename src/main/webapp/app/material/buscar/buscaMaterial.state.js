(function () {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('buscarMaterial', {
            parent: 'material',
            url: '/buscarMaterial',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Buscar Material'
            },
            views: {
                'content@': {
                    templateUrl: 'app/material/buscar/buscaMaterial.html',
                    controller: 'buscaMaterialController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
