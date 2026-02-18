package com.api.repository;

import com.api.model.Notas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryNotas extends JpaRepository<Notas, Long> {
    List<Notas> findByIdCachorro(Long id);

    List<Notas> findByIdCachorroAndIdProfessor(Long idCachorro, Long idProfessor);

    Notas findByIdCachorroAndIdProfessorAndNota(Long idCachorro, Long idProfessor, Integer nota);

    @Query(
            "SELECT n.nota " +
            "FROM Notas n " +
            "WHERE MONTH(n.dataPublicacao) <= 7 " +
            "AND n.idCachorro = :idCachorro " +
            "AND n.idProfessor = :idProfessor"
    )
    Integer findNotaByIdCachorroAndIdProfessorAndMonthLessThan(
            @Param("idCachorro") Long idCachorro,
            @Param("idProfessor") Long idProfessor
    );

    @Query(
            "SELECT n.nota " +
                    "FROM Notas n " +
                    "WHERE MONTH(n.dataPublicacao) > 7 " +
                    "AND n.idCachorro = :idCachorro " +
                    "AND n.idProfessor = :idProfessor"
    )
    Integer findNotaByIdCachorroAndIdProfessorAndMonthGreaterThan(
            @Param("idCachorro") Long idCachorro,
            @Param("idProfessor") Long idProfessor
    );
}
