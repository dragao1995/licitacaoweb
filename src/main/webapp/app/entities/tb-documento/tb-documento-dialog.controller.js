(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbDocumentoDialogController', TbDocumentoDialogController);

    TbDocumentoDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'DataUtils', 'entity', 'TbDocumento'];

    function TbDocumentoDialogController ($timeout, $scope, $stateParams, $uibModalInstance, DataUtils, entity, TbDocumento) {
        var vm = this;

        vm.tbDocumento = entity;
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
            if (vm.tbDocumento.id !== null) {
                TbDocumento.update(vm.tbDocumento, onSaveSuccess, onSaveError);
            } else {
                TbDocumento.save(vm.tbDocumento, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('licitacaoWebApp:tbDocumentoUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


        vm.setDocumento = function ($file, tbDocumento) {
            if ($file) {
                DataUtils.toBase64($file, function(base64Data) {
                    $scope.$apply(function() {
                        tbDocumento.documento = base64Data;
                        tbDocumento.documentoContentType = $file.type;
                    });
                });
            }
        };

    }
})();
