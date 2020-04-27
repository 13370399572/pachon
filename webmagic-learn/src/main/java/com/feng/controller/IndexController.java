package com.feng.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feng.common.SCaptcha;



@Controller
public class IndexController {
    @RequestMapping({"","/","index"})
    public String index(){
        return "redirect:/films/list.htm";
    }
   
    @RequestMapping("/shouye")
    public String indexx(){
        return "index";
    }
    
    
    
    @RequestMapping("dologin")
    @ResponseBody
    public String dologin(String username , String password ,HttpSession session) {
    	Subject subject = SecurityUtils.getSubject();
    	UsernamePasswordToken token = new UsernamePasswordToken(username,password);
    	session.setAttribute("username", username);
    	subject.login(token);
    	return  "登陆成功";
    }
    
    @RequestMapping("getname")
    @ResponseBody
    public String getName(HttpSession session) {
     String username =	(String)session.getAttribute("username");
     return username;
    }
    
    
    @RequestMapping(value = "/userInfo/verification", method = {RequestMethod.GET, RequestMethod.GET})
    @ResponseBody
     public void verification( HttpServletResponse response, HttpServletRequest request ,HttpSession session) throws IOException {
          // 设置响应的类型格式为图片格式
         response.setContentType("image/jpeg");
     // 禁止图像缓存。
         response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
         //实例生成验证码对象
         SCaptcha instance = new SCaptcha();
         //将验证码存入session
        
         session.setAttribute("verification", instance.getCode());
         //向页面输出验证码图片
        instance.write(response.getOutputStream());
     }
    
    @RequestMapping(value = "/userInfo/getverification", method = {RequestMethod.GET})
    @ResponseBody
     public String getverification( HttpSession session) throws IOException {
     String verification	= (String)session.getAttribute("verification");
     
     return verification;
     }
    
    @RequestMapping(value = "/userInfo/logout", method = {RequestMethod.GET})
    public String logout() {
    return "/index";
    }
}
