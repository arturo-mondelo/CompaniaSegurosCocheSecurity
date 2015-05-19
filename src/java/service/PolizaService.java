/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.PolizaDao;
import java.util.List;
import modelo.Poliza;
import modelo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin1
 */
@Service
@Transactional
public class PolizaService {
    @Autowired
    private PolizaDao polizaDao;

    public void setPolizaDao(PolizaDao polizaDao) {
        this.polizaDao = polizaDao;
    }
    
      public List<Poliza> getPolizas(){
        return polizaDao.getListPolizas();
    }
      public List<Poliza> getListaPolizasCompletas(){
       return polizaDao.getListPolizasCliente();
   }
    
    public Poliza getPolizaById( long id){
        return polizaDao.getPolizaById(id);
    }
    
    public void darPolizaBaja(Poliza poliza){
        polizaDao.borrarPoliza(poliza);
    }
    
    
    public void darPolizaBajaPorId(long id){
        Poliza p = polizaDao.getPolizaById(id);
        polizaDao.borrarPoliza(p);
    }
   
    public void altaPoliza(Poliza poliza){
        polizaDao.altaPoliza(poliza);
    }
    
    public void modificarPoliza(Poliza poliza){
        polizaDao.modificarPoliza(poliza);
    }
}
