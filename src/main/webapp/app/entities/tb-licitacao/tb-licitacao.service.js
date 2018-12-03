(function() {
    'use strict';
    angular
        .module('licitacaoWebApp')
        .factory('TbLicitacao', TbLicitacao);

    TbLicitacao.$inject = ['$resource', 'DateUtils'];

    function TbLicitacao ($resource, DateUtils) {
        var resourceUrl =  'api/tb-licitacaos/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.dataPublicacao = DateUtils.convertLocalDateFromServer(data.dataPublicacao);
                        data.dataEntregaedital = DateUtils.convertLocalDateFromServer(data.dataEntregaedital);
                        data.dataEntregaProposta = DateUtils.convertLocalDateFromServer(data.dataEntregaProposta);
                    }
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.dataPublicacao = DateUtils.convertLocalDateToServer(copy.dataPublicacao);
                    copy.dataEntregaedital = DateUtils.convertLocalDateToServer(copy.dataEntregaedital);
                    copy.dataEntregaProposta = DateUtils.convertLocalDateToServer(copy.dataEntregaProposta);
                    return angular.toJson(copy);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.dataPublicacao = DateUtils.convertLocalDateToServer(copy.dataPublicacao);
                    copy.dataEntregaedital = DateUtils.convertLocalDateToServer(copy.dataEntregaedital);
                    copy.dataEntregaProposta = DateUtils.convertLocalDateToServer(copy.dataEntregaProposta);
                    return angular.toJson(copy);
                }
            }
        });
    }
})();
