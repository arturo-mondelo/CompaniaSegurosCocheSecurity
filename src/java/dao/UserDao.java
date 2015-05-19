/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.User;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin1
 */
@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void altaUser(User user){
        sessionFactory.getCurrentSession().save(user);
    }
    
    public void bajaUser(User user){
        sessionFactory.getCurrentSession().delete(user);
    }
    public User getUser(String login){
        List<User> lista;
        User u = null;
        String hql="FROM User u WHERE u.userName='"+login+"'";
        lista = sessionFactory.getCurrentSession().createQuery(hql).list();
        if(lista != null && lista.size()>0){
            u=lista.get(0);
            
        }
        return u;
    }
    
}
