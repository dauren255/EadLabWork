package com.example.CustomerInfo.service;

import com.example.CustomerInfo.models.Role;
import com.example.CustomerInfo.models.User;
import com.example.CustomerInfo.models.UserD;
import com.example.CustomerInfo.repo.UserRepository;
import com.example.CustomerInfo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
    @Transactional
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
    @Transactional
    public UserD findByIdD(Long id) {
        User user = userRepository.findById(id).get();
        UserD userD = new UserD();
        userD.setId(user.getId());
        userD.setUsername(user.getUsername());
        userD.setPassword(user.getPassword());
        return userD;
    }
    @Transactional
    public User findById(String username) {
        return userRepository.findUserByUsername(username);
    }
    @Transactional
    public void save(User user) {
        user.addRoles(Role.USER);
        userRepository.save(user);
    }
    @Transactional
    public void deleteById(Long id) {
        userRepository.delete(userRepository.findById(id).get());
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(s);
    }
}
