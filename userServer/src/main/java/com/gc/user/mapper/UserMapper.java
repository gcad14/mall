package com.gc.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gc.user.entity.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User>{
    /**
     * 用户新增
     * @param user
     * @return
     */
    void addUser(User user);

    List<User> getUserName(String userName);
}
