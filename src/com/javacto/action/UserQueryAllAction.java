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
import java.util.List;

@WebServlet("/queryUserAll.do")
public class UserQueryAllAction extends HttpServlet {
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
        // 创建业务层代码
        UserService userService = new UserServiceImpl();
        // 调用查询所有方法
        List<User> list = userService.queryAll();
        // 把结果存入HttpServletRequest 对象中
        req.setAttribute("list",list);
        // 跳转到userList.jsp
        req.getRequestDispatcher("/userList.jsp").forward(req,resp);
    }
}
