(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbContatoDeleteController',TbContatoDeleteController);

    TbContatoDeleteController.$inject = ['$uibModalInstance', 'entity', 'TbContato'];

    function TbContatoDeleteController($uibModalInstance, entity, TbContato) {
        var vm = this;

        vm.tbContato = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            TbContato.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
