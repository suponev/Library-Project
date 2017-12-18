package ru.library.services.dao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.library.models.User;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate ;

    public List<User> selectUserList() {
        String query = "SELECT * FROM user ORDER BY username ";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper(User.class));
    }
    public User selectUserById(String username) {
        String query = "select * from user where username=?";
        return (User)jdbcTemplate.queryForObject(query, new Object[]{username}, new BeanPropertyRowMapper(User.class));
    }
    public boolean insertUser(String username , String password) {
        String sql = "INSERT INTO user (username,password) VALUES (?,?);";

        try {
            jdbcTemplate.update(sql,username,password);
        }
        catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean  updateUser(String oldUsername ,String newUsername ,String password ){

        String sql = "UPDATE user SET username = ? ,password =? WHERE username = ?";

        try
        {
            jdbcTemplate.update(sql,newUsername,password,oldUsername);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            return false;
        }

        return  true;

    }
    public boolean  updatePassword(String username ,String password ){

        String sql = "UPDATE user SET password =? WHERE username = ?";

        try
        {
            jdbcTemplate.update(sql,password,username);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            return false;
        }

        return  true;

    }
    public boolean  deleteUser(String username ){

        String sql = "DELETE FROM user  WHERE username=?";

        try
        {
            jdbcTemplate.update(sql,username);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            return false;
        }

        return  true;
    }

}
