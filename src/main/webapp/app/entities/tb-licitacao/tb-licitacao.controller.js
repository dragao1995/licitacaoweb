(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbLicitacaoController', TbLicitacaoController);

    TbLicitacaoController.$inject = ['TbLicitacao', 'TbLicitacaoSearch'];

    function TbLicitacaoController(TbLicitacao, TbLicitacaoSearch) {

        var vm = this;

        vm.tbLicitacaos = [];
        vm.clear = clear;
        vm.search = search;
        vm.loadAll = loadAll;

        loadAll();

        function loadAll() {
            TbLicitacao.query(function(result) {
                vm.tbLicitacaos = result;
                vm.searchQuery = null;
            });
        }

        function search() {
            if (!vm.searchQuery) {
                return vm.loadAll();
            }
            TbLicitacaoSearch.query({query: vm.searchQuery}, function(result) {
                vm.tbLicitacaos = result;
                vm.currentSearch = vm.searchQuery;
            });
        }

        function clear() {
            vm.searchQuery = null;
            loadAll();
        }    }
})();
