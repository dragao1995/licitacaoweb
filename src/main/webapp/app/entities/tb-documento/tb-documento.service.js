(function() {
    'use strict';
    angular
        .module('licitacaoWebApp')
        .factory('TbDocumento', TbDocumento);

    TbDocumento.$inject = ['$resource'];

    function TbDocumento ($resource) {
        var resourceUrl =  'api/tb-documentos/:id';

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
