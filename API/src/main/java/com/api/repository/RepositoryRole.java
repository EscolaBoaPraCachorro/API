package com.api.repository;

import com.api.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryRole extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
