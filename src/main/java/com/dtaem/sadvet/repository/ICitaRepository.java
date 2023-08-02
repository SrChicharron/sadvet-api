package com.dtaem.sadvet.repository;

import com.dtaem.sadvet.model.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICitaRepository extends JpaRepository<Cita, Integer> {
    List<Cita> getAllByFechaGreaterThanEqualOrderByFecha(String fecha);
}
