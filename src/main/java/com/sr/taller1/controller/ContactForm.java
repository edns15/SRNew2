package com.sr.taller1.controller;
import com.sr.taller1.data.DataRecommendationModels;
import com.sr.taller1.model.Recommendation;
import com.sr.taller1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Key;
import java.util.*;


@Controller
public class ContactForm {

    private HashMap<String, Long> usuarios = new HashMap<String, Long>();
    private HashMap<Long, String> tracks = new HashMap<Long, String>();
    private List<User> usuarioss;

    private DataRecommendationModels models = DataRecommendationModels.instance();


    public ContactForm() throws IOException {
    }

    @RequestMapping("/show_user_list")
    public ModelAndView darUsuarios(@RequestParam Map<String, String> params) {
        usuarios = models.getUsersAllReady();
        tracks = models.getTracksAllReady();

        List<User> nuevaLista = listar(usuarios,tracks);

        Map<String, Object> model = new HashMap<>();
        model.put("recommendations",nuevaLista);


        return new ModelAndView("taller1UsuarioRating", model);
    }




    public void setUsuarios(HashMap<String, Long> pUsuarios) {
        usuarios = pUsuarios;
    }
    
     @RequestMapping("/addUserRating")
    public ModelAndView t1AgregarUsuarioRating(@RequestParam Map<String, String> params){
        System.out.println("Se van a agregar ratings");
        Map<String, Object> model = new HashMap<>();
        String tipoRecomendador = params.get("tipo");
        String user = params.get("user");
        String item = params.get("item");
        String rating = params.get("rating");

        HashMap<String, Long> nuevo = models.getUsers_ids();
        System.out.println("en hash map" + nuevo.get(user));



        if(elUsuarioExiste(params)==false){
            agregarUsuario(params);
            try {
                models.loadUsers();
            } catch (IOException e) {

                System.out.println(e.getMessage());
            }
        }

        Long userL = nuevo.get(user);

        Long itemL = Long.parseLong(item);
        //System.out.println("Long de usuario: " + userL + " "  );
        Long ratingL = Long.parseLong(rating);



        models.addRating(tipoRecomendador, userL, itemL,  ratingL);
        return new ModelAndView("taller1UsuarioRating", model);
    }

    public List<User> listar(HashMap<String, Long> pUsuarios, HashMap<Long, String> pTracks) {
        List<String> result2 = new ArrayList(pUsuarios.keySet());
        List<Long> result3 = new ArrayList(pTracks.keySet());


        ArrayList<User> lista = new ArrayList<>();

        ArrayList<Recommendation> recommendationResult = new ArrayList<>();


        for(String value : result2){

            String userId = value;

            User usuario = new User();
            usuario.setUserId(userId);


            lista.add(usuario);
        }
        for(int i = 0; i < result2.size(); i++){

            Long trackId = result3.get(i);
            User usuario = lista.get(i);
            usuario.setTrackId(trackId);
        }

        //Corregir, si hay más items que usuarios
        return lista;
    }
    
     public boolean elUsuarioExiste(@RequestParam Map<String, String> params){
        boolean rta = false;
        String user = params.get("user");

        HashMap<String, Long> nuevo = models.getUsers_ids();
        System.out.println("en hash map" + nuevo.get(user));

        Long userL = nuevo.get(user);
        if(userL!=null){
            rta = true;

        }

        return rta;
    }
    
    public void agregarUsuario(@RequestParam Map<String, String> params){


        String user = params.get("user");

        HashMap<String, Long> nuevo = models.getUsers_ids();
        System.out.println("en hash map" + nuevo.get(user));
        Long id = new Long(nuevo.size()+1);


        models.addUser(user, id);
        


    }
    
   
    

}
