package com.dh.project02.mapper;

import com.dh.project02.bean.FcEstate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 楼盘信息 Mapper 接口
 * </p>
 *
 * @author lian
 * @since 2020-11-10
 */
@Mapper
@Component
public interface FcEstateMapper extends BaseMapper<FcEstate> {

}
