package com.tiremanagement.registration.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tiremanagement.registration.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByEmail(String email);

    public User findUserByUsername(String username);
    
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE User c SET c.username = :username WHERE c.id = :id")
    int updateUsername(@Param("id") Long id, @Param("username") String username);
}
