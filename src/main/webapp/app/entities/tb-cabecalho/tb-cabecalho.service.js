(function() {
    'use strict';
    angular
        .module('licitacaoWebApp')
        .factory('TbCabecalho', TbCabecalho);

    TbCabecalho.$inject = ['$resource'];

    function TbCabecalho ($resource) {
        var resourceUrl =  'api/tb-cabecalhos/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
