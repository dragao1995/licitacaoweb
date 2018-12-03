(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .factory('TbMaterialSearch', TbMaterialSearch);

    TbMaterialSearch.$inject = ['$resource'];

    function TbMaterialSearch($resource) {
        var resourceUrl =  'api/_search/tb-materials/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
