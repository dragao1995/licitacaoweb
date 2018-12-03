(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .factory('TbInstituicaoSearch', TbInstituicaoSearch);

    TbInstituicaoSearch.$inject = ['$resource'];

    function TbInstituicaoSearch($resource) {
        var resourceUrl =  'api/_search/tb-instituicaos/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
