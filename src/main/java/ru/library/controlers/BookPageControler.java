package ru.library.controlers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.library.models.Book;
import ru.library.models.User;
import ru.library.services.BookServices;

@Controller
public class BookPageControler {
    @Autowired
    BookServices bookServices;
    //Удаление книги
    @ResponseBody
    @RequestMapping(value = "/dellBook", method = RequestMethod.POST)
    public String delleteBook(@RequestParam(value = "isbn") String isbn) {
        if(bookServices.deleteBook(isbn)) {
            return "successfull";
        }
        else {
            return "error";
        }

    }
    //Если пользыватель добавляет книгу
    @ResponseBody
    @RequestMapping(value = "/sendBook", method = RequestMethod.POST)
    public String insertBook( Book data) {
        if(bookServices.insertBook(data)) {
            return "successfull";
        }
        else {
            return "error";
        }
    }
    //Если пользыватель нажал  вернуть книгу
    @ResponseBody
    @RequestMapping(value = "/returnBook", method = RequestMethod.POST)
    public String returnBook(Book data) {

        if(bookServices.returnBook(data.getIsbn())) {
            return "successfull";
        }
        else {
            return "error";
        }
    }
    //Если пользыватель нажал взять книгу
    @ResponseBody
    @RequestMapping(value = "/gettingBook", method = RequestMethod.POST)
    public String gettingBook(String isbn ) {
        User authenUser =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(bookServices.gettingBook(isbn,authenUser.getUsername())) {
            return "successfull";
        }
        else {
            return "error";
        }
    }
    //Если пользыватель хочет изменить данные книги
    @ResponseBody
    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public String updateBook(Book book) {
        if(bookServices.updateBookWithoutUsername(book)) {
            return "successfull";
        }
        else {
            return "error";
        }
    }
}
