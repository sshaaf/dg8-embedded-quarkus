package org.acme;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import org.infinispan.Cache;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;

import java.util.stream.Collectors;

@ApplicationScoped
public class ScoreService {

    private Set<ScoreCard> entries = new HashSet<>();

    Cache<Object, Object> userCache;

    Logger log = LoggerFactory.getLogger(ScoreService.class);

    @Inject
    EmbeddedCacheManager cacheManager;

    public List<Object> getAll() {
        return userCache.entrySet().stream().collect(Collectors.toList());
    }

    
    public void save(ScoreCard entry) {
        entries.add(entry);
    }

    public void delete(ScoreCard entry) {
        entries.remove(entry);
    }


    @PostConstruct
    public void init(){

        EmbeddedCacheManager cacheManager = new DefaultCacheManager();
        cacheManager.defineConfiguration("users", new ConfigurationBuilder().build());
        userCache = cacheManager.getCache("users");
        userCache.addListener(new CacheListener());

        ScoreCard card = new ScoreCard("Shaaf", "1");
        userCache.put(card, card.playerId);

    }

    public Object findById(String id) {
        return userCache.get(id);
    }
}