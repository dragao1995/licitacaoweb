(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbPessoaDetailController', TbPessoaDetailController);

    TbPessoaDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'TbPessoa', 'TbInstituicao', 'TbContato'];

    function TbPessoaDetailController($scope, $rootScope, $stateParams, previousState, entity, TbPessoa, TbInstituicao, TbContato) {
        var vm = this;

        vm.tbPessoa = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('licitacaoWebApp:tbPessoaUpdate', function(event, result) {
            vm.tbPessoa = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
