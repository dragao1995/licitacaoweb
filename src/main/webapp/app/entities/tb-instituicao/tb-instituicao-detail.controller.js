(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbInstituicaoDetailController', TbInstituicaoDetailController);

    TbInstituicaoDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'TbInstituicao', 'TbEndereco', 'TbContato', 'TbCabecalho'];

    function TbInstituicaoDetailController($scope, $rootScope, $stateParams, previousState, entity, TbInstituicao, TbEndereco, TbContato, TbCabecalho) {
        var vm = this;

        vm.tbInstituicao = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('licitacaoWebApp:tbInstituicaoUpdate', function(event, result) {
            vm.tbInstituicao = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
