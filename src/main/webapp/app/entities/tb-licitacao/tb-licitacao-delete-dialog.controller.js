(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbLicitacaoDeleteController',TbLicitacaoDeleteController);

    TbLicitacaoDeleteController.$inject = ['$uibModalInstance', 'entity', 'TbLicitacao'];

    function TbLicitacaoDeleteController($uibModalInstance, entity, TbLicitacao) {
        var vm = this;

        vm.tbLicitacao = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            TbLicitacao.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
