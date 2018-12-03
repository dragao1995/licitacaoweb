(function () {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('QuantidadeController', QuantidadeController);

    QuantidadeController.$inject = ['$scope', 'Principal', 'LoginService', '$state', 'NgTableParams', 'LicitacaoService', 'growlMessages', 'LazyTableFactory'];

    function QuantidadeController($scope, Principal, LoginService, $state, ngTableParams, LicitacaoService, growlMessages, LazyTableFactory) {
        var vm = this;
        vm.filtro = {};

        vm.voltar = _voltar;
        vm.solicitar = _solicitar;
        vm.sair = _sair;

        carregarController();


        function carregarController() {
            if (LicitacaoService.servico == undefined && LicitacaoService.material == undefined) {
                $state.go('home');
            } else {
                vm.servico = LicitacaoService.servico;
                vm.material = LicitacaoService.material;
                vm.licitacao = LicitacaoService.licitacao;
            }

            getAccount();

        }

        function getAccount() {
            Principal.identity().then(function(account) {
                vm.account = account;
            });
        }
        function _voltar() {
            $state.go('escolherLicitacao');
        }

        function _solicitar() {

            var data = {
                'uasgEnvio': vm.account.uasg,

                'quantidade': vm.filtro.quantidade,
                'uasgDestino': vm.licitacao.uasg,
                'idLicitacao': vm.licitacao.id,
                'idServico': vm.servico != undefined ? vm.servico.id : null,
                'idMaterial': vm.material != undefined ? vm.material.id : null
            }

            LicitacaoService.solicitar(data).then(
                function (successResponse) {
                   vm.protocolo = successResponse.data.entity
                },
                function (errorResponse) {
                    console.log("erro " + errorResponse.toString());
                }
            );
        }

        function _sair() {
            angular.element('#modalConfirmar').modal('hide');
            angular.element('.modal-backdrop').remove();
            $state.go('home');
        }

    }
})();
