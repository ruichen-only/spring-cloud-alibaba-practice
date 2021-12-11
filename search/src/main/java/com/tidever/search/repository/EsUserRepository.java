package com.tidever.search.repository;

import com.tidever.search.domain.EsUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 定义数据操作方法
 *
 * @author LiuXin on 2021/11/24
 */
public interface EsUserRepository extends ElasticsearchRepository<EsUser, Long> {
    /**
     * 根据名称查询。
     *
     * @param username      周期名
     * @param page      分页信息
     * @return
     */
    Page<EsUser> findByUsername(String username, Pageable page);
}
