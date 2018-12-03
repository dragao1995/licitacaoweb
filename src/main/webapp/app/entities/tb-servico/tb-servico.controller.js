(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbServicoController', TbServicoController);

    TbServicoController.$inject = ['TbServico', 'TbServicoSearch'];

    function TbServicoController(TbServico, TbServicoSearch) {

        var vm = this;

        vm.tbServicos = [];
        vm.clear = clear;
        vm.search = search;
        vm.loadAll = loadAll;

        loadAll();

        function loadAll() {
            TbServico.query(function(result) {
                vm.tbServicos = result;
                vm.searchQuery = null;
            });
        }

        function search() {
            if (!vm.searchQuery) {
                return vm.loadAll();
            }
            TbServicoSearch.query({query: vm.searchQuery}, function(result) {
                vm.tbServicos = result;
                vm.currentSearch = vm.searchQuery;
            });
        }

        function clear() {
            vm.searchQuery = null;
            loadAll();
        }    }
})();
