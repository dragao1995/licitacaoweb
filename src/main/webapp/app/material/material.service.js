(function() {
    'use strict';


    var MaterialService = ["$http", function($http){

        return {

            buscar: function (filtro) {
                var url = '/api/material/buscar';
                return $http({
                    method: "POST",
                    url: url,
                    params: filtro
                });
            }
        }
    }];
    angular.module('licitacaoWebApp').factory("MaterialService", MaterialService);

})();
