(function() {
    'use strict';

    var BASE_URL = '/api/adicionaLicitacao/{0}';

    var AdicionarLicitacaoService = ["$http", function($http){

        return {

            inserirLicitacao: function (filtro) {
                var url = '/api/adicionaLicitacao/adicionar';
                return $http({
                    method: "POST",
                    url: url,
                    params: filtro
                });
            },

            buscarLicitacao: function () {
                var url = '/api/adicionaLicitacao/buscarLicitacao';
                return $http({
                   method: "GET",
                   url: url
                });
            }
        }
    }];
    angular.module('licitacaoWebApp').factory("AdicionarLicitacaoService", AdicionarLicitacaoService);

})();
