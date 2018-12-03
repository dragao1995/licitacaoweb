(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbEnderecoController', TbEnderecoController);

    TbEnderecoController.$inject = ['TbEndereco', 'TbEnderecoSearch'];

    function TbEnderecoController(TbEndereco, TbEnderecoSearch) {

        var vm = this;

        vm.tbEnderecos = [];
        vm.clear = clear;
        vm.search = search;
        vm.loadAll = loadAll;

        loadAll();

        function loadAll() {
            TbEndereco.query(function(result) {
                vm.tbEnderecos = result;
                vm.searchQuery = null;
            });
        }

        function search() {
            if (!vm.searchQuery) {
                return vm.loadAll();
            }
            TbEnderecoSearch.query({query: vm.searchQuery}, function(result) {
                vm.tbEnderecos = result;
                vm.currentSearch = vm.searchQuery;
            });
        }

        function clear() {
            vm.searchQuery = null;
            loadAll();
        }    }
})();
