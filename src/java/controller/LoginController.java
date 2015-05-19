/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin1
 */
@Controller
public class LoginController {
    
    @Autowired
    private MessageSource messageSource;
    
    @RequestMapping("/login")
    public String entrada(){
        return "login_page";
    }
    
    
    
    @RequestMapping("/errorLogin")
    public String errorLogin(Model modelo,Locale locale){
        String msg = messageSource.getMessage("errorLogin", null, locale);
        modelo.addAttribute("error", msg);
        return "login_page";
    }
    @RequestMapping("/logout")
    public String logout(Model modelo){
        //modelo.addAttribute("aviso", "Logout Correcto");
        return "redirect:index.htm";
    }
    
    @RequestMapping("/accesoDenegado")
    public String accesoDenegado(){
        return"accesoDenegado";
    }
    
    
    
}
