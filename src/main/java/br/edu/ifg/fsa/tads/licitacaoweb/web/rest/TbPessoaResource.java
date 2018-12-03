package br.edu.ifg.fsa.tads.licitacaoweb.web.rest;

import com.codahale.metrics.annotation.Timed;
import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbPessoa;

import br.edu.ifg.fsa.tads.licitacaoweb.repository.TbPessoaRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.search.TbPessoaSearchRepository;
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
 * REST controller for managing TbPessoa.
 */
@RestController
@RequestMapping("/api")
public class TbPessoaResource {

    private final Logger log = LoggerFactory.getLogger(TbPessoaResource.class);

    private static final String ENTITY_NAME = "tbPessoa";

    private final TbPessoaRepository tbPessoaRepository;

    private final TbPessoaSearchRepository tbPessoaSearchRepository;

    public TbPessoaResource(TbPessoaRepository tbPessoaRepository, TbPessoaSearchRepository tbPessoaSearchRepository) {
        this.tbPessoaRepository = tbPessoaRepository;
        this.tbPessoaSearchRepository = tbPessoaSearchRepository;
    }

    /**
     * POST  /tb-pessoas : Create a new tbPessoa.
     *
     * @param tbPessoa the tbPessoa to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tbPessoa, or with status 400 (Bad Request) if the tbPessoa has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tb-pessoas")
    @Timed
    public ResponseEntity<TbPessoa> createTbPessoa(@Valid @RequestBody TbPessoa tbPessoa) throws URISyntaxException {
        log.debug("REST request to save TbPessoa : {}", tbPessoa);
        if (tbPessoa.getId() != null) {
            throw new BadRequestAlertException("A new tbPessoa cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TbPessoa result = tbPessoaRepository.save(tbPessoa);
        tbPessoaSearchRepository.save(result);
        return ResponseEntity.created(new URI("/api/tb-pessoas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tb-pessoas : Updates an existing tbPessoa.
     *
     * @param tbPessoa the tbPessoa to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tbPessoa,
     * or with status 400 (Bad Request) if the tbPessoa is not valid,
     * or with status 500 (Internal Server Error) if the tbPessoa couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tb-pessoas")
    @Timed
    public ResponseEntity<TbPessoa> updateTbPessoa(@Valid @RequestBody TbPessoa tbPessoa) throws URISyntaxException {
        log.debug("REST request to update TbPessoa : {}", tbPessoa);
        if (tbPessoa.getId() == null) {
            return createTbPessoa(tbPessoa);
        }
        TbPessoa result = tbPessoaRepository.save(tbPessoa);
        tbPessoaSearchRepository.save(result);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tbPessoa.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tb-pessoas : get all the tbPessoas.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of tbPessoas in body
     */
    @GetMapping("/tb-pessoas")
    @Timed
    public List<TbPessoa> getAllTbPessoas() {
        log.debug("REST request to get all TbPessoas");
        return tbPessoaRepository.findAll();
        }

    /**
     * GET  /tb-pessoas/:id : get the "id" tbPessoa.
     *
     * @param id the id of the tbPessoa to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tbPessoa, or with status 404 (Not Found)
     */
    @GetMapping("/tb-pessoas/{id}")
    @Timed
    public ResponseEntity<TbPessoa> getTbPessoa(@PathVariable Long id) {
        log.debug("REST request to get TbPessoa : {}", id);
        TbPessoa tbPessoa = tbPessoaRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(tbPessoa));
    }

    /**
     * DELETE  /tb-pessoas/:id : delete the "id" tbPessoa.
     *
     * @param id the id of the tbPessoa to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tb-pessoas/{id}")
    @Timed
    public ResponseEntity<Void> deleteTbPessoa(@PathVariable Long id) {
        log.debug("REST request to delete TbPessoa : {}", id);
        tbPessoaRepository.delete(id);
        tbPessoaSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/tb-pessoas?query=:query : search for the tbPessoa corresponding
     * to the query.
     *
     * @param query the query of the tbPessoa search
     * @return the result of the search
     */
    @GetMapping("/_search/tb-pessoas")
    @Timed
    public List<TbPessoa> searchTbPessoas(@RequestParam String query) {
        log.debug("REST request to search TbPessoas for query {}", query);
        return StreamSupport
            .stream(tbPessoaSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .collect(Collectors.toList());
    }

}
