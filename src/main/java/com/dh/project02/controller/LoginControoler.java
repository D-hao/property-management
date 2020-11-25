package com.dh.project02.controller;

import com.alibaba.fastjson.JSONObject;
import com.dh.project02.bean.TblUserRecord;
import com.dh.project02.returnJson.Permission;
import com.dh.project02.returnJson.Permissions;
import com.dh.project02.returnJson.ReturnObject;
import com.dh.project02.returnJson.UserInfo;
import com.dh.project02.service.LoginService;
import org.mybatis.spring.annotation.MapperScan;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:D-hao
 * @Date:2020/11/10-11-10-13:56
 * @Description:com.dh.project02.controller
 */

//@RestController=@controller+@ResponsedBody
// @ResponseBody:的作用其实是将java对象转为json格式的数据,返回给页面时候比较友好
// @controller:扫描com.dh目录下所有的包，一旦发现有个类上面加了类似于@Controller的注解，在容器启动的时候系统就会把它加载到Spring的Bean工厂，并且对其实例化。
@RestController
//解决跨域 (allowCredentials = "true",不配置的化，每次请求都是不同的session)
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {}, allowCredentials = "true")
public class LoginControoler {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/auth/2step-code")
    public boolean test() {
        System.out.println("==========前端自带的一个验证规则，写不写都无所谓=======");
        return true;
    }

    /**
     * 多个请求之间想实现数据共享的化可以用 session
     * =====函数作用：需要返回的是一个用户信息的Json固定信息======
     */
    @RequestMapping("/auth/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        System.out.println("login=========");
        TblUserRecord tblUserRecord = loginService.login(username, password);
        tblUserRecord.setToken(tblUserRecord.getUserName());
        //将用户信息写入到session中
        session.setAttribute("userRecord", tblUserRecord);
        ReturnObject returnObject = new ReturnObject(tblUserRecord);
        return JSONObject.toJSONString(returnObject);
    }

    /**
     * 跨域请求的时候，会导致session共享数据失效。因为会产生两不同的session，取不到数据
     * 后端需要设置：@CrossOrigin(origins = "*",allowCredentials = "true")     allowCredentials！
     * 前端设置（看看即可）：axios.defaults.withCredentials=true
     *
     * @param session ========函数作用：需要返回的时从通过session共享拿到用户信息里的权限信息，通过固定合适返回========
     */
    @RequestMapping("/user/info")
    public String getInfo(HttpSession session) {
        TblUserRecord userRecord = (TblUserRecord) session.getAttribute("userRecord");
        System.out.println("===========================================");
        //获取模块信息
        String[] split = userRecord.getTblRole().getRolePrivileges().split("-");
        //创建权限集合对象
        Permissions permissions = new Permissions();
        //向集合权限中添加具体的权限
        List<Permission> permissionList = new ArrayList<>();
        for (String s : split) {
            permissionList.add(new Permission(s));
        }
        permissions.setPermissions(permissionList);
        //设置返回值的result
        UserInfo userInfo = new UserInfo(userRecord.getUserName(), permissions);
        ReturnObject returnObject = new ReturnObject(userInfo);
        System.out.println(returnObject);
        return JSONObject.toJSONString(returnObject);
    }

    @RequestMapping("/auth/logout")
    public String logOut(HttpSession session) {
        System.out.println("=========logOut==========");
        session.invalidate();
        return "";
    }
}
