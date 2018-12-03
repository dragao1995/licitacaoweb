(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbCabecalhoDeleteController',TbCabecalhoDeleteController);

    TbCabecalhoDeleteController.$inject = ['$uibModalInstance', 'entity', 'TbCabecalho'];

    function TbCabecalhoDeleteController($uibModalInstance, entity, TbCabecalho) {
        var vm = this;

        vm.tbCabecalho = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            TbCabecalho.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
