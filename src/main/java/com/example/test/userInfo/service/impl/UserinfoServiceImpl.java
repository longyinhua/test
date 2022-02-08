package com.example.test.userInfo.service.impl;

import com.example.test.userInfo.model.Userinfo;
import com.example.test.userInfo.mapper.UserinfoMapper;
import com.example.test.userInfo.service.UserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyh
 * @since 2021-11-01
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements UserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;


    @Override
    public List<Userinfo> findAllUser() {
        return userinfoMapper.findAllUser();
    }

    @Override
    public Userinfo getUser(String userName, String password) {
        return userinfoMapper.getUser(userName,password);
    }

    @Override
    public int insertUser(Userinfo userinfo) {
        return userinfoMapper.insert(userinfo);
    }
}
