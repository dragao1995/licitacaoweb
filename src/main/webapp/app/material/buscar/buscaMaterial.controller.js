(function () {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('buscaMaterialController', buscaMaterialController);

    buscaMaterialController.$inject = ['$scope', 'Principal', 'LoginService', '$state', 'NgTableParams', 'growlMessages', 'MaterialService', 'LazyTableFactory', 'LicitacaoService'];

    function buscaMaterialController($scope, Principal, LoginService, $state, ngTableParams, growlMessages, MaterialService, LazyTableFactory, LicitacaoService) {
        var vm = this;
        vm.filtro = {};
        LicitacaoService.servico = undefined;
        LicitacaoService.material = undefined;

        vm.consultarPorFiltro = _consultarPorFiltro;
        vm.escolher = _escolher;
        vm.voltar = _voltar;

        function _consultarPorFiltro(limparMensagensGrowl) {
            var opts = {
                url: '/api/material/buscar',
                data: {
                    'codigo': vm.filtro.codigo,
                    'descricao': vm.filtro.descricao
                }
            };

            var imprimirMsgPesquisa = true;
            vm.tabelaVO = LazyTableFactory(opts, imprimirMsgPesquisa);
        }

        function _escolher() {
            LicitacaoService.material = vm.selected;
            LicitacaoService.servico = undefined;
            $state.go('escolherLicitacao');
        }

        function _voltar() {
            $state.go('home');
        }

    }
})();
