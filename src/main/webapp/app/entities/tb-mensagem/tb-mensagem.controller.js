(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbMensagemController', TbMensagemController);

    TbMensagemController.$inject = ['DataUtils', 'TbMensagem', 'TbMensagemSearch'];

    function TbMensagemController(DataUtils, TbMensagem, TbMensagemSearch) {

        var vm = this;

        vm.tbMensagems = [];
        vm.openFile = DataUtils.openFile;
        vm.byteSize = DataUtils.byteSize;
        vm.clear = clear;
        vm.search = search;
        vm.loadAll = loadAll;

        loadAll();

        function loadAll() {
            TbMensagem.query(function(result) {
                vm.tbMensagems = result;
                vm.searchQuery = null;
            });
        }

        function search() {
            if (!vm.searchQuery) {
                return vm.loadAll();
            }
            TbMensagemSearch.query({query: vm.searchQuery}, function(result) {
                vm.tbMensagems = result;
                vm.currentSearch = vm.searchQuery;
            });
        }

        function clear() {
            vm.searchQuery = null;
            loadAll();
        }    }
})();
