package com.gc.user.service;

import com.gc.user.entity.po.User;

import java.util.List;

public interface IUserService {
    /**
     * 用户新增
     * @param user
     * @return
     */
    Object addUser(User user);

    /**
     * 查询用户名是否重复
     * @param userName
     * @return
     */
    List<String> getUserName(String userName);

    /**
     * 查询用户列表
     * @return
     */
    List<User> getUserList(Integer pageNum,Integer pageSize);
}
