package br.edu.ifg.fsa.tads.licitacaoweb.service.Atas;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class AtasService {

    /* LEIA O COMENTARIO
            A primeira busca da pra vc trazer todos os fornecedores por estado usando a UF,
            com isso montar um array de id_municipios
                http://compras.dados.gov.br/fornecedores/v1/municipios.json?uf=GO

            Vc pode buscar todos os id_municipios, mas não sei se tem como retornar um json com todos do estado
            se quiser adicionar mas filtro dentro dessa busca, coloca modalidade_licitacao = 5
            que é pregão
                http://compras.dados.gov.br/licitacoes/v1/licitacoes?uasg_municipio=
     */
    public String buscarLicitacao(){
        Client c = Client.create();
        WebResource wr = c.resource("http://compras.dados.gov.br/contratos/v1/contratos.json?uasg=158523");
        return wr.get(String.class);
    }
}
