# LicitaçãoWeb
Sistema para ajudar a melhoria da comunicação entre as Instituições sobre as licitações que estão acontecendo e que iram acontecer.

## Tutorial para montar o ambiente

1. Programas a ser instalados

        NodeJS
        XAMPP
        IntelliJ IDEA
        
2. Fazer o clone do projeto, bitbucket do Alex, jlicitacaoweb

3. Após o clone, abra o projeto pelo IntelliJ

4. Dentro da pasta jlicitacaoweb

    A. Através linha de comando dentro dessa pasta, digitar essas operações, respeitando a ordem a seguir:

           npm install
           npm install gulp

5. Informações importantes

    A. Toda as vezes que houver criação de novas arquivos js, ou alterações de rota, de o seguinte comando pelo terminal dentro da pasta jlicitacaoweb:

        gulp

    B. O front e o back são independentes, isso quer dizer que pra você rodar o front basta da um gulp que você já irá ver como está o front, mas não terá os serviços do back end.

6. Adicionar novas entidades no banco

    A. Crie uma nova entidade através do jdl-studio ou se você buscar no projeto todo (ctrl + shift + r) por liquibase, você verá que tem arquivos xml, que tem as entidades mapeadas, pode tentar fazer desta forma também
    
    B. Caso não queira, use o link do jdl-studio: https://start.jhipster.tech/jdl-studio/
    
         I. Crie a nova tabela no site
        
        II. Baixe o arquivo e coloque dentro da pasta do projeto
        
        III. Abra o cmd dentro da pasta do projeto
        
        IV. Faça o seguinte comando, jhipster import-jdl NOME_DO_ARQUIVO.jh
        
        V. Depois de gerar, ele irá da conflitos em algumas coisas, isso sera no processo de importar mesmo, verificar quais os arquivos esta dando conflito, cuidado para não sobrescrever o que não deve
        
        VI. Apague o banco de dados e crie novamente.
        
        VII. Caso tenha excluido, va no master.xml e apague a referencia da tabela apagada
        
        VIII. Caso tenha excluido alguma tabela procura todos os arquivos que tem o nome dessa tabela no projeto e apague.
        
        IX.Depois basta da um gulp no projeto e rodar a aplicação que tudo estará ok


* Informação sobre o tutorial para montar o ambiente
https://docs.google.com/document/d/1WfeikMglaJeuV0WZhZrcqDtL_OcRsNo0MyeyiZRy31k/edit?usp=sharing


* URL do overleaf - DOCS TCC
https://v2.overleaf.com/6674951497mkxbphrzwncg


