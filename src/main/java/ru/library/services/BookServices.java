package ru.library.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.library.models.Book;
import ru.library.models.User;
import ru.library.services.dao.BookDao;

import java.util.List;

@Service
public class BookServices {

    @Autowired
    BookDao bookDao;
    //Встаривть книгу
    public boolean insertBook(Book book)
    {
        return bookDao.insertBook(book);
    }
    //Получить все книги
    public List<Book> getAll()
    {
        return  bookDao.selectBookList();
    }
    //Удаляем книгу
    public boolean deleteBook(String isbn)
    {
        return bookDao.deleteBook(isbn);
    }
    //Возвращаем книгу
    public boolean returnBook(String isbn)
    {
        return bookDao.changeUsernameBook(isbn ,null);
    }
    //Верем книгу
    public boolean gettingBook(String isbn ,String username )
    {
        return bookDao.changeUsernameBook(isbn ,username );
    }
    //Обновлене данных книги , не затрагивая имя пользывателя
    public boolean updateBookWithoutUsername(Book book)
    {
        return bookDao.updateBook(book.getIsbn() , book.getTitle() , book.getAuthor());
    }
    //Возвращает 5 книг в зависимости от параметров
    public List<Book> getBooks(String sortColumn ,String sortDirection,int curretLines  )
    {
        if(sortDirection.equalsIgnoreCase("revers")) {
            sortDirection="DESC";
        }
        else {
            sortDirection = "";
        }

        return bookDao.selectBookList(sortColumn ,5 ,curretLines, sortDirection );
    }

}
