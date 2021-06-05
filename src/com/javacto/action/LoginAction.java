package com.javacto.action;

import com.javacto.po.User;
import com.javacto.service.UserService;
import com.javacto.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login.do")
public class LoginAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理请求编码格式
        req.setCharacterEncoding("UTF-8");
        // 处理响应编码格式
        resp.setContentType("text/html;charset=UTF-8");
        // 获取前端的请求参数
        String name = req.getParameter("userName");
        String pwd = req.getParameter("pwd");
        // 创建业务层对象
        UserService userService = new UserServiceImpl();
        // 调用登录方法
        User user = userService.login(name,pwd);
        // 判断user是否有值 如果有值代表登陆成功 没有值代表登录失败
        if (null != user) {
            System.out.println("登陆成功");
            // 登陆成功，调用一个查询用户信息的url
            req.getRequestDispatcher("/queryUserAll.do").forward(req,resp);
        } else {
            System.out.println("登录失败");
            // 登陆失败，跳转到login.jsp
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
