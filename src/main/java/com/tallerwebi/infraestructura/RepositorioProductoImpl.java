package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Producto;
import com.tallerwebi.dominio.RepositorioProducto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioProductoImpl implements RepositorioProducto {

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Producto> obtenerProductosPorStock(Integer stock) {
        Session session= sessionFactory.getCurrentSession();
        List<Producto> list=session.createQuery("from Producto where stock=:stock").setParameter("stock", stock).list();
        return list;
    }

    @Override
    public List<Producto> obtenerProductosPorCriterio(String nombre) {
        Session session= sessionFactory.getCurrentSession();
        List<Producto> list=session.createQuery("from Producto where nombre=:nombre").setParameter("nombre", nombre).list();
        return list;
    }
}
