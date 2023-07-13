package com.dtaem.sadvet.service;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    List<Cliente> getAllClientes();

    Optional<Cliente> findClienteById(int id);

    ResponseModelBean addCliente(Cliente cliente);

    ResponseModelBean updateCliente(Cliente cliente);

    ResponseModelBean deleteCliente(int id);
}
