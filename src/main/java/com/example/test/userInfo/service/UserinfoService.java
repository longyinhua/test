package com.example.test.userInfo.service;

import com.example.test.userInfo.model.Userinfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyh
 * @since 2021-11-01
 */
public interface UserinfoService extends IService<Userinfo> {


    /**
     * 获取所有用户信息
     * @return
     */
    List<Userinfo> findAllUser();

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    Userinfo getUser(String userName , String password);

}
