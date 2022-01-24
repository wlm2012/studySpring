package com.study.mybatis.mapper;

import com.study.mybatis.DO.TDog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TDogMapper {
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
    int insert(TDog row);

    /**
    * insertSelective
    * @param row row
    * @return int int
    */
    int insertSelective(TDog row);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return TDog TDog
    */
    TDog selectByPrimaryKey(Long id);

    /**
    * updateByPrimaryKeySelective
    * @param row row
    * @return int int
    */
    int updateByPrimaryKeySelective(TDog row);

    /**
    * updateByPrimaryKey
    * @param row row
    * @return int int
    */
    int updateByPrimaryKey(TDog row);
}