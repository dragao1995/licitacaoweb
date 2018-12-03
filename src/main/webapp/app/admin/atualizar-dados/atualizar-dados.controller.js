(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('AtualizarDadosController', AtualizarDadosController);

    AtualizarDadosController.$inject = ['Principal', 'Auth','$scope', '$http','$element','AtualizarDadosService','$mdDialog'];

    function AtualizarDadosController (Principal, Auth,$scope, $http,$element,AtualizarDadosService,$mdDialog) {
        var vm = this;

        vm.error = null;
        vm.success = null;
        vm.atualizarDados = atualizarDados;

        $scope.filtro = {};



        function atualizarDados(){
            AtualizarDadosService.atualizarDados().then(function(response){
                console.log(response);
            });
        }

    }

})();
