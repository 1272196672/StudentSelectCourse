package com.servlet; /**
 * @author 林子翔
 * @since 2022 05 2022/5/19
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

import com.Dao.selectDao;
import com.Dao.courseDao;
import com.redis.GetFromRedis;

@WebServlet("/courseCanSelect")
public class CourseCanSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = GetFromRedis.getStuId();

        HashSet<Integer> courseId_canBeSelect = new HashSet<>();
//        所有课程
        List<Map<String, Object>> allCourses = courseDao.findAllCourse();
        for (Map<String, Object> course : allCourses) {
            courseId_canBeSelect.add((Integer) course.get("id"));
        }
//        已选课程
        List<Map<String, Object>> courseIds = selectDao.findCourseId(id);
        for (Map<String, Object> courseId : courseIds) {
            courseId_canBeSelect.remove(courseId.get("course_id"));
        }

        List<Map<String, Object>> courseCanBeSelected = new ArrayList<>();
        for (Integer courseId : courseId_canBeSelect) {
            courseCanBeSelected.add(courseDao.findCourse(courseId));
        }

        System.out.println(courseCanBeSelected);
        request.getSession().setAttribute("courseCanBeSelected", courseCanBeSelected);
        response.sendRedirect("/LiRui_ex2_war/selectCourse.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
