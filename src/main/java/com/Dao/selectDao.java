package com.Dao;

import com.entity.SelectCourse;
import com.entity.Course;
import com.entity.User;
import com.util.Mysqlcoll;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author 林子翔
 * @since 2022 05 2022/5/13
 */
public class selectDao {
    static JdbcTemplate jdbcTemplate = new Mysqlcoll().getTmp();
    public static List<Map<String, Object>> findCourseId(int stu_id){
        String sql = "select course_id from selectCourse where stu_id="+stu_id+"";
        try {
            List<Map<String, Object>> course_id = jdbcTemplate.queryForList(sql);
            System.out.println(course_id);
            return course_id;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void delSelect(int stu_id, int course_id){
        String sql = "delete from selectCourse where stu_id="+stu_id+" and course_id="+course_id+"";
        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return;
        }
    }
    public static void newSelect(int stu_id, int course_id){
        String sql = "insert into selectCourse values ("+stu_id+", "+course_id+")";
        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return;
        }
    }
}
