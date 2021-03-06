package org.hmsystem.server.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hmsystem.server.utils.JwtTokenUtil;
import org.hmsystem.server.pojo.RespBean;
import org.hmsystem.server.pojo.UserLoginParam;
import org.hmsystem.server.pojo.Usertable;
import org.hmsystem.server.service.IUsertableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Api(tags = "LoginController")
@RestController
public class LoginController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private IUsertableService usertableService;

    @ApiOperation(value = "登陆后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody UserLoginParam userLoginParam, HttpServletRequest request){
        return usertableService.login(userLoginParam.getUsername(),userLoginParam.getPassword(),userLoginParam.getCode(),request);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @PostMapping("/admin/info")
    public Usertable getUserInfo(Principal principal){
        if (null==principal){
            return null;
        }
        String username = principal.getName();
        Usertable user = usertableService.getUserByUserName(username);
        user.setUserpassword(null);
        return user;
    }

    @ApiOperation(value = "获取登录用户")
    @PostMapping("/logInfo")
    public Usertable getUser(@RequestParam("token") String token){
        String username = jwtTokenUtil.getUserNameFromToken(token);
        Usertable usertable = usertableService.getUserByUserName(username);
        usertable.setUserpassword(null);
        return usertable;
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success("注销成功");
    }

}
