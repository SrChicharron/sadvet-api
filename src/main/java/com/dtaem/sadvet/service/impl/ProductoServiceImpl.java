package com.dtaem.sadvet.service.impl;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Producto;
import com.dtaem.sadvet.repository.IProductoRepository;
import com.dtaem.sadvet.service.IProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    private static Logger log = LoggerFactory.getLogger(ProductoServiceImpl.class);

    @Autowired
    private IProductoRepository productoRepository;
    @Override
    public List<Producto> getAllProductos() {
        List<Producto>productos= new ArrayList<>();
        productoRepository.findAll().forEach(productos::add);
        return productos;
    }

    @Override
    public Producto getProductoById(int id) {
        Producto producto= new Producto();
        producto=productoRepository.findById(id).orElse(new Producto());
        return producto;
    }

    @Override
    public ResponseModelBean addProducto(Producto producto) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            Producto savedProducto = productoRepository.save(producto);
            response.setReturnCode(0);
        }catch(Exception e){
            log.info(e.getMessage());
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public ResponseModelBean updateProducto(Producto producto) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            Producto savedProducto = productoRepository.save(producto);
            response.setReturnCode(0);
        }catch(Exception e){
            log.info(e.getMessage());
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public ResponseModelBean deleteProducto(int id) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            productoRepository.deleteById(id);
            response.setReturnCode(0);
        }catch(Exception e){
            log.info(e.getMessage());
            response.setReturnCode(1);
        }
        return response;
    }
}
