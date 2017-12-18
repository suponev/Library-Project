package ru.library.services.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.library.models.Book;
import ru.library.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.RowId;
import java.sql.SQLException;
import java.util.List;
import java.util.zip.DataFormatException;

@Repository
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate ;

    //Получам все книги
    public List<Book> selectBookList(){
        List<Book> bookList ;
        String sql = "SELECT * FROM BOOK";
        bookList =  jdbcTemplate.query(sql, new BeanPropertyRowMapper(Book.class));
        return bookList;
    }
    //Получаем книги :отсортированные (в прямом или обратном порядке), и в определенном диапазоне
    public List<Book> selectBookList(final String sortColumn , int lim , int ofs , String direction ){

        List<Book> bookList ;
        Object[] param =  new Object[]{lim , ofs};
        String sql = "SELECT * FROM BOOK  ORDER BY "+sortColumn+" "+direction+" LIMIT ? OFFSET ?";
        bookList =  jdbcTemplate.query(sql,param,new BeanPropertyRowMapper(Book.class));
        return bookList;
    }
    //Добавляем книгу
    public boolean  insertBook(Book book){

        String sql = "INSERT INTO book (isbn, title,author,username) VALUES (?,?,?,null);";
        Object[] param =  new Object[]{book.getIsbn() , book.getTitle() , book.getAuthor() };

        try
        {
            jdbcTemplate.update(sql,param);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            return false;
        }

        return  true;

    }
    //Удаляем книгу
    public boolean  deleteBook(String isbn){

        String sql = "DELETE FROM book  WHERE isbn=?";

        try
        {
            jdbcTemplate.update(sql,isbn);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            return false;
        }

        return  true;

    }
    public boolean  changeUsernameBook(String isbn ,String username  ){

        String sql = "UPDATE book SET username = ? WHERE isbn = ? ";

        try
        {
            jdbcTemplate.update(sql,username,isbn );
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            return false;
        }

        return  true;

    }
    //Обновляем данные о книге не затрагивая метку
    public boolean  updateBook(String isbn ,String title , String author ){

        String sql = "UPDATE book SET title = ? ,author =? WHERE isbn = ?";

        try
        {
            jdbcTemplate.update(sql,title,author,isbn);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            return false;
        }

        return  true;

    }
    //Меняем  метку  имени пользывателя с одной на другую
    public boolean updateUsername(String oldUsername , String newUsername)
    {
        String sql = "UPDATE book SET username = ?  WHERE username = ?";
        try
        {
            jdbcTemplate.update(sql,newUsername,oldUsername);
        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            return false;
        }

        return  true;

    }
}
