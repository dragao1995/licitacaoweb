(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .factory('TbLicitacaoSearch', TbLicitacaoSearch);

    TbLicitacaoSearch.$inject = ['$resource'];

    function TbLicitacaoSearch($resource) {
        var resourceUrl =  'api/_search/tb-licitacaos/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
