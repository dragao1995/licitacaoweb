(function() {
    'use strict';
    angular
        .module('licitacaoWebApp')
        .factory('TbInstituicao', TbInstituicao);

    TbInstituicao.$inject = ['$resource'];

    function TbInstituicao ($resource) {
        var resourceUrl =  'api/tb-instituicaos/:id';

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
