(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbEnderecoDetailController', TbEnderecoDetailController);

    TbEnderecoDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'TbEndereco'];

    function TbEnderecoDetailController($scope, $rootScope, $stateParams, previousState, entity, TbEndereco) {
        var vm = this;

        vm.tbEndereco = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('licitacaoWebApp:tbEnderecoUpdate', function(event, result) {
            vm.tbEndereco = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
