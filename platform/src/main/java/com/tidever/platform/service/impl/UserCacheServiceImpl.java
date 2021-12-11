package com.tidever.platform.service.impl;

import com.tidever.common.service.RedisService;
import com.tidever.mbg.model.platform.User;
import com.tidever.platform.service.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author CRR
 */
public class UserCacheServiceImpl implements UserCacheService {
    @Autowired
    private RedisService redisService;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;

    @Override
    public void delUser(Long id) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + id;
        redisService.del(key);
    }

    @Override
    public User getUser(Long id) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + id;
        return (User) redisService.get(key);
    }

    @Override
    public void setUser(User user) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + user.getId();
        redisService.set(key, user, REDIS_EXPIRE);

    }
}
