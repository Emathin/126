package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ServicioProductoImpl implements ServicioProducto {

    private RepositorioProducto repositorioProducto;

    @Autowired
    public ServicioProductoImpl(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    @Override
    public List<ProductoDTO> buscarProductoPorStock(Integer stock) {
        List<ProductoDTO> productosDTO=new ArrayList<>();

        List<Producto> productosObtenidos=new ArrayList<>();
        productosObtenidos=repositorioProducto.obtenerProductosPorStock(stock);
        if(productosObtenidos!=null){
            for(Producto p:productosObtenidos){
                ProductoDTO producto=new ProductoDTO();
                producto.setId(p.getId());
                producto.setNombre(p.getNombre());
                producto.setPrecio(p.getPrecio());
                producto.setStock(p.getStock());
                productosDTO.add(producto);
            }

        }
        return productosDTO;
    }
}
