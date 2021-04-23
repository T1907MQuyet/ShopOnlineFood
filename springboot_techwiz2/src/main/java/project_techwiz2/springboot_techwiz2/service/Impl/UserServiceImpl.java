package project_techwiz2.springboot_techwiz2.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import project_techwiz2.springboot_techwiz2.model.User;
import project_techwiz2.springboot_techwiz2.repository.UserRepository;
import project_techwiz2.springboot_techwiz2.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public User saveUser(User user) {
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return user;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findByUsername(String email) {
        try{
            User user = userRepository.findByEmail(email);
            return user;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean saveUser2(User user) {
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        try{
            List<User> listUser = userRepository.findAll();
            return listUser;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
