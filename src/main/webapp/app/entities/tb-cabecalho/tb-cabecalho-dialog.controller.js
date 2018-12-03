(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbCabecalhoDialogController', TbCabecalhoDialogController);

    TbCabecalhoDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'DataUtils', 'entity', 'TbCabecalho'];

    function TbCabecalhoDialogController ($timeout, $scope, $stateParams, $uibModalInstance, DataUtils, entity, TbCabecalho) {
        var vm = this;

        vm.tbCabecalho = entity;
        vm.clear = clear;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;
        vm.save = save;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.tbCabecalho.id !== null) {
                TbCabecalho.update(vm.tbCabecalho, onSaveSuccess, onSaveError);
            } else {
                TbCabecalho.save(vm.tbCabecalho, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('licitacaoWebApp:tbCabecalhoUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


        vm.setCabecalho = function ($file, tbCabecalho) {
            if ($file) {
                DataUtils.toBase64($file, function(base64Data) {
                    $scope.$apply(function() {
                        tbCabecalho.cabecalho = base64Data;
                        tbCabecalho.cabecalhoContentType = $file.type;
                    });
                });
            }
        };

    }
})();
