/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Cliente;
import modelo.Poliza;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin1
 */
@Repository
public class ClienteDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void altaCliente(Cliente cliente){
        sessionFactory.getCurrentSession().save(cliente);
    }
    
    public void borrarCliente(Cliente cliente){
        sessionFactory.getCurrentSession().delete(cliente);
    }
    public List<Cliente> getListCliente(){
        return sessionFactory.getCurrentSession().createQuery("from Cliente").list();
    }
    public Cliente getClienteById(long id){
        return (Cliente) sessionFactory.getCurrentSession().get(Cliente.class, id);
    }
    public List<Cliente> getClienteConPolizas(){
        return sessionFactory.getCurrentSession().createQuery("Select distinct cliente from Cliente cliente left join fetch cliente.polizas").list();
    }
    public void modificarCliente(Cliente cliente){
        sessionFactory.getCurrentSession().update(cliente);
    }
   
    
    
    
}
