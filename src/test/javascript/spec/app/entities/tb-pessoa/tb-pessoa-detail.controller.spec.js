'use strict';

describe('Controller Tests', function() {

    describe('TbPessoa Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockTbPessoa, MockTbInstituicao, MockTbContato;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockTbPessoa = jasmine.createSpy('MockTbPessoa');
            MockTbInstituicao = jasmine.createSpy('MockTbInstituicao');
            MockTbContato = jasmine.createSpy('MockTbContato');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'TbPessoa': MockTbPessoa,
                'TbInstituicao': MockTbInstituicao,
                'TbContato': MockTbContato
            };
            createController = function() {
                $injector.get('$controller')("TbPessoaDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'licitacaoWebApp:tbPessoaUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
