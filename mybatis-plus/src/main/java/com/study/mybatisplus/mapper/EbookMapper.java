package com.study.mybatisplus.mapper;

import com.study.mybatisplus.domain.entity.Ebook;

/**
* @author wlm
* @description 针对表【ebook】的数据库操作Mapper
* @createDate 2022-04-11 22:15:31
* @Entity com.study.mybatisplus.entity.Ebook
*/
public interface EbookMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Ebook record);

    int insertSelective(Ebook record);

    Ebook selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Ebook record);

    int updateByPrimaryKey(Ebook record);

}
