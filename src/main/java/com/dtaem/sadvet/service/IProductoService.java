package com.dtaem.sadvet.service;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> getAllProductos();

    Producto getProductoById(int id);

    ResponseModelBean addProducto(Producto producto);

    ResponseModelBean updateProducto(Producto producto);

    ResponseModelBean deleteProducto(int id);
}
