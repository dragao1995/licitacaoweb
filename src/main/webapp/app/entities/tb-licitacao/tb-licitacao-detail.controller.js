(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbLicitacaoDetailController', TbLicitacaoDetailController);

    TbLicitacaoDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'TbLicitacao'];

    function TbLicitacaoDetailController($scope, $rootScope, $stateParams, previousState, entity, TbLicitacao) {
        var vm = this;

        vm.tbLicitacao = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('licitacaoWebApp:tbLicitacaoUpdate', function(event, result) {
            vm.tbLicitacao = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
