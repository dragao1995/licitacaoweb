(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbServicoDialogController', TbServicoDialogController);

    TbServicoDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'TbServico'];

    function TbServicoDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, TbServico) {
        var vm = this;

        vm.tbServico = entity;
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
            if (vm.tbServico.id !== null) {
                TbServico.update(vm.tbServico, onSaveSuccess, onSaveError);
            } else {
                TbServico.save(vm.tbServico, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('licitacaoWebApp:tbServicoUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
