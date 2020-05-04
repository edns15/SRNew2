package com.sr.taller2.controller;

import com.sr.taller2.controller.data.DataRecommendation;
import com.sr.taller2.controller.model.Business;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
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

        Map<String, Object> model = new HashMap<>();
        model.put("Estado",Estado);
        model.put("tipo_visita",tipo_visita);
        model.put("user",user);

        String userId = this.models.User_Names.get(user);

        String[] items = null;

        try {
            if (tipo_visita.equals("")) {
                RestTemplate restTemplate = new RestTemplate();
                String url = "http://127.0.0.1:5000/predict?state=" + Estado + "&user=" + userId;
                String info = restTemplate.getForObject(url, String.class);
                System.out.println(info);

                items = info.replace("\"", "").replace("[[", "")
                        .replace("]]", "").replace("]", "").replace("[", "").split(",");
            } else {
                String info = null;
                if (Estado.equals("WI"))
                    info = this.models.WI.get(userId.toLowerCase() + tipo_visita);
                else if (Estado.equals("AB"))
                    info = this.models.AB.get(userId.toLowerCase() + tipo_visita);
                else if (Estado.equals("NC"))
                    info = this.models.NC.get(userId.toLowerCase() + tipo_visita);
                else if (Estado.equals("OH"))
                    info = this.models.OH.get(userId.toLowerCase() + tipo_visita);
                else if (Estado.equals("PA"))
                    info = this.models.PA.get(userId.toLowerCase() + tipo_visita);
                else if (Estado.equals("QC"))
                    info = this.models.QC.get(userId.toLowerCase() + tipo_visita);

                items = info.split(",");
            }
        }
        catch(Exception ex){
            model.put("errorMessage",ex.getMessage());
        }


        if(items!=null && items.length>0){
            ArrayList<Business> businesses = new ArrayList<>();
            for (String item: items){
                Business business = this.models.Business.get(item.toLowerCase());
                businesses.add(business);
            }
            model.put("recommendations",businesses);
        }



        return new ModelAndView("taller2", model);
    }
}
