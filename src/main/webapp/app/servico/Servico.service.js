(function() {
    'use strict';


    var ServicoService = ["$http", function($http){

        return {

            buscar: function (filtro) {
                var url = '/api/servico/buscar';
                return $http({
                    method: "POST",
                    url: url,
                    params: filtro
                });
            }
        }
    }];
    angular.module('licitacaoWebApp').factory("ServicoService", ServicoService);

})();
