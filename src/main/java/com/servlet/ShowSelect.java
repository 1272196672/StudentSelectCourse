package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.Dao.selectDao;
import com.Dao.courseDao;
import com.redis.GetFromRedis;

/**
 * @author 林子翔
 * @since 2022 05 2022/5/13
 */
@WebServlet("/showSelect")
public class ShowSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = GetFromRedis.getStuId();
        System.out.println(id);
        List<Map<String, Object>> courseIdList = selectDao.findCourseId(id);
        System.out.println(courseIdList);
        ArrayList<Map<String, Object>> selectedCourses = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : courseIdList) {
            selectedCourses.add(courseDao.findCourse((Integer)stringObjectMap.get("course_id")));
        }
        System.out.println(selectedCourses);
        req.getSession().setAttribute("selectedCourses", selectedCourses);
        resp.sendRedirect("/LiRui_ex2_war/studentIndex.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
