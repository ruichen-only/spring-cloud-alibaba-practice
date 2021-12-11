package com.tidever.platform.service;

import com.tidever.mbg.model.platform.User;

/**
 * 后台用户缓存操作类
 * @author CRR
 */
public interface UserCacheService {
    /**
     * 删除后台用户缓存
     * @param id
     */
    void delUser(Long id);

    /**
     * 获取缓存后台用户信息
     * @param id
     * @return
     */
    User getUser(Long id);

    /**
     * 设置缓存后台用户信息
     * @param user
     */
    void setUser(User user);
}
