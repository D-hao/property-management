package com.dh.project02.mapper;

import com.dh.project02.bean.FcCell;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 房间信息表 Mapper 接口
 * </p>
 *
 * @author lian
 * @since 2020-11-10
 */
@Mapper
@Component
public interface FcCellMapper extends BaseMapper<FcCell> {

}
