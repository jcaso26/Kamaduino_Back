package com.kamaduino.repository;

import com.kamaduino.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM USER U WHERE U.USER_NAME = :userName", nativeQuery = true)
    User getUserByUserName(@Param("userName") String userName);

    //    User findByEmailAddress(String emailAddress);
}
