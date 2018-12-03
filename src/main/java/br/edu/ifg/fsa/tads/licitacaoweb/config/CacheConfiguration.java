package br.edu.ifg.fsa.tads.licitacaoweb.config;

import io.github.jhipster.config.JHipsterProperties;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.ehcache.jsr107.Eh107Configuration;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
@AutoConfigureAfter(value = { MetricsConfiguration.class })
@AutoConfigureBefore(value = { WebConfigurer.class, DatabaseConfiguration.class })
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        JHipsterProperties.Cache.Ehcache ehcache =
            jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(ehcache.getTimeToLiveSeconds(), TimeUnit.SECONDS)))
                .build());
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.repository.UserRepository.USERS_BY_LOGIN_CACHE, jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.repository.UserRepository.USERS_BY_EMAIL_CACHE, jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.User.class.getName(), jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.Authority.class.getName(), jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.User.class.getName() + ".authorities", jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.SocialUserConnection.class.getName(), jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.TbPessoa.class.getName(), jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.TbEndereco.class.getName(), jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.TbContato.class.getName(), jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.TbInstituicao.class.getName(), jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.TbInstituicao.class.getName() + ".tbCabecalhos", jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.TbDocumento.class.getName(), jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.TbCabecalho.class.getName(), jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.TbCabecalho.class.getName() + ".tbMensagems", jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.TbMensagem.class.getName(), jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.TbMensagem.class.getName() + ".tbDocumentos", jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.TbLicitacao.class.getName(), jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.TbInstituicao.class.getName() + ".cabecalhos", jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.TbMensagem.class.getName() + ".documentos", jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.TbItem.class.getName(), jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.TbMaterial.class.getName(), jcacheConfiguration);
            cm.createCache(br.edu.ifg.fsa.tads.licitacaoweb.domain.TbServico.class.getName(), jcacheConfiguration);
            // jhipster-needle-ehcache-add-entry
        };
    }
}
