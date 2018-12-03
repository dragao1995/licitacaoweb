(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .factory('TbMensagemSearch', TbMensagemSearch);

    TbMensagemSearch.$inject = ['$resource'];

    function TbMensagemSearch($resource) {
        var resourceUrl =  'api/_search/tb-mensagems/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
