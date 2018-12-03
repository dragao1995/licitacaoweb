(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbMaterialController', TbMaterialController);

    TbMaterialController.$inject = ['TbMaterial', 'TbMaterialSearch'];

    function TbMaterialController(TbMaterial, TbMaterialSearch) {

        var vm = this;

        vm.tbMaterials = [];
        vm.clear = clear;
        vm.search = search;
        vm.loadAll = loadAll;

        loadAll();

        function loadAll() {
            TbMaterial.query(function(result) {
                vm.tbMaterials = result;
                vm.searchQuery = null;
            });
        }

        function search() {
            if (!vm.searchQuery) {
                return vm.loadAll();
            }
            TbMaterialSearch.query({query: vm.searchQuery}, function(result) {
                vm.tbMaterials = result;
                vm.currentSearch = vm.searchQuery;
            });
        }

        function clear() {
            vm.searchQuery = null;
            loadAll();
        }    }
})();
