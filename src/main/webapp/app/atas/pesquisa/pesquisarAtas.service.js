(function() {
    'use strict';

    var PesquisarAtasService = ["$http", function($http){

        return {

            pesquisarAtas: function () {
                var url = '/api/atas/pesquisar';
                return $http({
                    method: "GET",
                    url: url
                });
            }
        }
    }];
    angular.module('licitacaoWebApp').factory("PesquisarAtasService", PesquisarAtasService);

})();
