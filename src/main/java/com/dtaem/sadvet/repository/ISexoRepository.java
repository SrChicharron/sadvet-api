package com.dtaem.sadvet.repository;

import com.dtaem.sadvet.model.entity.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISexoRepository extends JpaRepository<Sexo, Integer> {
}
