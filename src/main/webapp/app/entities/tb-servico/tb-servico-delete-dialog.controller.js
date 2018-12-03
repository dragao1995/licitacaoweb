(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbServicoDeleteController',TbServicoDeleteController);

    TbServicoDeleteController.$inject = ['$uibModalInstance', 'entity', 'TbServico'];

    function TbServicoDeleteController($uibModalInstance, entity, TbServico) {
        var vm = this;

        vm.tbServico = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            TbServico.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
