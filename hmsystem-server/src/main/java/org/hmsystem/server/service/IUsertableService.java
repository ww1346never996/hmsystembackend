package org.hmsystem.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.hmsystem.server.pojo.RespBean;
import org.hmsystem.server.pojo.Usertable;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ww1346
 * @since 2021-03-29
 */
public interface IUsertableService extends IService<Usertable> {

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    Usertable getUserByUserName(String username);


    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);
}
