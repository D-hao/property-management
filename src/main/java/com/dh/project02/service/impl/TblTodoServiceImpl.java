package com.dh.project02.service.impl;

import com.dh.project02.bean.TblTodo;
import com.dh.project02.mapper.TblTodoMapper;
import com.dh.project02.service.base.TblTodoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 待办事项 服务实现类
 * </p>
 *
 * @author lian
 * @since 2020-11-10
 */
@Service
public class TblTodoServiceImpl extends ServiceImpl<TblTodoMapper, TblTodo> implements TblTodoService {

}
