package com.dh.project02.mapper;

import com.dh.project02.bean.TblUserRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户档案 Mapper 接口
 * </p>
 *
 * @author lian
 * @since 2020-11-10
 */
@Mapper
@Component
public interface TblUserRecordMapper extends BaseMapper<TblUserRecord> {
public TblUserRecord login(@Param("username") String username,@Param("password") String password);
}
