package org.acme;


import java.util.ArrayList;
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

@ApplicationScoped
public class ScoreService {

    Cache<Object, Score> scoreCache;

    Logger log = LoggerFactory.getLogger(ScoreService.class);

    @Inject
    EmbeddedCacheManager cacheManager;

    public List<Object> getAll() {
        return new ArrayList<>(scoreCache.values());
    }

    
    public void save(Score entry) {
        scoreCache.put(entry.getPlayerId(), entry);
    }

    public void delete(Score entry) {
        scoreCache.remove(entry.getPlayerId());
    }

    public void getEntry(Score entry){
        scoreCache.get(entry.getPlayerId());
    }

    public void getEntry(String playerId){
        scoreCache.get(playerId);
    }

    @PostConstruct
    public void init(){

        EmbeddedCacheManager cacheManager = new DefaultCacheManager();
        cacheManager.defineConfiguration("users", new ConfigurationBuilder().build());
        scoreCache = cacheManager.getCache("users");
        scoreCache.addListener(new CacheListener());

        Score card = new Score("Shaaf", "1");
        card.addScore(5);
        card.addScore(4);
        scoreCache.put(card.getPlayerId(), card);

    }

    public Object findById(String id) {
        return scoreCache.get(id);
    }
}