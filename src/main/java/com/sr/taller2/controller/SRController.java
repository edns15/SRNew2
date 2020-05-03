package com.sr.taller2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase controladora, encargada de redireccionar a la visa de cada uno de los talleres.
 *
 */
@Controller
public class SRController {

    @RequestMapping("/")
    public String index(Model model) {
        
        return "index";
    }  
    
    /**
     * Método encargado de direccionar a la vista del Taller2.
     *
     * @return Modelo
     */
    @RequestMapping("/taller2")
    public ModelAndView taller2() {
        Map<String, Object> model = new HashMap<>();
        model.put("Estado","NC");
        model.put("tipo_visita","");
        model.put("user","");

        return new ModelAndView("taller2", model);
    }
}