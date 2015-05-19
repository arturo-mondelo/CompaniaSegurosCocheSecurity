/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import modelo.Role;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin1
 */
@Service
@Transactional
public class MiUserDetailsService implements UserDetailsService{
    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        modelo.User miUsuario = userDao.getUser(login);
        
        boolean enabled = miUsuario.isEnabled();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List <GrantedAuthority> lista = obtenerUserAuthority(miUsuario.getRoles());
        
        User user = new User(miUsuario.getUserName(), miUsuario.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, lista);
        return user;
        
    }
    private List<GrantedAuthority> obtenerUserAuthority(Set<Role> roles){
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(Role uR:roles){
            authorities.add(new SimpleGrantedAuthority(uR.getRol()));
        }
        
        List <GrantedAuthority> resultado = new ArrayList<GrantedAuthority>(authorities);
        return resultado;
        
    }
    
}
