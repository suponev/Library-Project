package ru.library.controlers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.library.models.Book;
import ru.library.models.User;
import ru.library.services.BookServices;
import ru.library.services.UserService;

import java.util.List;

@Controller
public class MainControler {
    @Autowired
    BookServices bookServices;
    @Autowired
    UserService userService;
    //Основная страница со списком книг
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcome()  {

        ModelAndView model = new ModelAndView("bookListPage");
        ObjectMapper om = new ObjectMapper();
        //Сортируем по автору в прямом порядке, берем 5 начиная с нуля
        List<Book> list = bookServices.getBooks("author" ,"direct" ,0);
        model.addObject("books",list );
        return model;
    }
    //Сраница со списком пользывателя
    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public ModelAndView userList() {

        ModelAndView model = new ModelAndView("userListPage");
        ObjectMapper om = new ObjectMapper();
        List<User> list = userService.getAllUsers();
        model.addObject("users", list);
        return model;
    }
    //логин
    @RequestMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout, Model model) {
        model.addAttribute("error", error != null);
        return "login";
    }
}
