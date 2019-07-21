package com.xx.dao;

import com.xx.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    User findByPhone(String phone);

    User findByToken(String token);
}
