package ru.library.controlers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.library.models.Book;
import ru.library.models.User;
import ru.library.services.BookServices;
import ru.library.services.UserService;

import java.util.List;
@Controller
public class UserPageControler {
    @Autowired
    UserService userService;
    @Autowired
    BookServices bookServices;


    //Подгрузка данных по нажатию кнопки "Показать еще"
    @ResponseBody
    @RequestMapping(value = "/loadData" , method = RequestMethod.GET)
    public String loadMoreBook(String sortColumn , String sortDirection ,int currentNumLine) {

        List<Book> list = bookServices.getBooks(sortColumn ,sortDirection ,currentNumLine);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;

    }
    //Если пользыватель хочет добавить нового пользывателя
    @ResponseBody
    @RequestMapping("/sendUser")
    public String addNewUser(User user) {
        boolean result = userService.insertUser(user.getUsername() , user.getPassword());
        if(result)
        {
            return "successfull";
        }
        else
        {
            return "error";
        }
    }
    //Если пользыватель хочет обновить данные пользывателя
    @ResponseBody
    @RequestMapping( value = "/updateUser" )
    public String updateUserData(String oldUsername ,String newUsername , String newPassword) {
        if(userService.updateUser(oldUsername,newUsername,newPassword))
        {
            return "successfull";
        }
        else
        {
            return "error";
        }
    }
    //Если пользыватель хочет удалить пользывателя
    @ResponseBody
    @RequestMapping("/deleteUser")
    public String deleteUser(String username ) {
        if(userService.deleteUser(username))
        {
            return "successfull";
        }
        else
        {
            return "error";
        }
    }
    //Возвращает в переменную JS имя текушего пользывателя
    @ResponseBody
    @RequestMapping("/getAuthorizeUser")
    public String getAuthorizeUser() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }


}
