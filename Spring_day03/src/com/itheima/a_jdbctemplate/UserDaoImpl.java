package com.itheima.a_jdbctemplate;

import com.itheima.bean.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tcj on 2019/6/11.
 */

//使用JDBC模板对象实现增删改查
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {


    @Override
    public void save(User u) {
        String sql = "insert into t_user value(null,?)";
        super.getJdbcTemplate().update(sql, u.getName());
    }

    @Override
    public void dalete(Integer id) {
        String sql = "delete from t_user where id=?";
        super.getJdbcTemplate().update(sql, id);
    }

    @Override
    public void update(User u) {
        String sql = "update t_user set name=? where id=?";
        super.getJdbcTemplate().update(sql, u.getName(), u.getId());
    }

    @Override
    public User getById(Integer id) {
        String sql = "select *  from t_user where id=?";
        return super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setName(resultSet.getString("name"));
                return u;
            }
        }, id);
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from t_user";
        Integer count = super.getJdbcTemplate().queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from t_user";
        List<User> list = super.getJdbcTemplate().query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setName(resultSet.getString("name"));
                return u;
            }
        });
        return list;
    }
}
