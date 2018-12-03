'use strict';

describe('Controller Tests', function() {

    describe('TbInstituicao Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockTbInstituicao, MockTbEndereco, MockTbContato, MockTbCabecalho;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockTbInstituicao = jasmine.createSpy('MockTbInstituicao');
            MockTbEndereco = jasmine.createSpy('MockTbEndereco');
            MockTbContato = jasmine.createSpy('MockTbContato');
            MockTbCabecalho = jasmine.createSpy('MockTbCabecalho');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'TbInstituicao': MockTbInstituicao,
                'TbEndereco': MockTbEndereco,
                'TbContato': MockTbContato,
                'TbCabecalho': MockTbCabecalho
            };
            createController = function() {
                $injector.get('$controller')("TbInstituicaoDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'licitacaoWebApp:tbInstituicaoUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
