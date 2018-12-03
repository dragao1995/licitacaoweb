(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbInstituicaoController', TbInstituicaoController);

    TbInstituicaoController.$inject = ['TbInstituicao', 'TbInstituicaoSearch'];

    function TbInstituicaoController(TbInstituicao, TbInstituicaoSearch) {

        var vm = this;

        vm.tbInstituicaos = [];
        vm.clear = clear;
        vm.search = search;
        vm.loadAll = loadAll;

        loadAll();

        function loadAll() {
            TbInstituicao.query(function(result) {
                vm.tbInstituicaos = result;
                vm.searchQuery = null;
            });
        }

        function search() {
            if (!vm.searchQuery) {
                return vm.loadAll();
            }
            TbInstituicaoSearch.query({query: vm.searchQuery}, function(result) {
                vm.tbInstituicaos = result;
                vm.currentSearch = vm.searchQuery;
            });
        }

        function clear() {
            vm.searchQuery = null;
            loadAll();
        }    }
})();
