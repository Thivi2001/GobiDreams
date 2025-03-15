package Thivi.Project.Gobi.Dreams.repository;

import Thivi.Project.Gobi.Dreams.entity.User;
import Thivi.Project.Gobi.Dreams.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // Find user by email
    List<User> findByRole(Role role); // Find users by role
}
