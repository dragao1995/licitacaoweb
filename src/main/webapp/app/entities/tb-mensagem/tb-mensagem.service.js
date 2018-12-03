(function() {
    'use strict';
    angular
        .module('licitacaoWebApp')
        .factory('TbMensagem', TbMensagem);

    TbMensagem.$inject = ['$resource', 'DateUtils'];

    function TbMensagem ($resource, DateUtils) {
        var resourceUrl =  'api/tb-mensagems/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.dataInicio = DateUtils.convertLocalDateFromServer(data.dataInicio);
                        data.dataFinal = DateUtils.convertLocalDateFromServer(data.dataFinal);
                    }
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.dataInicio = DateUtils.convertLocalDateToServer(copy.dataInicio);
                    copy.dataFinal = DateUtils.convertLocalDateToServer(copy.dataFinal);
                    return angular.toJson(copy);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.dataInicio = DateUtils.convertLocalDateToServer(copy.dataInicio);
                    copy.dataFinal = DateUtils.convertLocalDateToServer(copy.dataFinal);
                    return angular.toJson(copy);
                }
            }
        });
    }
})();
