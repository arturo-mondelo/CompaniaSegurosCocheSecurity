/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.beans.PropertyEditorSupport;
import modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.ClienteService;

/**
 *
 * @author Arturo
 */
@Component
public class ClientEditor extends PropertyEditorSupport {
    @Autowired
    private ClienteService clienteService;

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    public void setAsText(String text){
        Cliente c = clienteService.getClienteById(Long.parseLong(text));
        this.setValue(c);
    }

    @Override
    public String getAsText() {
       Cliente c=(Cliente)getValue();
        if(c==null){
           return "0";
       }
      long id=c.getId();
      return Long.toString(id);
        //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
   

   
}
