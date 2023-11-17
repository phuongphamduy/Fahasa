package com.fahasa.reponsitory;

import com.fahasa.model.Role;
import com.fahasa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    User findByRole(Role role);
    
    @Query("select u from User u where u.email = :email")
    public User getUserByUserName(@Param("email") String email);
}
