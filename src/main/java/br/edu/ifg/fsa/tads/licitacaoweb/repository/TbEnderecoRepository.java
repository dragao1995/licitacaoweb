package br.edu.ifg.fsa.tads.licitacaoweb.repository;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbEndereco;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the TbEndereco entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TbEnderecoRepository extends JpaRepository<TbEndereco, Long> {

}
