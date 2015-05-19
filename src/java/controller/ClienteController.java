/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.validation.Valid;
import modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ClienteService;
import service.PolizaService;

/**
 *
 * @author admin1
 */
@Controller 
public class ClienteController {
    @Autowired 
    private ClienteService clienteService;
     @Autowired 
    private PolizaService polizaService;

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping("/altaCliente")
   public ModelAndView mostrarFormularioAlta(){
    ModelAndView mv = new ModelAndView("altaClienteForm", "miCliente", new Cliente());
    
    return mv;
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping("/guardarCliente")
       public String guardarCliente(@ModelAttribute(value="miCliente") @Valid Cliente c,BindingResult result){
        if(result.hasErrors()){
            //Si no cumple esas validaciones lo redirecciono a altaPersonaForm,y arreglo ahora el formulario
            return "altaClienteForm";
        }else{
           
            clienteService.altaCliente(c);
            return "redirect:index.htm";
        }
    }
       
       @Secured({"ROLE_GUEST","ROLE_ADMIN"})
      @RequestMapping("/mostrarClientes")
    public ModelAndView mostrarListadoDeClientes(){
        ModelAndView mv = new ModelAndView();
        List<Cliente> lista = clienteService.getListaClientePolizas();
        mv.setViewName("mostrarListadoClientes");
        mv.addObject("listaClientes",lista);
        return mv;
}
    @Secured("ROLE_ADMIN")
    @RequestMapping("/eliminarCliente")
     public String bajaCliente(@ModelAttribute("idCliente")long id){
        Cliente c = clienteService.getClienteById(id);
        clienteService.darClienteBaja(c);
        return "mostrarClientes.htm";
    }
      
     @Secured("ROLE_ADMIN")
     @RequestMapping("/editarCliente")
     public ModelAndView editarCliente(@RequestParam("idCliente")long idCliente){

          Cliente c = clienteService.getClienteById(idCliente);
          ModelAndView mv = new ModelAndView("editarCliente", "miClienteModificado", c);
          return mv;
     }
     @Secured("ROLE_ADMIN")
    @RequestMapping("/modificarCliente")
     public String modificarCliente(@ModelAttribute("miClienteModificado")@Valid Cliente cliente,BindingResult result ){
        if(result.hasErrors()){
            return "editarCliente";
        }else{
            clienteService.modificarCliente(cliente);
            return "mostrarClientes.htm";
        }
     }
}
