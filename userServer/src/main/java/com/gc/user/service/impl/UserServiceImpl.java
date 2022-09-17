package com.gc.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ctc.wstx.util.StringUtil;
import com.gc.user.entity.po.User;
import com.gc.user.mapper.UserMapper;
import com.gc.user.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public Object addUser(User user) {
        userMapper.insert(user);
        return null;
    }

    @Override
    public List<String> getUserName(String userName) {
        List<User> userList = userMapper.selectList(new QueryWrapper<User>()
                .lambda()
                .eq(User::getUserName, userName)
        );
        List<String> collect = userList.stream().map(User::getUserName).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<User> getUserList(Integer pageNum,Integer pageSize) {

//        PageHelper.startPage(pageNum,pageSize);
        List<User> userList1 = userMapper.selectList(new QueryWrapper<User>()
                .lambda()
        );


        List<User> userList = new ArrayList<>();
        List<User> resultList = new ArrayList<>();
        List<User> listUser = new ArrayList<>();
        userList.add(new User("张三", "123456", "asdf", "af", "男", 18));
        userList.add(new User("李四", "123456", "asdf", "af", "女", 18));
        userList.add(new User("张三", "123456", "asdf", "af", "男", 18));
        userList.add(new User("李四", "123456", "asdf", "af", "女", 18));
        userList.add(new User("张三", "123456", "asdf", "af", "男", 18));
        userList.add(new User("李四", "123456", "asdf", "af", "女", 18));
        userList.add(new User("张三", "123456", "asdf", "af", "女", 18));
        userList.add(new User("张三", "123456", "asdf", "af", "女", 18));
        userList.add(new User("李四", "123456", "asdf", "af", "男", 18));
        userList.add(new User("张三", "123456", "asdf", "af", "女", 18));
        userList.add(new User("李四", "123456", "asdf", "af", "男", 18));
        userList.add(new User("张三", "123456", "asdf", "af", "女", 18));
        userList.add(new User("张三", "123456", "asdf", "af", "女", 18));

        for (User user : userList) {
            if (listUser.size() == 0) {
                listUser.add(user);
            } else {
                boolean tf = true;
                for (User user1 : listUser) {
                    if (StringUtil.equalEncodings(user.getUserName(), user1.getUserName()) &&
                            StringUtil.equalEncodings(user.getSex(), user1.getSex())) {
                        tf = false;
                        user1.setAge(user.getAge() + user1.getAge());
                    }
                }
                if (tf) {
                    listUser.add(user);
                }
            }
        }

        for (User user : listUser) {
            resultList.add(user);
        }
        for (User user : userList) {
            resultList.add(user);
        }
        for (User user : userList1) {
            resultList.add(user);
        }
        return resultList;
    }
}
