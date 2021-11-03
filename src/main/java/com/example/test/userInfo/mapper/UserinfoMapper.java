package com.example.test.userInfo.mapper;

import com.example.test.userInfo.model.Userinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lyh
 * @since 2021-11-01
 */
public interface UserinfoMapper extends BaseMapper<Userinfo> {

     List<Userinfo> findAllUser();

     Userinfo getUser(String userName , String password);
}
