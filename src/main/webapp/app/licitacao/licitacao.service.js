(function() {
    'use strict';


    var LicitacaoService = ["$http", function($http){

        return {

            buscar: function (filtro) {
                var url = '/api/licitacao/buscar';
                return $http({
                    method: "POST",
                    url: url,
                    params: filtro
                });
            },
            solicitar: function (filtro) {
                var url = '/api/licitacao/solicitar';
                return $http({
                    method: "POST",
                    url: url,
                    params: filtro
                });
            }
        }
    }];
    angular.module('licitacaoWebApp').factory("LicitacaoService", LicitacaoService);

})();
