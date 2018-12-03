(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .factory('TbDocumentoSearch', TbDocumentoSearch);

    TbDocumentoSearch.$inject = ['$resource'];

    function TbDocumentoSearch($resource) {
        var resourceUrl =  'api/_search/tb-documentos/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
