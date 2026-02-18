package com.api.repository;

import com.api.model.Observacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryObservacao extends JpaRepository<Observacao, Long> {
    List<Observacao> findByIdCachorro(Long id);
}
