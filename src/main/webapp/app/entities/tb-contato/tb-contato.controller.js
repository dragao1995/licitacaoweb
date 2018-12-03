(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbContatoController', TbContatoController);

    TbContatoController.$inject = ['TbContato', 'TbContatoSearch'];

    function TbContatoController(TbContato, TbContatoSearch) {

        var vm = this;

        vm.tbContatoes = [];
        vm.clear = clear;
        vm.search = search;
        vm.loadAll = loadAll;

        loadAll();

        function loadAll() {
            TbContato.query(function(result) {
                vm.tbContatoes = result;
                vm.searchQuery = null;
            });
        }

        function search() {
            if (!vm.searchQuery) {
                return vm.loadAll();
            }
            TbContatoSearch.query({query: vm.searchQuery}, function(result) {
                vm.tbContatoes = result;
                vm.currentSearch = vm.searchQuery;
            });
        }

        function clear() {
            vm.searchQuery = null;
            loadAll();
        }    }
})();
