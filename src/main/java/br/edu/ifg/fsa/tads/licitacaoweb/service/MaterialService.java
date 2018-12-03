package br.edu.ifg.fsa.tads.licitacaoweb.service;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbMaterial;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.TbMaterialRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.MaterialDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.LazyResultVO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope("prototype")
public class MaterialService {

    @Autowired
    TbMaterialRepository tbMaterialRepository;

    @Transactional
    public LazyResultVO<MaterialDTO> listaPaginada(Integer pagina, Integer limite, OrderBy orderBy, MaterialDTO filtro) {
        LazyResultVO<MaterialDTO> resultado = new LazyResultVO<>();

            List<TbMaterial> lista = tbMaterialRepository.listaPaginada(pagina, limite, orderBy, filtro);
            resultado.setResultados(new MaterialDTO().toList(lista));
            resultado.setTotal(tbMaterialRepository.recuperarTotal(filtro));

        return resultado;
    }
}
