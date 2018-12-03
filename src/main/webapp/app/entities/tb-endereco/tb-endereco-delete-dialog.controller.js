(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbEnderecoDeleteController',TbEnderecoDeleteController);

    TbEnderecoDeleteController.$inject = ['$uibModalInstance', 'entity', 'TbEndereco'];

    function TbEnderecoDeleteController($uibModalInstance, entity, TbEndereco) {
        var vm = this;

        vm.tbEndereco = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            TbEndereco.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
