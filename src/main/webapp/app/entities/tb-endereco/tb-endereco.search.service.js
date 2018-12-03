(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .factory('TbEnderecoSearch', TbEnderecoSearch);

    TbEnderecoSearch.$inject = ['$resource'];

    function TbEnderecoSearch($resource) {
        var resourceUrl =  'api/_search/tb-enderecos/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
