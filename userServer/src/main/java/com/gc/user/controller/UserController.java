package com.gc.user.controller;

import com.gc.response.ResponseData;
import com.gc.user.entity.po.User;
import com.gc.user.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/aaa")
    public String aaa(String name) {
        return "你好：" + name;
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "新增用户")
    public ResponseData addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseData.success();
    }

    @GetMapping("/getUserName")
    public ResponseData getUserName(String userName) {
        userService.getUserName(userName);
        return ResponseData.success(userName);
    }

    @GetMapping(value = "/getUserList")
    @ApiOperation("查询用户列表")
    public ResponseData getUserList(Integer pageNum,Integer pageSize){
        List<User> userList = userService.getUserList(pageNum,pageSize);
        return ResponseData.success(new PageInfo<>(userList));
    }
}
