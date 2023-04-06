package com.ivan.klimenko.spring.springboot.springboot_pp_3_1_2.service;



import com.ivan.klimenko.spring.springboot.springboot_pp_3_1_2.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void add(User user);
    void delete(int id);
    void edit(User user);
    User getById(int id);
}
