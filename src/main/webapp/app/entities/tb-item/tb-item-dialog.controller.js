(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbItemDialogController', TbItemDialogController);

    TbItemDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'TbItem', 'TbLicitacao', 'TbServico', 'TbMaterial'];

    function TbItemDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, TbItem, TbLicitacao, TbServico, TbMaterial) {
        var vm = this;

        vm.tbItem = entity;
        vm.clear = clear;
        vm.save = save;
        vm.tblicitacaos = TbLicitacao.query();
        vm.tbservicos = TbServico.query();
        vm.tbmaterials = TbMaterial.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.tbItem.id !== null) {
                TbItem.update(vm.tbItem, onSaveSuccess, onSaveError);
            } else {
                TbItem.save(vm.tbItem, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('licitacaoWebApp:tbItemUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
