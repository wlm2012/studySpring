package com.study.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.study.mybatisplus.domain.entity.TAddressInfo;

public interface TAddressInfoMapper extends BaseMapper<TAddressInfo> {

    IPage<TAddressInfo> findById(IPage<TAddressInfo> ipage, Long id);
}
