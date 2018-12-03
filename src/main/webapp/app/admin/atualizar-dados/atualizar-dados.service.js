(function() {
    'use strict';

    var BASE_URL = '/api/adicionaLicitacao/{0}';

    var AtualizarDadosService = ["$http", function($http){

        return {

            atualizarDados: function () {
                var url = '/api/atualizarDados/';
                return $http({
                    method: "POST",
                    url: url
                });
            }
        }
    }];
    angular.module('licitacaoWebApp').factory("AtualizarDadosService", AtualizarDadosService);

})();
