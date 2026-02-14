package com.akarsh.ems.repository;

import com.akarsh.ems.entity.Role;
import com.akarsh.ems.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType name);
}
