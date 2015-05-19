/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserRoleDao;
import modelo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin1
 */
@Service
@Transactional
public class RoleService {
    @Autowired
    private UserRoleDao uRoleDao;

    public void setuRoleDao(UserRoleDao uRoleDao) {
        this.uRoleDao = uRoleDao;
    }
    
    public Role getUserRole(long id){
        return this.uRoleDao.getRole(id);
    }
    
    public void altaUserRole(Role ur){
        uRoleDao.altaRole(ur);
    }

    
    
    
}
