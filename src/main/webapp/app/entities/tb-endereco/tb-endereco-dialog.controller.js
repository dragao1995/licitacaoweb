(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbEnderecoDialogController', TbEnderecoDialogController);

    TbEnderecoDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'TbEndereco'];

    function TbEnderecoDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, TbEndereco) {
        var vm = this;

        vm.tbEndereco = entity;
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
            if (vm.tbEndereco.id !== null) {
                TbEndereco.update(vm.tbEndereco, onSaveSuccess, onSaveError);
            } else {
                TbEndereco.save(vm.tbEndereco, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('licitacaoWebApp:tbEnderecoUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
