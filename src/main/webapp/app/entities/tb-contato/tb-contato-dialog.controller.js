(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbContatoDialogController', TbContatoDialogController);

    TbContatoDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'TbContato'];

    function TbContatoDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, TbContato) {
        var vm = this;

        vm.tbContato = entity;
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
            if (vm.tbContato.id !== null) {
                TbContato.update(vm.tbContato, onSaveSuccess, onSaveError);
            } else {
                TbContato.save(vm.tbContato, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('licitacaoWebApp:tbContatoUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
