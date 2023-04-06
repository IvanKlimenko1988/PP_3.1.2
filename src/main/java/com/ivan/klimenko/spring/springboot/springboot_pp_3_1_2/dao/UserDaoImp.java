package com.ivan.klimenko.spring.springboot.springboot_pp_3_1_2.dao;

import com.ivan.klimenko.spring.springboot.springboot_pp_3_1_2.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class UserDaoImp implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void delete(int id) {
        User user = getById(id);
        if (null == user) {
            throw new NullPointerException("User not found");
        }
        entityManager.remove(user);
        entityManager.flush();
        System.out.println("User delleted");
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }
}
