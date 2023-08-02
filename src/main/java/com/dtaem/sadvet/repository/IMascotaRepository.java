package com.dtaem.sadvet.repository;

import com.dtaem.sadvet.model.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMascotaRepository extends JpaRepository<Mascota, Integer> {

    List<Mascota> findAllByIdCliente(int idCliente);
}
