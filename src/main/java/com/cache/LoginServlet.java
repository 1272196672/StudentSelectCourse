package com.cache;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.Dao.userDao;
import com.redis.AddToRedis;

/**
 * @author 林子翔
 * @since 2022 05 2022/5/13
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public LoginServlet() {
        //            添加全部课程
        AddToRedis.addAllCourse();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String pwd = req.getParameter("pwd");
        int id = userDao.findUserId(account, pwd);
        if (id != 0){
            System.out.println(id);
//            添加学生id
            AddToRedis.addStuId(id);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/showSelect");
            dispatcher.forward(req, resp);
        }
        else {
            System.out.println("错误登录");
        }
    }
}
