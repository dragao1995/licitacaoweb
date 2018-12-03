package br.edu.ifg.fsa.tads.licitacaoweb.service.util;

import java.io.Serializable;
import java.util.List;

public interface  BaseVO<T, X> extends Serializable {

	public abstract List<T> toList(List<X> entidades);
	public abstract T toVO(X vo);

}
