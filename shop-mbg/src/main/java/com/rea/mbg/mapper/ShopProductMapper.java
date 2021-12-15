package com.rea.mbg.mapper;

import com.rea.mbg.model.ShopProduct;
import com.rea.mbg.model.ShopProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopProductMapper {
    long countByExample(ShopProductExample example);

    int deleteByExample(ShopProductExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(ShopProduct record);

    int insertSelective(ShopProduct record);

    List<ShopProduct> selectByExample(ShopProductExample example);

    ShopProduct selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") ShopProduct record, @Param("example") ShopProductExample example);

    int updateByExample(@Param("record") ShopProduct record, @Param("example") ShopProductExample example);

    int updateByPrimaryKeySelective(ShopProduct record);

    int updateByPrimaryKey(ShopProduct record);
}