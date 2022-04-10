package com.study.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.study.mybatisplus.entity.TAddress;
import com.study.mybatisplus.entity.TAddressInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TAddressMapper extends BaseMapper<TAddressInfo> {

    IPage<TAddressInfo> findById(IPage<TAddressInfo> ipage , Long id);
}
