package com.detrox.ecom.serviceImpl;

import com.detrox.ecom.model.User;
import com.detrox.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final List<User> userList = new ArrayList<>();
    private Long idx = 1L;

    @Override
    public List<User> fetchAllUsers(){
        return userList;
    }

    @Override
    public List<User> addUser(User user){
        user.setId(idx++);
        userList.add(user);
        return userList;
    }

    @Override
    public Optional<User> fetchUserById(Long id) {
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();

    }

    @Override
    public boolean updateUserById(Long id, User updatedUser) {
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .map(existingUser->{
                    existingUser.setFirstName(updatedUser.getFirstName());
                    existingUser.setLastName(updatedUser.getLastName());
                    return true;
                }).orElse(false);
    }


}
