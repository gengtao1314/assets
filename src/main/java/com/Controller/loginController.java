package com.Controller;

import com.Dao.LogMapper;
import com.Pojo.User;
import com.Service.ShiroService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录管理
 */
@Controller
@RequestMapping("/user")
public class loginController {
    @Autowired
    private ShiroService shiroService;
    @Autowired
    private LogMapper logMapper;
    private Logger logger = Logger.getLogger(loginController.class);

    /**
     * 验证登录
     *
     * @param username
     * @param password
     * @param session
     * @return url
     */
    @RequestMapping(value = "/login")
    public String Login(HttpServletRequest  request,String username, String password, HttpSession session, Model model) {


/*
        // 通过账号和密码查询用户
        User user = userService.findUser(usercode, password);
        if (user != null) {
            // 将用户对象添加到Session
            session.setAttribute("USER_SESSION", user);
            // 跳转到主页面
//			return "customer";
            return "redirect:customer/list.action";
        }
        model.addAttribute("msg", "账号或密码错误，请重新输入！");
        // 返回到登录页面
        return "login";
        */

         //用户名为空时，返回登录界面
       if (username == null) {
            model.addAttribute("message", "账号不为空");
            return "login";//返回登录界面
        }

        //主体,当前状态为没有认证的状态“未认证”
        Subject subject = SecurityUtils.getSubject();
        // 登录后存放进shiro token
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        User user;
        //登录方法（认证是否通过）
        //使用subject调用securityManager,安全管理器调用Realm
        try {
            //利用异常操作
            //需要开始调用到Realm中
            //  System.out.println("========================================");
            // System.out.println("1、进入认证方法");
            subject.login(token); //通过shiro完成登录验证
            user = (User) subject.getPrincipal();//获取验证后的用户信息
            session.setAttribute("user", subject);//将用户登录信息保存到session中,登录信息包含了用户信息
            session.setAttribute("USER_SESSION", subject.getPrincipal());//用户信息保存到session中
           // model.addAttribute("message", "登录完成");

            //添加登录信息
            String IP= getIp(request);//获取用户登录的IP
            Map<String,Object> logparam = new HashMap<>();//实例化一个map
            logparam.put("createDate",new Date());//设置登录日期为当前时间
            logparam.put("createUser",username);//设置创建人为当前登录人
            logparam.put("ip",IP);//设置IP地址
            logparam.put("createUserId",user.getId());//设置用户的ID
            logMapper.insert(logparam);//向登录日志中添加一条登录信息
            // System.out.println("登录完成");
        } catch (UnknownAccountException e) {//如果发生错误
            model.addAttribute("message", "账号密码不正确");
            return "login";//发生错时返回登录界面
        }
        return "index";//登录成功,进入管理界面

    }

    @RequestMapping("/check")
    public String check(HttpSession session) {

        Subject subject = (Subject) session.getAttribute("user");

        User user = (User) subject.getPrincipal();
        System.out.println(user.toString());
        return "permission";
    }

    //退出登录
    @RequestMapping("logout")
    public String logout() {
        System.out.println("logout!");
        return "login";//进入登录界面
    }

    //获取用户登录的IP
    public String getIp(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.equals("0:0:0:0:0:0:0:1")) {
            ip = "本地";
        }
        return ip;
    }
}
