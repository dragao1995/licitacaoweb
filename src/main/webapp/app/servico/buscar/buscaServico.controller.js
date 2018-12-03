(function () {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('buscarServicoController', buscarServicoController);

    buscarServicoController.$inject = ['$scope', 'Principal', 'LoginService', '$state', 'NgTableParams', 'ServicoService', 'growlMessages', 'LazyTableFactory', 'LicitacaoService'];

    function buscarServicoController($scope, Principal, LoginService, $state, ngTableParams, ServicoService, growlMessages, LazyTableFactory, LicitacaoService) {
        var vm = this;
        vm.filtro = {};
        LicitacaoService.servico = undefined;
        LicitacaoService.material = undefined;


        vm.consultarPorFiltro = _consultarPorFiltro;
        vm.escolher = _escolher;
        vm.voltar = _voltar;


        function _consultarPorFiltro(limparMensagensGrowl) {

            var opts = {
                url: '/api/servico/buscar',
                data: {
                    'codigo': vm.filtro.codigo,
                    'descricao': vm.filtro.descricao
                }
            };

            var imprimirMsgPesquisa = true;
            vm.tabelaVO = LazyTableFactory(opts, imprimirMsgPesquisa);

        }

        function _escolher() {
            LicitacaoService.servico = vm.selected;
            LicitacaoService.material = undefined;
            $state.go('escolherLicitacao');
        }

        function _voltar() {
            $state.go('home');
        }
    }
})();
