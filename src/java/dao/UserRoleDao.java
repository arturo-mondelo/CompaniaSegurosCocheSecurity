/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin1
 */
@Repository
public class UserRoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Role getRole(long id) {
        Role uRole = (Role) sessionFactory.getCurrentSession().get(Role.class, id);
        return uRole;
    }
    
    public void altaRole(Role uRole){
        sessionFactory.getCurrentSession().save(uRole);
    }
}
