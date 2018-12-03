(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbMaterialDialogController', TbMaterialDialogController);

    TbMaterialDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'TbMaterial'];

    function TbMaterialDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, TbMaterial) {
        var vm = this;

        vm.tbMaterial = entity;
        vm.clear = clear;
        vm.save = save;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.tbMaterial.id !== null) {
                TbMaterial.update(vm.tbMaterial, onSaveSuccess, onSaveError);
            } else {
                TbMaterial.save(vm.tbMaterial, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('licitacaoWebApp:tbMaterialUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
