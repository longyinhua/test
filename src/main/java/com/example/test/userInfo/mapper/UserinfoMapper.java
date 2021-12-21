package com.example.test.userInfo.mapper;

import com.example.test.userInfo.model.Userinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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

     @Select("select * from userinfo")
     @Results(id="studentMap",value = {
             @Result(id = true, column = "id", property = "id"),
             @Result(column = "name", property = "name"),
             @Result(column = "password", property = "password"),})
     List<Userinfo> findAllUser();

     Userinfo getUser(String userName , String password);
}
