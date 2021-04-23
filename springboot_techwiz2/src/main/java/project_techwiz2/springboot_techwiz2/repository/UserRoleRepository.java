package project_techwiz2.springboot_techwiz2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project_techwiz2.springboot_techwiz2.model.User_roles;

public interface UserRoleRepository extends JpaRepository<User_roles, Integer> {
}
