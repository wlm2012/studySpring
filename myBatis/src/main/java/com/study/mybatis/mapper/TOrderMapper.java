package com.study.mybatis.mapper;

import com.study.mybatis.DO.TOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TOrderMapper {
    /**
    * deleteByPrimaryKey
    * @param id id
    * @return int int
    */
    int deleteByPrimaryKey(Long id);

    /**
    * insert
    * @param row row
    * @return int int
    */
    int insert(TOrder row);

    /**
    * insertSelective
    * @param row row
    * @return int int
    */
    int insertSelective(TOrder row);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return TOrder TOrder
    */
    TOrder selectByPrimaryKey(Long id);

    /**
    * updateByPrimaryKeySelective
    * @param row row
    * @return int int
    */
    int updateByPrimaryKeySelective(TOrder row);

    /**
    * updateByPrimaryKey
    * @param row row
    * @return int int
    */
    int updateByPrimaryKey(TOrder row);
}