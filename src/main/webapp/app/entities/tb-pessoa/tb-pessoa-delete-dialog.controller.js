(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbPessoaDeleteController',TbPessoaDeleteController);

    TbPessoaDeleteController.$inject = ['$uibModalInstance', 'entity', 'TbPessoa'];

    function TbPessoaDeleteController($uibModalInstance, entity, TbPessoa) {
        var vm = this;

        vm.tbPessoa = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            TbPessoa.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
