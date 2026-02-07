package com.api.repository;

import com.api.model.Observacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryObservacao extends JpaRepository<Observacao, Long> {
}
