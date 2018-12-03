(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .factory('TbContatoSearch', TbContatoSearch);

    TbContatoSearch.$inject = ['$resource'];

    function TbContatoSearch($resource) {
        var resourceUrl =  'api/_search/tb-contatoes/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
