(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbInstituicaoDeleteController',TbInstituicaoDeleteController);

    TbInstituicaoDeleteController.$inject = ['$uibModalInstance', 'entity', 'TbInstituicao'];

    function TbInstituicaoDeleteController($uibModalInstance, entity, TbInstituicao) {
        var vm = this;

        vm.tbInstituicao = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            TbInstituicao.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
