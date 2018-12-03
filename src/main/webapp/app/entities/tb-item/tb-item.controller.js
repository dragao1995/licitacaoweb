(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbItemController', TbItemController);

    TbItemController.$inject = ['TbItem', 'TbItemSearch'];

    function TbItemController(TbItem, TbItemSearch) {

        var vm = this;

        vm.tbItems = [];
        vm.clear = clear;
        vm.search = search;
        vm.loadAll = loadAll;

        loadAll();

        function loadAll() {
            TbItem.query(function(result) {
                vm.tbItems = result;
                vm.searchQuery = null;
            });
        }

        function search() {
            if (!vm.searchQuery) {
                return vm.loadAll();
            }
            TbItemSearch.query({query: vm.searchQuery}, function(result) {
                vm.tbItems = result;
                vm.currentSearch = vm.searchQuery;
            });
        }

        function clear() {
            vm.searchQuery = null;
            loadAll();
        }    }
})();
