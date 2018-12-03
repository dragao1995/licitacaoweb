(function () {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('escolherLicitacaoController', escolherLicitacaoController);

    escolherLicitacaoController.$inject = ['$scope', 'Principal', 'LoginService', '$state', 'NgTableParams', 'LicitacaoService', 'growlMessages', 'LazyTableFactory'];

    function escolherLicitacaoController($scope, Principal, LoginService, $state, ngTableParams, LicitacaoService, growlMessages, LazyTableFactory) {
        var vm = this;
        vm.filtro = {};
        vm.servico = {};
        vm.material = {};

        carregarController();
        vm.consultarPorFiltro = _consultarPorFiltro;
        vm.escolher = _escolher;
        vm.voltar = _voltar;



        function carregarController() {
            if(LicitacaoService.servico == undefined && LicitacaoService.material == undefined){
                $state.go('home');
            }else {
                vm.servico = LicitacaoService.servico;
                vm.material = LicitacaoService.material;
                _consultarPorFiltro();
            }
        }

        function _consultarPorFiltro() {

            var opts = {
                url: '/api/licitacao/escolher',
                data: {
                    'identificador': vm.filtro.identificador,
                    'numeroProcesso': vm.filtro.numeroProcesso,
                    'uasg': vm.filtro.uasg,
                    'uasgDescricao': vm.filtro.uasgDescricao,
                    'codigoServico': vm.servico != undefined ? vm.servico.codigo : null,
                    'codigoMaterial': vm.material != undefined ? vm.material.codigo : null
                }
            };

            var imprimirMsgPesquisa = true;
            vm.tabelaVO = LazyTableFactory(opts, imprimirMsgPesquisa);

        }

        function _escolher() {
            LicitacaoService.licitacao = vm.selected;
            $state.go('quantidade');
        }

        function _voltar() {
            if( LicitacaoService.servico != undefined){
                $state.go('buscarServico');
            }else  if( LicitacaoService.material != undefined){
                $state.go('buscarMaterial');
            }

        }
    }
})();
