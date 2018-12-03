(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('TbContatoDetailController', TbContatoDetailController);

    TbContatoDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'TbContato'];

    function TbContatoDetailController($scope, $rootScope, $stateParams, previousState, entity, TbContato) {
        var vm = this;

        vm.tbContato = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('licitacaoWebApp:tbContatoUpdate', function(event, result) {
            vm.tbContato = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
