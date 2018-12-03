package br.edu.ifg.fsa.tads.licitacaoweb.web.rest;

import com.codahale.metrics.annotation.Timed;
import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbEndereco;

import br.edu.ifg.fsa.tads.licitacaoweb.repository.TbEnderecoRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.search.TbEnderecoSearchRepository;
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
 * REST controller for managing TbEndereco.
 */
@RestController
@RequestMapping("/api")
public class TbEnderecoResource {

    private final Logger log = LoggerFactory.getLogger(TbEnderecoResource.class);

    private static final String ENTITY_NAME = "tbEndereco";

    private final TbEnderecoRepository tbEnderecoRepository;

    private final TbEnderecoSearchRepository tbEnderecoSearchRepository;

    public TbEnderecoResource(TbEnderecoRepository tbEnderecoRepository, TbEnderecoSearchRepository tbEnderecoSearchRepository) {
        this.tbEnderecoRepository = tbEnderecoRepository;
        this.tbEnderecoSearchRepository = tbEnderecoSearchRepository;
    }

    /**
     * POST  /tb-enderecos : Create a new tbEndereco.
     *
     * @param tbEndereco the tbEndereco to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tbEndereco, or with status 400 (Bad Request) if the tbEndereco has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tb-enderecos")
    @Timed
    public ResponseEntity<TbEndereco> createTbEndereco(@Valid @RequestBody TbEndereco tbEndereco) throws URISyntaxException {
        log.debug("REST request to save TbEndereco : {}", tbEndereco);
        if (tbEndereco.getId() != null) {
            throw new BadRequestAlertException("A new tbEndereco cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TbEndereco result = tbEnderecoRepository.save(tbEndereco);
        tbEnderecoSearchRepository.save(result);
        return ResponseEntity.created(new URI("/api/tb-enderecos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tb-enderecos : Updates an existing tbEndereco.
     *
     * @param tbEndereco the tbEndereco to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tbEndereco,
     * or with status 400 (Bad Request) if the tbEndereco is not valid,
     * or with status 500 (Internal Server Error) if the tbEndereco couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tb-enderecos")
    @Timed
    public ResponseEntity<TbEndereco> updateTbEndereco(@Valid @RequestBody TbEndereco tbEndereco) throws URISyntaxException {
        log.debug("REST request to update TbEndereco : {}", tbEndereco);
        if (tbEndereco.getId() == null) {
            return createTbEndereco(tbEndereco);
        }
        TbEndereco result = tbEnderecoRepository.save(tbEndereco);
        tbEnderecoSearchRepository.save(result);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tbEndereco.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tb-enderecos : get all the tbEnderecos.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of tbEnderecos in body
     */
    @GetMapping("/tb-enderecos")
    @Timed
    public List<TbEndereco> getAllTbEnderecos() {
        log.debug("REST request to get all TbEnderecos");
        return tbEnderecoRepository.findAll();
        }

    /**
     * GET  /tb-enderecos/:id : get the "id" tbEndereco.
     *
     * @param id the id of the tbEndereco to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tbEndereco, or with status 404 (Not Found)
     */
    @GetMapping("/tb-enderecos/{id}")
    @Timed
    public ResponseEntity<TbEndereco> getTbEndereco(@PathVariable Long id) {
        log.debug("REST request to get TbEndereco : {}", id);
        TbEndereco tbEndereco = tbEnderecoRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(tbEndereco));
    }

    /**
     * DELETE  /tb-enderecos/:id : delete the "id" tbEndereco.
     *
     * @param id the id of the tbEndereco to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tb-enderecos/{id}")
    @Timed
    public ResponseEntity<Void> deleteTbEndereco(@PathVariable Long id) {
        log.debug("REST request to delete TbEndereco : {}", id);
        tbEnderecoRepository.delete(id);
        tbEnderecoSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/tb-enderecos?query=:query : search for the tbEndereco corresponding
     * to the query.
     *
     * @param query the query of the tbEndereco search
     * @return the result of the search
     */
    @GetMapping("/_search/tb-enderecos")
    @Timed
    public List<TbEndereco> searchTbEnderecos(@RequestParam String query) {
        log.debug("REST request to search TbEnderecos for query {}", query);
        return StreamSupport
            .stream(tbEnderecoSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .collect(Collectors.toList());
    }

}
