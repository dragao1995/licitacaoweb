package br.edu.ifg.fsa.tads.licitacaoweb.web.rest;

import com.codahale.metrics.annotation.Timed;
import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbInstituicao;

import br.edu.ifg.fsa.tads.licitacaoweb.repository.TbInstituicaoRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.search.TbInstituicaoSearchRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.web.rest.errors.BadRequestAlertException;
import br.edu.ifg.fsa.tads.licitacaoweb.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing TbInstituicao.
 */
@RestController
@RequestMapping("/api")
public class TbInstituicaoResource {

    private final Logger log = LoggerFactory.getLogger(TbInstituicaoResource.class);

    private static final String ENTITY_NAME = "tbInstituicao";

    private final TbInstituicaoRepository tbInstituicaoRepository;

    private final TbInstituicaoSearchRepository tbInstituicaoSearchRepository;

    public TbInstituicaoResource(TbInstituicaoRepository tbInstituicaoRepository, TbInstituicaoSearchRepository tbInstituicaoSearchRepository) {
        this.tbInstituicaoRepository = tbInstituicaoRepository;
        this.tbInstituicaoSearchRepository = tbInstituicaoSearchRepository;
    }

    /**
     * POST  /tb-instituicaos : Create a new tbInstituicao.
     *
     * @param tbInstituicao the tbInstituicao to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tbInstituicao, or with status 400 (Bad Request) if the tbInstituicao has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tb-instituicaos")
    @Timed
    public ResponseEntity<TbInstituicao> createTbInstituicao(@Valid @RequestBody TbInstituicao tbInstituicao) throws URISyntaxException {
        log.debug("REST request to save TbInstituicao : {}", tbInstituicao);
        if (tbInstituicao.getId() != null) {
            throw new BadRequestAlertException("A new tbInstituicao cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TbInstituicao result = tbInstituicaoRepository.save(tbInstituicao);
        tbInstituicaoSearchRepository.save(result);
        return ResponseEntity.created(new URI("/api/tb-instituicaos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tb-instituicaos : Updates an existing tbInstituicao.
     *
     * @param tbInstituicao the tbInstituicao to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tbInstituicao,
     * or with status 400 (Bad Request) if the tbInstituicao is not valid,
     * or with status 500 (Internal Server Error) if the tbInstituicao couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tb-instituicaos")
    @Timed
    public ResponseEntity<TbInstituicao> updateTbInstituicao(@Valid @RequestBody TbInstituicao tbInstituicao) throws URISyntaxException {
        log.debug("REST request to update TbInstituicao : {}", tbInstituicao);
        if (tbInstituicao.getId() == null) {
            return createTbInstituicao(tbInstituicao);
        }
        TbInstituicao result = tbInstituicaoRepository.save(tbInstituicao);
        tbInstituicaoSearchRepository.save(result);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tbInstituicao.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tb-instituicaos : get all the tbInstituicaos.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of tbInstituicaos in body
     */
    @GetMapping("/tb-instituicaos")
    @Timed
    public List<TbInstituicao> getAllTbInstituicaos() {
        log.debug("REST request to get all TbInstituicaos");
        return tbInstituicaoRepository.findAllWithEagerRelationships();
        }

    /**
     * GET  /tb-instituicaos/:id : get the "id" tbInstituicao.
     *
     * @param id the id of the tbInstituicao to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tbInstituicao, or with status 404 (Not Found)
     */
    @GetMapping("/tb-instituicaos/{id}")
    @Timed
    public ResponseEntity<TbInstituicao> getTbInstituicao(@PathVariable Long id) {
        log.debug("REST request to get TbInstituicao : {}", id);
        TbInstituicao tbInstituicao = tbInstituicaoRepository.findOneWithEagerRelationships(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(tbInstituicao));
    }

    /**
     * DELETE  /tb-instituicaos/:id : delete the "id" tbInstituicao.
     *
     * @param id the id of the tbInstituicao to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tb-instituicaos/{id}")
    @Timed
    public ResponseEntity<Void> deleteTbInstituicao(@PathVariable Long id) {
        log.debug("REST request to delete TbInstituicao : {}", id);
        tbInstituicaoRepository.delete(id);
        tbInstituicaoSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/tb-instituicaos?query=:query : search for the tbInstituicao corresponding
     * to the query.
     *
     * @param query the query of the tbInstituicao search
     * @return the result of the search
     */
    @GetMapping("/_search/tb-instituicaos")
    @Timed
    public List<TbInstituicao> searchTbInstituicaos(@RequestParam String query) {
        log.debug("REST request to search TbInstituicaos for query {}", query);
        return StreamSupport
            .stream(tbInstituicaoSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .collect(Collectors.toList());
    }

}
