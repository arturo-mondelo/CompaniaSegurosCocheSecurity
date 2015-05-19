/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Vehiculo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin1
 */
@Repository
public class VehiculoDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
     public void altaVehiculo(Vehiculo vehiculo){
        sessionFactory.getCurrentSession().save(vehiculo);
    }
    
    public void borrarVehiculo(Vehiculo vehiculo){
        sessionFactory.getCurrentSession().delete(vehiculo);
    }
    public List<Vehiculo> getListVehiculos(){
        return sessionFactory.getCurrentSession().createQuery("from Vehiculo").list();
    }
    public Vehiculo getVehiculoById(long id){
        return (Vehiculo) sessionFactory.getCurrentSession().get(Vehiculo.class, id);
    }
    public void modificarVehiculo(Vehiculo vehiculo){
        sessionFactory.getCurrentSession().update(vehiculo);
    }
    
    
}
