(function() {
    'use strict';
    angular
        .module('licitacaoWebApp')
        .factory('TbServico', TbServico);

    TbServico.$inject = ['$resource'];

    function TbServico ($resource) {
        var resourceUrl =  'api/tb-servicos/:id';

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
