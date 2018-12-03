(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbItemDetailController', TbItemDetailController);

    TbItemDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'TbItem', 'TbLicitacao', 'TbServico', 'TbMaterial'];

    function TbItemDetailController($scope, $rootScope, $stateParams, previousState, entity, TbItem, TbLicitacao, TbServico, TbMaterial) {
        var vm = this;

        vm.tbItem = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('licitacaoWebApp:tbItemUpdate', function(event, result) {
            vm.tbItem = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
