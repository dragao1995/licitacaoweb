(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .factory('TbServicoSearch', TbServicoSearch);

    TbServicoSearch.$inject = ['$resource'];

    function TbServicoSearch($resource) {
        var resourceUrl =  'api/_search/tb-servicos/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
