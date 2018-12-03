(function() {
    'use strict';


    var RequisicoesService = ["$http", function($http){

        return {

            buscar: function (filtro) {
                var url = '/api/requisicoes/buscar';
                return $http({
                    method: "POST",
                    url: url,
                    params: filtro
                });
            },
            responderAceito: function (filtro) {
                var url = '/api/mensagens/responderAceito';
                return $http({
                    method: "POST",
                    url: url,
                    params: filtro
                });
            },
            responderRejeitado: function (filtro) {
                var url = '/api/mensagens/responderRejeitado';
                return $http({
                    method: "POST",
                    url: url,
                    params: filtro
                });
            }
        }
    }];
    angular.module('licitacaoWebApp').factory("RequisicoesService", RequisicoesService);

})();
