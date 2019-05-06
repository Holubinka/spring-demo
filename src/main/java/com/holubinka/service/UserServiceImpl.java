package com.holubinka.service;

import com.holubinka.dao.UserDao;
import com.holubinka.model.Role;
import com.holubinka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private MailService mailService;

    @Override
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setToken(getToken());
        user.setStatus(User.UserStatus.PENDING_VERIFICATION);
        User saved = userDao.addUser(user);
        mailService.send(saved);
        return saved;
    }

    @Override
    public User emailVerification(String token) {
        User user = userDao.getByToken(token);
        user.setStatus(User.UserStatus.ACTIVE);
        userDao.updateUser(user);
        return user;
    }

    private String getToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getByUsername(username);
        List<SimpleGrantedAuthority> roles = user.getRoles().stream()
                .map(Role::getRoleName)
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);

    }
}
