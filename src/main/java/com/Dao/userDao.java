package com.Dao;

import com.entity.User;
import com.util.Mysqlcoll;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.List;
/**
 * @author 林子翔
 * @since 2022 05 2022/5/13
 */
public class userDao {
    static JdbcTemplate jdbcTemplate = new Mysqlcoll().getTmp();

    public static int findUserId(String account, String pwd){
        String sql = "select id from user where account="+account+" and pwd="+pwd+"";
        try {
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class));
            return user.getId();
        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
