(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbMaterialDetailController', TbMaterialDetailController);

    TbMaterialDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'TbMaterial'];

    function TbMaterialDetailController($scope, $rootScope, $stateParams, previousState, entity, TbMaterial) {
        var vm = this;

        vm.tbMaterial = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('licitacaoWebApp:tbMaterialUpdate', function(event, result) {
            vm.tbMaterial = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
