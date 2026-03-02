package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.ProductoDTO;

import java.util.List;

public interface ServicioProducto {
    List<ProductoDTO> buscarProductoPorStock(Integer stock);
}
