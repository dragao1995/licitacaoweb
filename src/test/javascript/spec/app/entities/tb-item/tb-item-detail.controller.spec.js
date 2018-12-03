'use strict';

describe('Controller Tests', function() {

    describe('TbItem Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockTbItem, MockTbLicitacao, MockTbServico, MockTbMaterial;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockTbItem = jasmine.createSpy('MockTbItem');
            MockTbLicitacao = jasmine.createSpy('MockTbLicitacao');
            MockTbServico = jasmine.createSpy('MockTbServico');
            MockTbMaterial = jasmine.createSpy('MockTbMaterial');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'TbItem': MockTbItem,
                'TbLicitacao': MockTbLicitacao,
                'TbServico': MockTbServico,
                'TbMaterial': MockTbMaterial
            };
            createController = function() {
                $injector.get('$controller')("TbItemDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'licitacaoWebApp:tbItemUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
