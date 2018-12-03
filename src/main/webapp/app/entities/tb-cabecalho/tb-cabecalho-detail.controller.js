(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbCabecalhoDetailController', TbCabecalhoDetailController);

    TbCabecalhoDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'DataUtils', 'entity', 'TbCabecalho'];

    function TbCabecalhoDetailController($scope, $rootScope, $stateParams, previousState, DataUtils, entity, TbCabecalho) {
        var vm = this;

        vm.tbCabecalho = entity;
        vm.previousState = previousState.name;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;

        var unsubscribe = $rootScope.$on('licitacaoWebApp:tbCabecalhoUpdate', function(event, result) {
            vm.tbCabecalho = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
