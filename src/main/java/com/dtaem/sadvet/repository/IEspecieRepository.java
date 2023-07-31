package com.dtaem.sadvet.repository;

import com.dtaem.sadvet.model.entity.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEspecieRepository extends JpaRepository<Especie,Integer> {
}
