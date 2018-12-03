(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbInstituicaoDialogController', TbInstituicaoDialogController);

    TbInstituicaoDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', '$q', 'entity', 'TbInstituicao', 'TbEndereco', 'TbContato', 'TbCabecalho'];

    function TbInstituicaoDialogController ($timeout, $scope, $stateParams, $uibModalInstance, $q, entity, TbInstituicao, TbEndereco, TbContato, TbCabecalho) {
        var vm = this;

        vm.tbInstituicao = entity;
        vm.clear = clear;
        vm.save = save;
        vm.enderecos = TbEndereco.query({filter: 'tbinstituicao-is-null'});
        $q.all([vm.tbInstituicao.$promise, vm.enderecos.$promise]).then(function() {
            if (!vm.tbInstituicao.endereco || !vm.tbInstituicao.endereco.id) {
                return $q.reject();
            }
            return TbEndereco.get({id : vm.tbInstituicao.endereco.id}).$promise;
        }).then(function(endereco) {
            vm.enderecos.push(endereco);
        });
        vm.contatoes = TbContato.query({filter: 'tbinstituicao-is-null'});
        $q.all([vm.tbInstituicao.$promise, vm.contatoes.$promise]).then(function() {
            if (!vm.tbInstituicao.contato || !vm.tbInstituicao.contato.id) {
                return $q.reject();
            }
            return TbContato.get({id : vm.tbInstituicao.contato.id}).$promise;
        }).then(function(contato) {
            vm.contatoes.push(contato);
        });
        vm.tbcabecalhos = TbCabecalho.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.tbInstituicao.id !== null) {
                TbInstituicao.update(vm.tbInstituicao, onSaveSuccess, onSaveError);
            } else {
                TbInstituicao.save(vm.tbInstituicao, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('licitacaoWebApp:tbInstituicaoUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
