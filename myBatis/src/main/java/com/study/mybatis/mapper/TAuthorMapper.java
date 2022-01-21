package com.study.mybatis.mapper;

import com.study.mybatis.DO.TAuthor;

public interface TAuthorMapper {
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
    int insert(TAuthor row);

    /**
    * insertSelective
    * @param row row
    * @return int int
    */
    int insertSelective(TAuthor row);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return TAuthor TAuthor
    */
    TAuthor selectByPrimaryKey(Long id);

    /**
    * updateByPrimaryKeySelective
    * @param row row
    * @return int int
    */
    int updateByPrimaryKeySelective(TAuthor row);

    /**
    * updateByPrimaryKey
    * @param row row
    * @return int int
    */
    int updateByPrimaryKey(TAuthor row);
}