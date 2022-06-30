package com.Dao;

import com.entity.Course;
import com.entity.User;
import com.util.Mysqlcoll;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author 林子翔
 * @since 2022 05 2022/5/13
 */
public class courseDao {
    static JdbcTemplate jdbcTemplate = new Mysqlcoll().getTmp();

    public static List<Map<String, Object>> findAllCourse(){
        String sql = "select * from course";
        try {
            List<Map<String, Object>> course = jdbcTemplate.queryForList(sql);
            System.out.println(course);
            return course;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, Object> findCourse(int id){
        String sql = "select * from course where id = "+id+"";
        try {
            Map<String, Object> course = jdbcTemplate.queryForMap(sql);
            System.out.println(course);
            return course;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
