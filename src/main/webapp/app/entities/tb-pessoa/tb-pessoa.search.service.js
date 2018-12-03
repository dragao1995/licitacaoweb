(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .factory('TbPessoaSearch', TbPessoaSearch);

    TbPessoaSearch.$inject = ['$resource'];

    function TbPessoaSearch($resource) {
        var resourceUrl =  'api/_search/tb-pessoas/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
