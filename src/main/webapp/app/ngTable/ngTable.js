;
(function () {

    angular.module('licitacaoWebApp').factory('LazyTableFactory', LazyTableFactory);

    LazyTableFactory.$inject = ['$http','NgTableParams','growl']

    function LazyTableFactory($http, NgTableParams, growl) {

        var buildSortingParameter = function (params) {

            var sorting = params.sorting();

            var orderByArray;
            for (var i in sorting) {
                var sort = {'field': i, 'type': sorting[i]};
                orderByArray = sort;
            }

            return orderByArray;

        };

        var factory = function (opts, imprimirMsgPesquisa) {

            var ngTableParams = new NgTableParams({}, {

                getData: function (params) {

                    ngTableParams.isLoading = true;

                    var data = angular.extend(opts.data, params.url());

                    var orderBy = buildSortingParameter(params);

                    if(orderBy!=null){
                        data.campo = orderBy.field;
                        data.ordem = orderBy.type;
                    }

                    var promise = $http({
                        method: 'POST',
                        url: opts.url,
                        params: data
                    });

                    return promise.then(

                        function (successResponse) {

                            var data = successResponse.data.entity;

                            params.total(data.total);

                            if (imprimirMsgPesquisa) {

                                if (!data.resultados || !data.resultados.length) {

                                    growl.warning("Não foram encontrados registros!");

                                }

                            }

                            if (opts.responseSuccess) {
                                opts.responseSuccess(response);
                            }

                            ngTableParams.isLoading = false;

                            return data.resultados;

                        },

                        function (errorResponse) {

                            growl.error("");
                            ngTableParams.isLoading = false;

                        }

                    );

                }

            });

            return ngTableParams;

        };

        return factory;

    }


})();
