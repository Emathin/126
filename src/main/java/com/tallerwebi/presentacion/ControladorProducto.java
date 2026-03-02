package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ControladorProducto {

    private ServicioProducto servicioProducto;

    @Autowired
    public ControladorProducto(ServicioProducto servicioProducto) {
        this.servicioProducto = servicioProducto;
    }


    @GetMapping("/stock/mayor-a/{valor}")
    public ModelAndView buscarProductoPorStock(@PathVariable("valor") Integer valor){
        ModelAndView mav= new ModelAndView("ProductosObtenidosPorStock");
        List<ProductoDTO> productosDTOObtenidos;
        productosDTOObtenidos=servicioProducto.buscarProductoPorStock(valor);
        mav.addObject("productosObtenidos",productosDTOObtenidos);
        return mav;
    }


    @GetMapping("/funcionalidadA")
    public ModelAndView funcionalidadA(){
       ModelAndView mav= new ModelAndView("funcionalidadA");
       return mav;
    }

    public ServicioProducto getServicioProducto() {
        return servicioProducto;
    }

    public void setServicioProducto(ServicioProducto servicioProducto) {
        this.servicioProducto = servicioProducto;
    }
}
