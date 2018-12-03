package br.edu.ifg.fsa.tads.licitacaoweb.service.util;

import java.io.Serializable;
import java.util.List;

public class LazyResultVO<T extends BaseVO> implements Serializable {

    private static final long serialVersionUID = -2592228891956731529L;

    private List<T> resultados;

    private Long total;

    public List<T> getResultados() {
        return resultados;
    }

    public void setResultados(List<T> resultados) {
        this.resultados = resultados;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
