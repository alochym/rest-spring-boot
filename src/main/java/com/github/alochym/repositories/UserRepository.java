package com.github.alochym.repositories;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.github.alochym.entities.UserModel;

@Repository
public class UserRepository {
    private Logger logger = LoggerFactory.getLogger(UserRepository.class);
    // List vs ArrayList
    // https://www.geeksforgeeks.org/difference-between-list-and-arraylist-in-java/
    private ArrayList<UserModel> users = new ArrayList<>();

    public ArrayList<UserModel> findAll() {
        return this.users;
    }

    public UserModel findById(int id) {
        for (UserModel u : this.users) {
            // check userId is same with id.
            if (u.getId() == id) {
                return u;
            }
        }

        return new UserModel();
    }

    public UserModel findByEmail(String e) {
        for (UserModel u : this.users) {
            // check username is same with email.
            if (u.getUsername() == e) {
                return u;
            }
        }

        return new UserModel();
    }

    public UserModel save(UserModel u) {
        // add a user.
        this.users.add(u);

        return u;
    }

    public UserModel update(UserModel u) {
        // find a user.
        UserModel temp = this.findById(u.getId());
        if (temp.isEmpty()) {
            return temp;
        }

        // find an index of temp user.
        int index = this.users.indexOf(temp);

        logger.info("The User is found at index {} ", index);

        // update user.
        this.users.set(index, u);

        return u;
    }

    public UserModel delete(int id) {
        // find a user.
        UserModel u = this.findById(id);
        if (u.isEmpty()) {
            return u;
        }

        // delete user.
        this.users.remove(u);

        return u;
    }

}
