(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbPessoaDialogController', TbPessoaDialogController);

    TbPessoaDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'TbPessoa', 'TbInstituicao', 'TbContato'];

    function TbPessoaDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, TbPessoa, TbInstituicao, TbContato) {
        var vm = this;

        vm.tbPessoa = entity;
        vm.clear = clear;
        vm.save = save;
        vm.tbinstituicaos = TbInstituicao.query();
        vm.tbcontatoes = TbContato.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.tbPessoa.id !== null) {
                TbPessoa.update(vm.tbPessoa, onSaveSuccess, onSaveError);
            } else {
                TbPessoa.save(vm.tbPessoa, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('licitacaoWebApp:tbPessoaUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
