(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .factory('TbCabecalhoSearch', TbCabecalhoSearch);

    TbCabecalhoSearch.$inject = ['$resource'];

    function TbCabecalhoSearch($resource) {
        var resourceUrl =  'api/_search/tb-cabecalhos/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
