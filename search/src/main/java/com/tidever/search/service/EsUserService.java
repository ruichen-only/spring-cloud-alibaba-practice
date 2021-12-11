package com.tidever.search.service;

import com.tidever.search.domain.EsUser;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Visit业务接口类
 *
 * @author LiuXin on 2021/11/25
 */
public interface EsUserService {
    /**
     * 从数据库导入所有周期数据到Es
     * @return
     */
    int importAll();

    /**
     * 根据id删除周期
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id批量删除周期
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 根据id创建周期
     * @param id
     * @return
     */
    EsUser create(Long id);

    /**
     * 根据名称和code检索周期
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<EsUser> search(String name, Integer pageNum, Integer pageSize);
}