## Aplicação Web
Essa aplicação foi gerada usando o JHipster 4.13.2, você pode encontrar a documentação e ajuda em [http://www.jhipster.tech/documentation-archive/v4.13.2](http://www.jhipster.tech/documentation-archive/v4.13.2).

## Back-end

### Terminologias

- Classes da camada do service tera o final service
- Classe da camada de repository tera o final repository
- Classe da camada Rest tera o final API
- Classe com o final DTO, são os objetos usados para transitar os dados

### Camadas

- Rest: Camada do Spring com as telas e serviços REST
- Service: Camada que representa os casos de uso do sistema.
- Repository: Camada que representa a parte do CRUD.
- Domain: Camada que representa o domínio do sistema(integração com banco de dados).

## Front-end

### Terminologias

- Pasta com o nome da funcionalidade da tela e o que ficara dentro da pasta é a controller,state,service e view.
- O arquivo de configuração de comunicação entre o back-end e o front-end nomdeDaFuncionalidade.service.js
- O arquivo de configuração da url tera o nome NomeDaFuncionalidade.state.js
- O arquivo de controle da tela tera o nome NomeDaFuncionalidade.controller.js
- a view que é a tela terá o nome NomeDaFuncionalidade.html

### Camadas

- controller - serve como controladora da view (HTML)
- state - serve como controladora e definição de rotas(URL)
- service - serve como comunicação com o back-end através de API Rest

## Como funciona o sistema

Está descrito todas as funcionalidades através dos casos de uso.

## Development

Before you can build this project, you must install and configure the following dependencies on your machine:

1. [Node.js][]: We use Node to run a development web server and build the project.
   Depending on your system, you can install Node either from source or as a pre-packaged bundle.
2. [Yarn][]: We use Yarn to manage Node dependencies.
   Depending on your system, you can install Yarn either from source or as a pre-packaged bundle.

After installing Node, you should be able to run the following command to install development tools.
You will only need to run this command when dependencies change in [package.json](package.json).

    yarn install

We use [Gulp][] as our build system. Install the Gulp command-line tool globally with:

    yarn global add gulp-cli

Run the following commands in two separate terminals to create a blissful development experience where your browser
auto-refreshes when files change on your hard drive.

    ./mvnw
    gulp

[Bower][] is used to manage CSS and JavaScript dependencies used in this application. You can upgrade dependencies by
specifying a newer version in [bower.json](bower.json). You can also run `bower update` and `bower install` to manage dependencies.
Add the `-h` flag on any command to see how you can use it. For example, `bower update -h`.

For further instructions on how to develop with JHipster, have a look at [Using JHipster in development][].



## Building for production

To optimize the licitacaoWeb application for production, run:

    ./mvnw -Pprod clean package

This will concatenate and minify the client CSS and JavaScript files. It will also modify `index.html` so it references these new files.
To ensure everything worked, run:

    java -jar target/*.war

Then navigate to [http://localhost:8080](http://localhost:8080) in your browser.

Refer to [Using JHipster in production][] for more details.

## Testing

To launch your application's tests, run:

    ./mvnw clean test

### Client tests

Unit tests are run by [Karma][] and written with [Jasmine][]. They're located in [src/test/javascript/](src/test/javascript/) and can be run with:

    gulp test



For more information, refer to the [Running tests page][].

## Using Docker to simplify development (optional)

You can use Docker to improve your JHipster development experience. A number of docker-compose configuration are available in the [src/main/docker](src/main/docker) folder to launch required third party services.

For example, to start a mysql database in a docker container, run:

    docker-compose -f src/main/docker/mysql.yml up -d

To stop it and remove the container, run:

    docker-compose -f src/main/docker/mysql.yml down

You can also fully dockerize your application and all the services that it depends on.
To achieve this, first build a docker image of your app by running:

    ./mvnw verify -Pprod dockerfile:build

Then run:

    docker-compose -f src/main/docker/app.yml up -d

For more information refer to [Using Docker and Docker-Compose][], this page also contains information on the docker-compose sub-generator (`jhipster docker-compose`), which is able to generate docker configurations for one or several JHipster applications.

## Continuous Integration (optional)

To configure CI for your project, run the ci-cd sub-generator (`jhipster ci-cd`), this will let you generate configuration files for a number of Continuous Integration systems. Consult the [Setting up Continuous Integration][] page for more information.

[JHipster Homepage and latest documentation]: http://www.jhipster.tech
[JHipster 4.13.2 archive]: http://www.jhipster.tech/documentation-archive/v4.13.2

[Using JHipster in development]: http://www.jhipster.tech/documentation-archive/v4.13.2/development/
[Service Discovery and Configuration with the JHipster-Registry]: http://www.jhipster.tech/documentation-archive/v4.13.2/microservices-architecture/#jhipster-registry
[Using Docker and Docker-Compose]: http://www.jhipster.tech/documentation-archive/v4.13.2/docker-compose
[Using JHipster in production]: http://www.jhipster.tech/documentation-archive/v4.13.2/production/
[Running tests page]: http://www.jhipster.tech/documentation-archive/v4.13.2/running-tests/
[Setting up Continuous Integration]: http://www.jhipster.tech/documentation-archive/v4.13.2/setting-up-ci/


[Node.js]: https://nodejs.org/
[Yarn]: https://yarnpkg.org/
[Bower]: http://bower.io/
[Gulp]: http://gulpjs.com/
[BrowserSync]: http://www.browsersync.io/
[Karma]: http://karma-runner.github.io/
[Jasmine]: http://jasmine.github.io/2.0/introduction.html
[Protractor]: https://angular.github.io/protractor/
[Leaflet]: http://leafletjs.com/
[DefinitelyTyped]: http://definitelytyped.org/
