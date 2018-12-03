(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbDocumentoController', TbDocumentoController);

    TbDocumentoController.$inject = ['DataUtils', 'TbDocumento', 'TbDocumentoSearch'];

    function TbDocumentoController(DataUtils, TbDocumento, TbDocumentoSearch) {

        var vm = this;

        vm.tbDocumentos = [];
        vm.openFile = DataUtils.openFile;
        vm.byteSize = DataUtils.byteSize;
        vm.clear = clear;
        vm.search = search;
        vm.loadAll = loadAll;

        loadAll();

        function loadAll() {
            TbDocumento.query(function(result) {
                vm.tbDocumentos = result;
                vm.searchQuery = null;
            });
        }

        function search() {
            if (!vm.searchQuery) {
                return vm.loadAll();
            }
            TbDocumentoSearch.query({query: vm.searchQuery}, function(result) {
                vm.tbDocumentos = result;
                vm.currentSearch = vm.searchQuery;
            });
        }

        function clear() {
            vm.searchQuery = null;
            loadAll();
        }    }
})();
