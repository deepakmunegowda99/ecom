package com.ecom.ecommerce.repository;

import com.ecom.ecommerce.model.Session;
import com.ecom.ecommerce.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

    Boolean existsByUserAndLoggedin(User user, Integer loggedin);

    Boolean existsByUserAndLoggedinAndLoggedintime(User user, Integer loggedin, Long loggedintime);

    Session findByUserAndLoggedin(User user, Integer loggedin);

}