(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbMensagemDialogController', TbMensagemDialogController);

    TbMensagemDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', '$q', 'DataUtils', 'entity', 'TbMensagem', 'TbLicitacao', 'TbCabecalho', 'TbDocumento'];

    function TbMensagemDialogController ($timeout, $scope, $stateParams, $uibModalInstance, $q, DataUtils, entity, TbMensagem, TbLicitacao, TbCabecalho, TbDocumento) {
        var vm = this;

        vm.tbMensagem = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;
        vm.save = save;
        vm.licitacaos = TbLicitacao.query({filter: 'tbmensagem-is-null'});
        $q.all([vm.tbMensagem.$promise, vm.licitacaos.$promise]).then(function() {
            if (!vm.tbMensagem.licitacao || !vm.tbMensagem.licitacao.id) {
                return $q.reject();
            }
            return TbLicitacao.get({id : vm.tbMensagem.licitacao.id}).$promise;
        }).then(function(licitacao) {
            vm.licitacaos.push(licitacao);
        });
        vm.mensagems = TbMensagem.query({filter: 'tbmensagem-is-null'});
        $q.all([vm.tbMensagem.$promise, vm.mensagems.$promise]).then(function() {
            if (!vm.tbMensagem.mensagem || !vm.tbMensagem.mensagem.id) {
                return $q.reject();
            }
            return TbMensagem.get({id : vm.tbMensagem.mensagem.id}).$promise;
        }).then(function(mensagem) {
            vm.mensagems.push(mensagem);
        });
        vm.tbcabecalhos = TbCabecalho.query();
        vm.tbdocumentos = TbDocumento.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.tbMensagem.id !== null) {
                TbMensagem.update(vm.tbMensagem, onSaveSuccess, onSaveError);
            } else {
                TbMensagem.save(vm.tbMensagem, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('licitacaoWebApp:tbMensagemUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.dataInicio = false;
        vm.datePickerOpenStatus.dataFinal = false;

        vm.setDescricao = function ($file, tbMensagem) {
            if ($file) {
                DataUtils.toBase64($file, function(base64Data) {
                    $scope.$apply(function() {
                        tbMensagem.descricao = base64Data;
                        tbMensagem.descricaoContentType = $file.type;
                    });
                });
            }
        };

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
