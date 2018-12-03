(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbItemDeleteController',TbItemDeleteController);

    TbItemDeleteController.$inject = ['$uibModalInstance', 'entity', 'TbItem'];

    function TbItemDeleteController($uibModalInstance, entity, TbItem) {
        var vm = this;

        vm.tbItem = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            TbItem.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
