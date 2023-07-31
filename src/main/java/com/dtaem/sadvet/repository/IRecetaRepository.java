package com.dtaem.sadvet.repository;

import com.dtaem.sadvet.model.entity.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecetaRepository extends JpaRepository<Receta,Integer> {

    @Query(value = "SELECT SUM(subtotal) FROM RECETA", nativeQuery = true)
    Float getSumBySubtotal();
}
