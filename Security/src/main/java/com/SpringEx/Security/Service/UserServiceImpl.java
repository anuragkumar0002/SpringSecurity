package com.SpringEx.Security.Service;

import com.SpringEx.Security.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserServiceImpl {

    Integer saveUser(User user);
    Optional<User> getOneuser(Integer id);
}
