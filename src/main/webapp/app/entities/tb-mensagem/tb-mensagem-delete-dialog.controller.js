(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbMensagemDeleteController',TbMensagemDeleteController);

    TbMensagemDeleteController.$inject = ['$uibModalInstance', 'entity', 'TbMensagem'];

    function TbMensagemDeleteController($uibModalInstance, entity, TbMensagem) {
        var vm = this;

        vm.tbMensagem = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            TbMensagem.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
