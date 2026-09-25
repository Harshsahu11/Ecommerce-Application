package com.detrox.ecom.service;

import com.detrox.ecom.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> fetchAllUsers();

    List<User> addUser(User user);

    Optional<User> fetchUserById(Long id);

    boolean updateUserById(Long id,User updatedUser);
}
