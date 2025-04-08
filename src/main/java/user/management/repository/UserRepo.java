package user.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import user.management.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    User findByPhone(String phone);
    List<User> findAllBy();
    // query username containing keyword
    @Query("SELECT u FROM User u WHERE u.username LIKE %:keyword%  " +
            "OR u.email LIKE %:keyword% " +
            "OR u.phone LIKE %:keyword% " +
            "OR STR(u.role) LIKE %:keyword% ")
    List<User> searchByUsernameOrEmail(@Param("keyword") String keyword);
}
