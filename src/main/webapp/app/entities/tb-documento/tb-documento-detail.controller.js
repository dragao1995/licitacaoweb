(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbDocumentoDetailController', TbDocumentoDetailController);

    TbDocumentoDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'DataUtils', 'entity', 'TbDocumento'];

    function TbDocumentoDetailController($scope, $rootScope, $stateParams, previousState, DataUtils, entity, TbDocumento) {
        var vm = this;

        vm.tbDocumento = entity;
        vm.previousState = previousState.name;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;

        var unsubscribe = $rootScope.$on('licitacaoWebApp:tbDocumentoUpdate', function(event, result) {
            vm.tbDocumento = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
