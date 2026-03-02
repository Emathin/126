package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioProducto;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ControladorProductoTest {

    @Mock
    private ServicioProducto servicioProducto;

    @InjectMocks
    private ControladorProducto controladorProducto;

    @Test
    public void quePuedaBuscarseProductoPorStockViaPathVariable(){
        ProductoDTO productoDTO=new ProductoDTO(null,"pelota",15000.00,20);
        List<ProductoDTO> productos=new ArrayList<>();
        productos.add(productoDTO);

        when(servicioProducto.buscarProductoPorStock(20)).thenReturn(productos);

       ModelAndView mav= controladorProducto.buscarProductoPorStock(20);

        MatcherAssert.assertThat(mav.getViewName(),equalTo("ProductosObtenidosPorStock"));
        MatcherAssert.assertThat(mav.getModel().get("productosObtenidos"), equalTo(productos));
        verify(servicioProducto,times(1)).buscarProductoPorStock(20);
    }



}
