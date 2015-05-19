/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Poliza;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin1
 */
@Repository
public class PolizaDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void altaPoliza(Poliza poliza){
        sessionFactory.getCurrentSession().save(poliza);
    }
    
    public void borrarPoliza(Poliza poliza){
        sessionFactory.getCurrentSession().delete(poliza);
    }
    public List<Poliza> getListPolizas(){
        return sessionFactory.getCurrentSession().createQuery("from Poliza").list();
    }
    public List<Poliza> getListPolizasCliente(){
        return sessionFactory.getCurrentSession().createQuery("Select distinct poliza from Poliza poliza left join fetch poliza.cliente left join fetch poliza.vehiculo").list();
    }
    public Poliza getPolizaById(long id){
        return (Poliza) sessionFactory.getCurrentSession().get(Poliza.class, id);
    }
    public void modificarPoliza(Poliza poliza){
        sessionFactory.getCurrentSession().update(poliza);
    }
    
}
