(function() {
    'use strict';
    angular
        .module('licitacaoWebApp')
        .factory('TbMaterial', TbMaterial);

    TbMaterial.$inject = ['$resource'];

    function TbMaterial ($resource) {
        var resourceUrl =  'api/tb-materials/:id';

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
