package com.dtaem.sadvet.service.impl;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Cliente;
import com.dtaem.sadvet.repository.IClienteRepository;
import com.dtaem.sadvet.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;
    @Override
    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = new ArrayList<>();
        clienteRepository.findAll().forEach(clientes::add);
        return clientes;
    }

    @Override
    public Optional<Cliente> findClienteById(int id) {
        Optional<Cliente> cliente = Optional.of(new Cliente());
        Long lId= (long) id;
        cliente=clienteRepository.findById(lId);
        return cliente;
    }

    @Override
    public ResponseModelBean addCliente(Cliente cliente) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            Cliente savedCliente = clienteRepository.save(cliente);
            response.setReturnCode(0);
        }catch(Exception e){
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public ResponseModelBean updateCliente(Cliente cliente) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            Cliente savedCliente = clienteRepository.save(cliente);
            response.setReturnCode(0);
        }catch(Exception e){
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public ResponseModelBean deleteCliente(int id) {
        ResponseModelBean responseUpdate = new ResponseModelBean();
        try{
            Long lId= (long) id;
            clienteRepository.deleteById(lId);
            responseUpdate.setReturnCode(0);
        }catch(Exception e){
            System.out.println(e);
            responseUpdate.setReturnCode(1);
        }
        return responseUpdate;
    }
}
