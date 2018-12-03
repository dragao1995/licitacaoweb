(function () {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('analisarRequisicoesController', analisarRequisicoesController);

    analisarRequisicoesController.$inject = ['$scope', 'Principal', 'LoginService', '$state', 'NgTableParams', 'growlMessages', 'MaterialService', 'LazyTableFactory', 'RequisicoesService'];

    function analisarRequisicoesController($scope, Principal, LoginService, $state, ngTableParams, growlMessages, MaterialService, LazyTableFactory, RequisicoesService) {
        var vm = this;
        vm.filtro = {};

        vm.consultarPorFiltro = _consultarPorFiltro;
        vm.voltar = _voltar;
        vm.analisar = _analisar;
        vm.consultarPorFiltroResposta = _consultarPorFiltroResposta;
        vm.confirmarAnalise = _confirmarAnalise;
        vm.voltarAnalise = _voltarAnalise;
        vm.rejeitarAnalise = _rejeitarAnalise;

        carregarController();


        function carregarController() {
            vm.tabelaVO = angular.copy(RequisicoesService.tabelaVO);
            RequisicoesService.tabelaVO = undefined;
            getAccount();
        }

        function getAccount() {
            Principal.identity().then(function(account) {
                vm.account = account;
            });
        }

        function _consultarPorFiltro(limparMensagensGrowl) {
            var opts = {
                url: '/api/mensagens/buscar',
                data: {
                    'identificador': vm.filtro.identificador,
                    'uasg': vm.filtro.uasg,
                    'uasgDescricao': vm.filtro.uasgDescricao,
                    'dataInicial': vm.filtro.dataInicial != null ? vm.filtro.dataInicial.getTime() : null,
                    'dataFinal': vm.filtro.dataFinal != null ? vm.filtro.dataFinal.getTime() : null,
                    'tipo': vm.filtro.tipo,
                    'codigo': vm.filtro.codigo,
                    'descricao': vm.filtro.descricao,
                    'status': vm.filtro.status != "" ? vm.filtro.status : null,
                    'uasgUsuario': vm.account.uasg
                }
            };

            var imprimirMsgPesquisa = true;
            vm.tabelaVO = LazyTableFactory(opts, imprimirMsgPesquisa);
        }

        function _consultarPorFiltroResposta(limparMensagensGrowl) {
            var opts = {
                url: '/api/mensagens/resposta',
                data: {
                    'identificador': vm.filtro.identificador,
                    'uasg': vm.filtro.uasg,
                    'uasgDescricao': vm.filtro.uasgDescricao,
                    'dataInicial': vm.filtro.dataInicial != null ? vm.filtro.dataInicial.getTime() : null,
                    'dataFinal': vm.filtro.dataFinal != null ? vm.filtro.dataFinal.getTime() : null,
                    'tipo': vm.filtro.tipo,
                    'codigo': vm.filtro.codigo,
                    'descricao': vm.filtro.descricao,
                    'status': vm.filtro.status != "" ? vm.filtro.status : null,
                    'uasgUsuario': vm.account.uasg
                }
            };

            var imprimirMsgPesquisa = true;
            vm.tabelaVO = LazyTableFactory(opts, imprimirMsgPesquisa);
        }

        function _voltar() {
            $state.go('home');
        }

        function _analisar() {
            RequisicoesService.tabelaVO = vm.selected;
            $state.go('confirmarAnalise');
        }

        function _confirmarAnalise() {

            var data = {
                'id': vm.tabelaVO.id,
                'observacao': vm.filtro.observacao,
            }

            RequisicoesService.responderAceito(data).then(
                function (successResponse) {
                vm.ok = true;
                },
                function (errorResponse) {
                    console.log("erro " + errorResponse.toString());
                }
            );
        }

        function _rejeitarAnalise() {
            var data = {
                'id': vm.tabelaVO.id,
                'observacao': vm.filtro.observacao,
            }

            RequisicoesService.responderRejeitado(data).then(
                function (successResponse) {
                    vm.ok = true;
                },
                function (errorResponse) {
                    console.log("erro " + errorResponse.toString());
                }
            );
        }

        function _voltarAnalise() {
            angular.element('#modalRejeitar').modal('hide');
            angular.element('#modalConfirmar').modal('hide');
            angular.element('.modal-backdrop').remove();
            $state.go('home');
        }



    }
})();
