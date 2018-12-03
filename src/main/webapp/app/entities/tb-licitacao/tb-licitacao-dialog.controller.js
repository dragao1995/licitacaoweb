(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbLicitacaoDialogController', TbLicitacaoDialogController);

    TbLicitacaoDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'TbLicitacao'];

    function TbLicitacaoDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, TbLicitacao) {
        var vm = this;

        vm.tbLicitacao = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.tbLicitacao.id !== null) {
                TbLicitacao.update(vm.tbLicitacao, onSaveSuccess, onSaveError);
            } else {
                TbLicitacao.save(vm.tbLicitacao, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('licitacaoWebApp:tbLicitacaoUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.dataPublicacao = false;
        vm.datePickerOpenStatus.dataEntregaedital = false;
        vm.datePickerOpenStatus.dataEntregaProposta = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
