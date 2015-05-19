/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.validation.Valid;
import modelo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.VehiculoService;

/**
 *
 * @author admin1
 */
@Controller 
public class VehiculoController {
    
    @Autowired 
    private VehiculoService vehiculoService;

    public void setVehiculoService(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping("/altaVehiculo")
    public ModelAndView mostrarFormularioAlta(){
    ModelAndView mv = new ModelAndView("altaVehiculoForm", "miVehiculo", new Vehiculo());
    return mv;
    }
    
    @Secured("ROLE_ADMIN")
    @RequestMapping("/guardarVehiculo")
       public String guardarVehiculo(@ModelAttribute("miVehiculo") @Valid Vehiculo vehiculo,BindingResult result){
        if(result.hasErrors()){
            //Si no cumple esas validaciones lo redirecciono a altaPersonaForm,y arreglo ahora el formulario
            return "altaVehiculoForm";
        }else{
            vehiculoService.altaVehiculo(vehiculo);
            return "redirect:index.htm";
    }
       }
    
      @Secured({"ROLE_GUEST","ROLE_ADMIN"})
      @RequestMapping("/mostrarVehiculos")
    public ModelAndView mostrarListadoDeVehiculos(){
        ModelAndView mv = new ModelAndView();
        List<Vehiculo> lista = vehiculoService.getVehiculos();
        mv.setViewName("mostrarListadoVehiculos");
        mv.addObject("listaVehiculos",lista);
        return mv;
}
    @Secured("ROLE_ADMIN")
    @RequestMapping("/eliminarVehiculo")
     public String bajaVehiculo(@ModelAttribute("idVehiculo")long id){
        Vehiculo v = vehiculoService.getVehiculoById(id);
        vehiculoService.darVehiculoBaja(v);
        return "mostrarVehiculos.htm";
    }
      @Secured("ROLE_ADMIN")
     @RequestMapping("/editarVehiculo")
    public ModelAndView editarVehiculo(@RequestParam("idVehiculo")long idVehiculo){

          Vehiculo v = vehiculoService.getVehiculoById(idVehiculo);
          ModelAndView mv = new ModelAndView("editarVehiculo", "miVehiculoModificado", v);
          return mv;
     }
     @Secured("ROLE_ADMIN")
     @RequestMapping("/modificarVehiculo")
     public String modificarVehiculo(@ModelAttribute("miVehiculoModificado")@Valid Vehiculo vehiculo,BindingResult result ){
        if(result.hasErrors()){
            return "editarVehiculo";
        }else{
            vehiculoService.modificarVehiculo(vehiculo);
            return "mostrarVehiculos.htm";
        }
     }
}
