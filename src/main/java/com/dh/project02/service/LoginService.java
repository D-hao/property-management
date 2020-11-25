package com.dh.project02.service;

import com.dh.project02.bean.TblUserRecord;
import com.dh.project02.mapper.TblUserRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther:D-hao
 * @Date:2020/11/11-11-11-16:20
 * @Description:com.dh.project02.service
 */
@Service
public class LoginService {
    @Autowired
    private TblUserRecordMapper tblUserRecordMapper;

    public TblUserRecord login(String username, String password){
        return tblUserRecordMapper.login(username, password);
    }

}
