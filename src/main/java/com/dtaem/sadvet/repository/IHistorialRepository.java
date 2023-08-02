package com.dtaem.sadvet.repository;

import com.dtaem.sadvet.model.entity.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHistorialRepository extends JpaRepository<Historial, Integer> {

    @Query(
            value = "SELECT * FROM HISTORIAL h WHERE h.ID_MASCOTA = :id",
            nativeQuery = true)
    List<Historial> findByIdMascota(@Param("id")int id);
}
