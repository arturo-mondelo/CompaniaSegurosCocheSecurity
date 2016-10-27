/*
 * utilidades para editar vehiculo
 */
package utilidades;

import java.beans.PropertyEditorSupport;
import modelo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.VehiculoService;

/**
 *
 * @author amondelo
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
        
    }
}
