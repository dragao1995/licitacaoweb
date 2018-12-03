package br.edu.ifg.fsa.tads.licitacaoweb.repository;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbInstituicao;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Spring Data JPA repository for the TbInstituicao entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TbInstituicaoRepository extends JpaRepository<TbInstituicao, Long> {
    @Query("select distinct tb_instituicao from TbInstituicao tb_instituicao left join fetch tb_instituicao.cabecalhos")
    List<TbInstituicao> findAllWithEagerRelationships();

    @Query("select tb_instituicao from TbInstituicao tb_instituicao left join fetch tb_instituicao.cabecalhos where tb_instituicao.id =:id")
    TbInstituicao findOneWithEagerRelationships(@Param("id") Long id);

}
