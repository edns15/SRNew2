package com.sr.taller2.controller;

import com.sr.taller2.controller.data.DataRecommendation;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Taller2Controller {

    private DataRecommendation models = DataRecommendation.instance();

    public Taller2Controller() throws IOException {
    }

    @RequestMapping("/t2_restaurantes_recomendacion")
    public ModelAndView t2RestaurantesRecomendacion(@RequestParam String user
            ,@RequestParam String Estado, @RequestParam String tipo_visita) {

        if(tipo_visita.equals(""))
        {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://127.0.0.1:5000/predict?state=WI&user=-0-8dZP-jWAqamQ-dj2hLA";
            String info = restTemplate.getForObject(url, String.class);
            System.out.println(info);
        }
        else{

        }

        Map<String, Object> model = new HashMap<>();
        model.put("Estado","");
        model.put("tipo_visita","");
        model.put("user","");

        return new ModelAndView("taller2", model);
    }
}
