(function() {
    'use strict';
    angular
        .module('licitacaoWebApp')
        .factory('TbContato', TbContato);

    TbContato.$inject = ['$resource'];

    function TbContato ($resource) {
        var resourceUrl =  'api/tb-contatoes/:id';

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
