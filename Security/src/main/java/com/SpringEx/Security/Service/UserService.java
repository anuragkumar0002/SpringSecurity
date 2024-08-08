package com.SpringEx.Security.Service;

import com.SpringEx.Security.Entity.User;
import com.SpringEx.Security.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceImpl, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Integer saveUser(User user) {
        String encPwd = passwordEncoder.encode(user.getUserPwd());
        user.setUserPwd(encPwd);
        userRepository.save(user);
        return user.getUserId();
    }

    public Optional<User> getOneuser(Integer id) {
       return userRepository.findById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> opt =  userRepository.findByUserEmail(username);
        if (opt.isEmpty()) {
            throw new UsernameNotFoundException(username + "not exist");
        }
        User user =opt.get();
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for(String role : user.getUserRoles()) {
//            authorities.add(new SimpleGrantedAuthority(role));
//        }
        List<GrantedAuthority> authorities = user.getUserRoles().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
        System.out.println(authorities);
        return new org.springframework.security.core.userdetails.User(username, user.getUserPwd(), authorities);
    }
}
