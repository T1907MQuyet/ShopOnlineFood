package project_techwiz2.springboot_techwiz2.service;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username,String password);
}
