/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.beans.PropertyEditorSupport;
import modelo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.VehiculoService;

/**
 *
 * @author Arturo
 */
@Component
public class VehiculoEditor extends PropertyEditorSupport{
    @Autowired
    private VehiculoService vehiculoService;

    public void setVehiculoService(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }
    @Override
    public void setAsText(String text){
        Vehiculo v = vehiculoService.getVehiculoById(Long.parseLong(text));
        this.setValue(v);
    }
     @Override
    public String getAsText() {
        
       Vehiculo v=(Vehiculo)getValue();
       if(v==null){
           return "0";
       }
      long id=v.getId();
      return Long.toString(id);
        //To change body of generated methods, choose Tools | Templates.
    }
}
