(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbPessoaController', TbPessoaController);

    TbPessoaController.$inject = ['TbPessoa', 'TbPessoaSearch'];

    function TbPessoaController(TbPessoa, TbPessoaSearch) {

        var vm = this;

        vm.tbPessoas = [];
        vm.clear = clear;
        vm.search = search;
        vm.loadAll = loadAll;

        loadAll();

        function loadAll() {
            TbPessoa.query(function(result) {
                vm.tbPessoas = result;
                vm.searchQuery = null;
            });
        }

        function search() {
            if (!vm.searchQuery) {
                return vm.loadAll();
            }
            TbPessoaSearch.query({query: vm.searchQuery}, function(result) {
                vm.tbPessoas = result;
                vm.currentSearch = vm.searchQuery;
            });
        }

        function clear() {
            vm.searchQuery = null;
            loadAll();
        }    }
})();
