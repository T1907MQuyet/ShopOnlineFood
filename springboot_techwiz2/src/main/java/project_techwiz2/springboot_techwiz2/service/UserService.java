package project_techwiz2.springboot_techwiz2.service;

import project_techwiz2.springboot_techwiz2.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String email);
    Boolean saveUser2(User user);
    List<User> getAllUser();
}
