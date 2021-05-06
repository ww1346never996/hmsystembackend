package org.hmsystem.server.controller;


import io.swagger.annotations.ApiOperation;
import org.hmsystem.server.pojo.RespBean;
import org.hmsystem.server.pojo.User;
import org.hmsystem.server.pojo.Usertable;
import org.hmsystem.server.service.IUsertableService;
import org.hmsystem.server.utils.JwtTokenUtil;
import org.hmsystem.server.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ww1346
 * @since 2021-03-29
 */
@RestController
@RequestMapping("/usertable")
public class UsertableController {
    @Autowired
    IUsertableService usertableService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @ApiOperation("修改用户信息")
    @PostMapping("/changeUserInfo")
    public RespBean changeUserInfo(@RequestBody Usertable user){
        if (user!=null){
            //存入数据库密码加密
            MD5Util md5Util = new MD5Util();
            user.setUserpassword(md5Util.encode(user.getUserpassword()));
            if (usertableService.changeInfo(user)){
                return RespBean.success("修改信息成功");
            }else {
                return RespBean.error("修改信息失败");
            }
        }
        return RespBean.error("传入值不能为空");
    }

    @ApiOperation("获取全部用户列表")
    @GetMapping("/getUserList")
    public List<Usertable> getUserList(){
        List<Usertable> userList = usertableService.getUserList();
        for (int i=0;i<userList.size();i++){
            //向前端返回用户密码时置空防止泄露
            userList.get(i).setUserpassword(null);
        }
        return userList;
    }

    @ApiOperation("根据当前登录用户token获取用户对象")
    @PostMapping("/getUser")
    public Usertable getUser(@RequestParam("token")String token){
        if (!token.isEmpty()){
            String username = jwtTokenUtil.getUserNameFromToken(token);
            Usertable usertable = usertableService.getUserByUserName(username);
            usertable.setUserpassword(null);
            return usertable;
        }
        return null;
    }
}
