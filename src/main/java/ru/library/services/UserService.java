package ru.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.library.models.User;
import ru.library.services.dao.BookDao;
import ru.library.services.dao.UserDao;

import java.util.List;

@Service
public class UserService  implements UserDetailsService {
    @Autowired
    UserDao userDao ;
    @Autowired
    BookDao bookDao;
    //Список всех пользывателей
    public List<User> getAllUsers()
    {
        return  userDao.selectUserList();
    }
    //Поиск пользывателя по username
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.selectUserById(s);
    }
    //Обновление имени и пароля
    public boolean updateUser(String oldUsername , String newUsername ,String newPassword)
    {
        //Если имя тоже , обновляем только пароль
        if(oldUsername.equals(newUsername))
        {
            userDao.updatePassword(oldUsername,newPassword);
        }
        else
        {
            if(userDao.updateUser(oldUsername,newUsername,newPassword))
            {
                //Если имя обновилось , обновляем метку на книге
                if(bookDao.updateUsername(oldUsername,newUsername)) {
                    return true;
                }
                else {
                    //Если не удалось обновить метку , откатываеми измнения
                    userDao.updateUser(newUsername ,oldUsername,newPassword);
                }
            }
        }
        return false;

    }
    //Добавление пользывателя
    public boolean insertUser(String username , String password)
    {
        return userDao.insertUser(username,password);
    }

    public boolean deleteUser(String username)
    {
        User authenUser =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(username.equals(authenUser.getUsername()))
        {
            //Не возможно удалить самого себя, один юзер всегда останется в системе
            return false;
        }
        if(userDao.deleteUser(username))
        {
            //Удаляем метку с книги
            if(bookDao.updateUsername(username,null))
            {
                return true;
            }

        }
        return false;
    }
}
