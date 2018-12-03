(function() {
    'use strict';

    angular
        .module('licitacaoWebApp')
        .controller('AdicionarLicitacaoController', AdicionarLicitacaoController);

    AdicionarLicitacaoController.$inject = ['Principal', 'Auth','$scope', '$http','$element','AdicionarLicitacaoService','$mdDialog'];

    /*
    PENSANDO EM USAR UM SERVIÇO PARA BUSCAR LICITAÇÃO
    JÁ EXISTE API, O PROPRIO ORGÃO JÁ FEZ, ESSES LINKS ABAIXO SÂO PARA VERIFICAR ISSO

    CENTRO FED. DE EDUCACAO TECNOLOGICA DE GOIAS
    http://www.planejamento.gov.br/noticias/planejamento-divulga-dados-abertos-de-compras-publicas
    http://dados.gov.br/dataset/compras-publicas-do-governo-federal
    http://dados.gov.br/dataset/compras-publicas-do-governo-federal/resource/46a511d4-ca3a-46f0-9c12-6f3e23535dac
    https://github.com/dadosgovbr/kit/blob/master/Mapa-de-decis%C3%B5es-tecnol%C3%B3gicas.md
    http://compras.dados.gov.br/docs/home.html
    https://jsonformatter.org/

    ESSE LINK ABAIXO É PQ EU TENTEI TESTAR PARA USAR, MAS SEMPRE DA ERRO, ELE FALA QUE PROVAVELMENTE A GENTE TERA QUE FAZER ISSO PELO JAVA,
    ACHO QUE NÃO SEJA TÃO COMPLEXO ASSIM

    https://cursos.alura.com.br/forum/topico-erro-no-access-control-allow-origin-em-http-get-37435

    EU CRIE UM SERVICE AQUI +/-, O PADRÂO QUE TEM NO JHIPSTER EU ACHEI MEIO ESTRANHO, SE VC OLHAR PROFILE.SERVICE.JS,
    TENHO UMA IMPRESSÂO QUE ESTÃO QUASE QUE USANDO UM SERVICE COMO CONTROLLER


    TEM QUE TESTAR, MAS ACHO QUE JA ESTA FUNCIONANDO ESSA biblioteca abaixo, ja adicionei o link no index

    https://github.com/the-darc/angular-br-filters
    https://github.com/angular-ui/ui-mask
    https://github.com/assisrafael/angular-input-masks

    https://cdnjs.com/libraries/angular-br-filters


     */


    function AdicionarLicitacaoController (Principal, Auth,$scope, $http,$element,AdicionarLicitacaoService,$mdDialog) {
        var vm = this;

        vm.error = null;
        vm.success = null;

        $scope.campus = ['Águas Lindas' ,'Anápolis' ,'Aparecida de Goiânia' ,'Cidade de Goiás' ,'Formosa', 'Goiânia',
            'Goiânia Oeste','Inhumas','Itumbiara','Jataí','Luziânia','Novo Gama','Senador Canedo',
            ,'Uruaçu','Valparaíso'];
        $scope.searchTerm;
        $scope.filtro = {};

        $scope.selectedCampus;
        $scope.testando;
        /*
        function teste(){
          AdicionarLicitacaoService.buscarLicitacao().then(function (response) {
              console.log("TESTE ",response);
              $scope.testando = response;
          })
        };
        teste();
        */
        $scope.inserir = function (){
            AdicionarLicitacaoService.inserirLicitacao($scope.filtro).then(function(response){
                console.log(response);
            });
        }
        $scope.clearSearchTerm = function() {
            $scope.searchTerm = '';
        };
        $element.find('input').on('keydown', function(ev) {
            ev.stopPropagation();
        });

        $scope.showAdvanced = function(ev) {
            $mdDialog.show({
                controller: DialogController,
                templateUrl: 'app/licitacao/adicionar/informacao.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose:true,
                fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
            })
                .then(function(answer) {
                    $scope.status = 'You said the information was "' + answer + '".';
                }, function() {
                    $scope.status = 'You cancelled the dialog.';
                });
        };

        DialogController.$inject = ['Principal', 'Auth','$scope', '$http','$element','AdicionarLicitacaoService','$mdDialog'];
        function DialogController($scope, $mdDialog) {

            $scope.hide = function() {
                $mdDialog.hide();
            };

            $scope.cancel = function() {
                $mdDialog.cancel();
            };

            $scope.answer = function(answer) {
                $mdDialog.hide(answer);
            };
        }

        /*     $http.get('http://compras.dados.gov.br/licitacoes/v1/licitacoes.json')
                 .success(function(result){
                     console.log("TESTE",result);
                 })
                 .error(function(erro){
                     console.log(erro);
                 });
         */

    }


})();
