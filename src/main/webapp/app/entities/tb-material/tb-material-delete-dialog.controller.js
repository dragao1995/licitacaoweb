(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbMaterialDeleteController',TbMaterialDeleteController);

    TbMaterialDeleteController.$inject = ['$uibModalInstance', 'entity', 'TbMaterial'];

    function TbMaterialDeleteController($uibModalInstance, entity, TbMaterial) {
        var vm = this;

        vm.tbMaterial = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            TbMaterial.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
