/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.validation.Valid;
import modelo.Cliente;
import modelo.Poliza;
import modelo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ClienteService;
import service.PolizaService;
import service.VehiculoService;
import utilidades.ClientEditor;
import utilidades.VehiculoEditor;

/**
 *
 * @author admin1
 */
@Controller 

public class PolizaController {
    @Autowired 
    private PolizaService polizaService;
    @Autowired 
    private VehiculoService vehiculoService;
    @Autowired 
    private ClienteService clienteService;
    @Autowired 
    private ClientEditor clienteEditor;
    @Autowired 
    private VehiculoEditor vehiculoEditor;

    public void setPolizaService(PolizaService polizaService) {
        this.polizaService = polizaService;
    }

    public void setVehiculoService(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    
    
    @Secured("ROLE_ADMIN")
    @RequestMapping("/altaPoliza")
     public ModelAndView mostrarFormularioAlta(){
    ModelAndView mv = new ModelAndView("altaPolizaForm", "miPoliza", new Poliza());
    mv.addObject("listaVehiculos",vehiculoService.getVehiculos());
    mv.addObject("listaClientes",clienteService.getClientes());
    return mv;
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping("/guardarPoliza")
        public String guardarPoliza(@ModelAttribute("miPoliza") @Valid Poliza poliza,BindingResult result){
        if(result.hasErrors()){
            //Si no cumple esas validaciones lo redirecciono a altaPersonaForm,y arreglo ahora el formulario
            return "altaPolizaForm";
        }else{
//            poliza.setVehiculo(vehiculoService.getVehiculoById(idPoliza));
//            poliza.setCliente(clienteService.getClienteById(idCliente));
            polizaService.altaPoliza(poliza);
            return "redirect:index.htm";
    }
    }
    
      @Secured({"ROLE_GUEST","ROLE_ADMIN"})
      @RequestMapping("/mostrarPolizas")
     public ModelAndView mostrarPolizas(){
        ModelAndView mv = new ModelAndView();
        List<Poliza> lista = polizaService.getPolizas();
        mv.setViewName("mostrarListadoPolizas");
        mv.addObject("listaPolizas",lista);
        return mv;
}
    @Secured("ROLE_ADMIN")
    @RequestMapping("/eliminarPoliza")
     public String bajaPoliza(@ModelAttribute("idPoliza")long id){
        Poliza p = polizaService.getPolizaById(id);
        polizaService.darPolizaBaja(p);
        return "redirect:mostrarPolizas.htm";
    }
     @Secured("ROLE_ADMIN")
      @RequestMapping("/editarPoliza")
    public ModelAndView editarPoliza(@RequestParam("idPoliza")long idPoliza){

          Poliza p = polizaService.getPolizaById(idPoliza);
          ModelAndView mv = new ModelAndView("editarPoliza", "miPolizaModificada", p);
          mv.addObject("listaVehiculosModificados", vehiculoService.getVehiculos());
          mv.addObject("listaClientesModificados", clienteService.getClientes());
          return mv;
     }
     @Secured("ROLE_ADMIN")
     @RequestMapping("/modificarPoliza")
     public String modificarPoliza(@ModelAttribute("miPolizaModificada")@Valid Poliza poliza,BindingResult result ){
        if(result.hasErrors()){
            return "editarPoliza";
        }else{
          //  poliza.setVehiculo(vehiculoService.getVehiculoById(idVehiculo));
           // poliza.setCliente(clienteService.getClienteById(idCliente));
            polizaService.modificarPoliza(poliza);
            return "mostrarPolizas.htm";
        }
     }
     @InitBinder
     public void initBinder(WebDataBinder binder){
         binder.registerCustomEditor(Cliente.class, clienteEditor);
         binder.registerCustomEditor(Vehiculo.class, vehiculoEditor);
     }
    
    
}
