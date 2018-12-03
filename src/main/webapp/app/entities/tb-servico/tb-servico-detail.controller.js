(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbServicoDetailController', TbServicoDetailController);

    TbServicoDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'TbServico'];

    function TbServicoDetailController($scope, $rootScope, $stateParams, previousState, entity, TbServico) {
        var vm = this;

        vm.tbServico = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('licitacaoWebApp:tbServicoUpdate', function(event, result) {
            vm.tbServico = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
