<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.redis.GetFromRedis" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<!doctype html>
<html lang="en">
<head>
    <title>login</title>
    <link type="text/css" rel="stylesheet" href="layui-v2.6.8/layui/css/layui.css"/>
</head>
<body>

<%
    int id = GetFromRedis.getStuId();
    ArrayList<Map<String, Object>> selectedCourses = (ArrayList)request.getSession().getAttribute("selectedCourses");
%>

<nav>
    <ul class="layui-nav layui-bg-cyan ">
        <li class="layui-nav-item">
            <a href="javascript:;">系统首页</a>
            <dl class="layui-nav-child">
                <dd><a href="http://8.130.17.147:8082/loginService/">返回登陆页面</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item  layui-this">
            <a href="javascript:;">学生首页</a>
            <dl class="layui-nav-child">
                <dd class="layui-this"><a href="/LiRui_ex2_war/showSelect?id=<%=id%>">已选课程</a></dd>
                <dd><a href="/LiRui_ex2_war/courseCanSelect?id=<%=id%>">选课列表</a></dd>
            </dl>
        </li>
    </ul>
</nav>

<div class="layui-container layui-row layui-anim layui-anim-downbit">
    <div class="layui-col-md11 site-content">
        <table class="layui-table" style="margin-left: 150px;">
            <colgroup>
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th><strong>课程id</strong></th>
                <th><strong>课程name</strong></th>
                <th><strong>授课教师</strong></th>
                <th><strong>退课</strong></th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Map<String, Object> selectedCourse : selectedCourses) {
            %>
            <tr>
                <td><%=selectedCourse.get("id")%></td>
                <td><%=selectedCourse.get("name")%></td>
                <td><%=selectedCourse.get("teacherName")%></td>
                <td><a href="/LiRui_ex2_war/dropCourse?id=<%=id%>&courseId=<%=selectedCourse.get("id")%>"><span style="color: red">退选</span></a></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>

<script src="layui-v2.6.8/layui/layui.js"></script>
<script src="actions/action.js"></script>
</body>
</html>
