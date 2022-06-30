package com.test;

import com.entity.User;
import com.util.Mysqlcoll;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author 林子翔
 * @since 2022 05 2022/5/13
 */
public class test {
    public static void main(String[] args) {

        String sql = "select * from user";
        JdbcTemplate tmp = new Mysqlcoll().getTmp();
        List<User> userList = tmp.query(sql, new BeanPropertyRowMapper<>(User.class));

        for (User u : userList){
            System.out.println(u);
        }

    }
}
