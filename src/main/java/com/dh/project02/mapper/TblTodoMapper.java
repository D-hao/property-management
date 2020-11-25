package com.dh.project02.mapper;

import com.dh.project02.bean.TblTodo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 待办事项 Mapper 接口
 * </p>
 *
 * @author lian
 * @since 2020-11-10
 */
@Mapper
public interface TblTodoMapper extends BaseMapper<TblTodo> {

}
