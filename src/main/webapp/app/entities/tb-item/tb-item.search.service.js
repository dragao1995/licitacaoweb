(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .factory('TbItemSearch', TbItemSearch);

    TbItemSearch.$inject = ['$resource'];

    function TbItemSearch($resource) {
        var resourceUrl =  'api/_search/tb-items/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
