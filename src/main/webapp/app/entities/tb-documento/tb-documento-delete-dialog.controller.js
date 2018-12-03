(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbDocumentoDeleteController',TbDocumentoDeleteController);

    TbDocumentoDeleteController.$inject = ['$uibModalInstance', 'entity', 'TbDocumento'];

    function TbDocumentoDeleteController($uibModalInstance, entity, TbDocumento) {
        var vm = this;

        vm.tbDocumento = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            TbDocumento.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
