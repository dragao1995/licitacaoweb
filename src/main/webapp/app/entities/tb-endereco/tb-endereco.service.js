(function() {
    'use strict';
    angular
        .module('licitacaoWebApp')
        .factory('TbEndereco', TbEndereco);

    TbEndereco.$inject = ['$resource'];

    function TbEndereco ($resource) {
        var resourceUrl =  'api/tb-enderecos/:id';

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
