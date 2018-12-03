/* eslint-disable angular/controller-as,angular/controller-as */
(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('PesquisarAtasController', PesquisarAtasController);

    PesquisarAtasController.$inject = ['Principal', 'Auth','$scope', '$http','$element','PesquisarAtasService'];
    function PesquisarAtasController(Principal, Auth,$scope, $http,$element, PesquisarAtasService) {
        var vm = this;
        $scope.atas=[];
        $scope.ataSelecionada=[];

        $scope.pesquisar=_pesquisar;



        function _pesquisar() {
            PesquisarAtasService.pesquisarAtas().then(function (response) {

                $scope.atas = response.data._embedded.contratos;
            });
        }

    }
})();
