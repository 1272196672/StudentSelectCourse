package com.servlet; /**
 * @author 林子翔
 * @since 2022 05 2022/5/19
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.Dao.selectDao;
import com.redis.GetFromRedis;

@WebServlet("/dropCourse")
public class DropCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = GetFromRedis.getStuId();
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        selectDao.delSelect(id, courseId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/showSelect?id="+id+"");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
