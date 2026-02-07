package com.api.repository;

import com.api.model.Cachorro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCachorro extends JpaRepository<Cachorro, Long> {
}
