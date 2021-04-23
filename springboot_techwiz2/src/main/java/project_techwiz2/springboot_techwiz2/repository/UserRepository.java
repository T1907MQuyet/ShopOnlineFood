package project_techwiz2.springboot_techwiz2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project_techwiz2.springboot_techwiz2.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail (String username);
}
