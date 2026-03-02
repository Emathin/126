package com.tallerwebi.dominio;

import java.util.List;

public interface RepositorioProducto {
    List<Producto> obtenerProductosPorStock(Integer stock);
}
