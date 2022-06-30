package com.servlet;

import com.Dao.courseDao;
import com.Dao.selectDao;
import com.redis.AddToRedis;
import com.redis.GetFromRedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 林子翔
 * @since 2022 05 2022/5/30
 */
@WebServlet("/remoteLogin")
public class remoteLogin extends HttpServlet {
    public remoteLogin() {
        //            添加全部课程
        AddToRedis.addAllCourse();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("http://8.130.17.147:8082/loginService/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
