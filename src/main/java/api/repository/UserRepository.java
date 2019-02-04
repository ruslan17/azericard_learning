package api.repository;

import api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    List<User> findAllByBirthDateAndAndName(LocalDate birthDate, String name);

    @Query("SELECT u FROM User u WHERE u.name = :name")
    List<User> findAllByName(@Param("name") String name);

    @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
    List<User> findAllByEmailCustom(String email);

}