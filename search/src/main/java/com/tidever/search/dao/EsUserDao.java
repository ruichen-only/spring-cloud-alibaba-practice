package com.tidever.search.dao;

import com.tidever.search.domain.EsUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Visit DB检索接口类
 *
 * @author LiuXin on 2021/11/25
 */
public interface EsUserDao {
    List<EsUser> getAllEsUserList(@Param("id") Long id);
}
