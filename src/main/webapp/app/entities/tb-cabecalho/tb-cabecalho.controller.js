(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbCabecalhoController', TbCabecalhoController);

    TbCabecalhoController.$inject = ['DataUtils', 'TbCabecalho', 'TbCabecalhoSearch'];

    function TbCabecalhoController(DataUtils, TbCabecalho, TbCabecalhoSearch) {

        var vm = this;

        vm.tbCabecalhos = [];
        vm.openFile = DataUtils.openFile;
        vm.byteSize = DataUtils.byteSize;
        vm.clear = clear;
        vm.search = search;
        vm.loadAll = loadAll;

        loadAll();

        function loadAll() {
            TbCabecalho.query(function(result) {
                vm.tbCabecalhos = result;
                vm.searchQuery = null;
            });
        }

        function search() {
            if (!vm.searchQuery) {
                return vm.loadAll();
            }
            TbCabecalhoSearch.query({query: vm.searchQuery}, function(result) {
                vm.tbCabecalhos = result;
                vm.currentSearch = vm.searchQuery;
            });
        }

        function clear() {
            vm.searchQuery = null;
            loadAll();
        }    }
})();
