package org.hmsystem.server.controller;

import io.swagger.annotations.ApiOperation;
import org.hmsystem.server.utils.MD5Util;
import org.hmsystem.server.pojo.RespBean;
import org.hmsystem.server.pojo.User;
import org.hmsystem.server.service.IUsertableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping
public class RegisterController {

    @Autowired
    IUsertableService usertableService;

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public RespBean register(@RequestBody User user){
        user.setCreatedate(LocalDateTime.now());
        user.setUserpassword(MD5Util.encode(user.getUserpassword()));
        if (usertableService.register(user)){
            return RespBean.success("注册成功");
        }
        return RespBean.error("注册失败");
    }
}
