package ru.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.library.dao.UserDao;
import ru.library.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Transactional
    public User getByUsername(String name) throws UsernameNotFoundException {
        return User.fromEntity(userDao.selectUserById(name).get());
    }

    @Transactional
    public List<User> all() {
        return userDao.all().stream()
                .map(User::fromEntity)
                .collect(Collectors.toList());
    }


}
