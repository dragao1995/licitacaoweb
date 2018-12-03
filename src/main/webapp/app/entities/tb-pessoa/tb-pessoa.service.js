(function() {
    'use strict';
    angular
        .module('licitacaoWebApp')
        .factory('TbPessoa', TbPessoa);

    TbPessoa.$inject = ['$resource'];

    function TbPessoa ($resource) {
        var resourceUrl =  'api/tb-pessoas/:id';

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
