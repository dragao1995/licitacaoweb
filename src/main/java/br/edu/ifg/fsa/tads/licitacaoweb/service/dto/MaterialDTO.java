package br.edu.ifg.fsa.tads.licitacaoweb.service.dto;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbMaterial;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.BaseVO;

import java.util.ArrayList;
import java.util.List;

public class MaterialDTO implements BaseVO<MaterialDTO,TbMaterial> {
    Long id;
    Long codigo;
    String descricao;
    Integer page;
    Integer count;
    String campo;
    String ordem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    @Override
    public List<MaterialDTO> toList(List<TbMaterial> entidades) {
        List<MaterialDTO> vos = new ArrayList<>();
        for (TbMaterial i : entidades) {
            vos.add(toVO(i));
        }
        return vos;
    }

    @Override
    public MaterialDTO toVO(TbMaterial material) {
        MaterialDTO materialDTO = new MaterialDTO();
        materialDTO.setId(material.getId());
        materialDTO.setDescricao(material.getDescricao());
        materialDTO.setCodigo(material.getCodigo());
        return materialDTO;
    }
}
