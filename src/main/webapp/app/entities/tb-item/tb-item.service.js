(function() {
    'use strict';
    angular
        .module('licitacaoWebApp')
        .factory('TbItem', TbItem);

    TbItem.$inject = ['$resource'];

    function TbItem ($resource) {
        var resourceUrl =  'api/tb-items/:id';

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
