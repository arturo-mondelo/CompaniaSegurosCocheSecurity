/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.VehiculoDao;
import java.util.List;
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
public class VehiculoService {
    @Autowired
    private VehiculoDao vehiculoDao;

    public void setVehiculoDao(VehiculoDao vehiculoDao) {
        this.vehiculoDao = vehiculoDao;
    }
    
   public List<Vehiculo> getVehiculos(){
        return vehiculoDao.getListVehiculos();
    }
    
    public Vehiculo getVehiculoById( long id){
        return vehiculoDao.getVehiculoById(id);
    }
    
    public void darVehiculoBaja(Vehiculo vehiculo){
        vehiculoDao.borrarVehiculo(vehiculo);
    }
    
    
    public void darVehiculoBajaPorId(long id){
        Vehiculo v = vehiculoDao.getVehiculoById(id);
        vehiculoDao.borrarVehiculo(v);
    }
   
    public void altaVehiculo(Vehiculo vehiculo){
        vehiculoDao.altaVehiculo(vehiculo);
    }
    
    public void modificarVehiculo(Vehiculo vehiculo){
        vehiculoDao.modificarVehiculo(vehiculo);
    }
    
} 
    

