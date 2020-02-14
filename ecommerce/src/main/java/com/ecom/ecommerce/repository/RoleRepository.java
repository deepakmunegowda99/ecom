package com.ecom.ecommerce.repository;

import com.ecom.ecommerce.model.Role;
import com.ecom.ecommerce.model.RoleName;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(RoleName role);

}