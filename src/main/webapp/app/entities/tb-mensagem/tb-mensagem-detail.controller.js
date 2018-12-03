(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbMensagemDetailController', TbMensagemDetailController);

    TbMensagemDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'DataUtils', 'entity', 'TbMensagem', 'TbLicitacao', 'TbCabecalho', 'TbDocumento'];

    function TbMensagemDetailController($scope, $rootScope, $stateParams, previousState, DataUtils, entity, TbMensagem, TbLicitacao, TbCabecalho, TbDocumento) {
        var vm = this;

        vm.tbMensagem = entity;
        vm.previousState = previousState.name;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;

        var unsubscribe = $rootScope.$on('licitacaoWebApp:tbMensagemUpdate', function(event, result) {
            vm.tbMensagem = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
