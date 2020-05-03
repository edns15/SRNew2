package com.sr.taller2.controller.data;

import com.sr.taller2.controller.model.User;
import com.sr.taller2.controller.model.Business;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

public class DataRecommendation {

    public HashMap<String, String> AB = new HashMap<>();
    public HashMap<String, String> NC = new HashMap<>();
    public HashMap<String, String> OH = new HashMap<>();
    public HashMap<String, String> PA = new HashMap<>();
    public HashMap<String, String> QC = new HashMap<>();
    public HashMap<String, String> WI = new HashMap<>();

    public HashMap<String, User> Users = new HashMap<>();
    public HashMap<String, Business> Business = new HashMap<>();

    private String business_file = "business-app.csv";
    private String users_file = "users-app.csv";

    private String AB_file = "AB.csv";
    private String NC_file = "NC.csv";
    private String OH_file = "OH.csv";
    private String PA_file = "PA.csv";
    private String QC_file = "QC.csv";
    private String WI_file = "WI.csv";

    private static DataRecommendation instance = null;

    private DataRecommendation(){
    }

    public static DataRecommendation instance() throws IOException {
        if(instance == null) {
            instance = new DataRecommendation();
            instance.init();
        }
        return instance;
    }

    private void init() throws IOException {
        this.LoadBusiness();
        System.out.println("loaded Business");
        this.LoadUsers();
        System.out.println("loaded Users");
        this.LoadFileAB();
        System.out.println("loaded AB");
        this.LoadFileNC();
        System.out.println("loaded NC");
        this.LoadFileOH();
        System.out.println("loaded OH");
        this.LoadFilePA();
        System.out.println("loaded PA");
        this.LoadFileQC();
        System.out.println("loaded QC");
        this.LoadFileWI();
        System.out.println("loaded WI");
    }

    private void LoadFileNC() throws IOException {
        File file = this.loadFileFromResource(NC_file);

        try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
            stream.forEach((line) -> {

                String[] nuevo = line.split(",");
                String id = nuevo[0]+nuevo[1];
                String objeto = "";
                for(int j = 2; j<nuevo.length;j++){
                    objeto+= nuevo[j];
                }
                String[] rta = objeto.split("'");
                String nuevoObjeto = "";
                for(int k = 1; k<rta.length;k+=2){
                    if(k==rta.length-2){
                        nuevoObjeto+=rta[k];
                    }else {
                        nuevoObjeto+=rta[k]+",";
                    }

                }
                NC.put(id, nuevoObjeto);

            });
        } catch (IOException e) {
            throw e;
        }
    }

    private void LoadFileAB() throws IOException {

        File file = this.loadFileFromResource(AB_file);

        try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
            stream.forEach((line) -> {

                String[] nuevo = line.split(",");
                String id = nuevo[0]+nuevo[1];
                String objeto = "";
                for(int j = 2; j<nuevo.length;j++){
                    objeto+= nuevo[j];
                }
                String[] rta = objeto.split("'");
                String nuevoObjeto = "";
                for(int k = 1; k<rta.length;k+=2){
                    if(k==rta.length-2){
                        nuevoObjeto+=rta[k];
                    }else {
                        nuevoObjeto+=rta[k]+",";
                    }
                }
                AB.put(id, nuevoObjeto);
            });
        } catch (IOException e) {
            throw e;
        }
    }

    private void LoadFileOH() throws IOException {
        File file = this.loadFileFromResource(OH_file);

        try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
            stream.forEach((line) -> {

                String[] nuevo = line.split(",");
                String id = nuevo[0]+nuevo[1];
                String objeto = "";
                for(int j = 2; j<nuevo.length;j++){
                    objeto+= nuevo[j];
                }
                String[] rta = objeto.split("'");
                String nuevoObjeto = "";
                for(int k = 1; k<rta.length;k+=2){
                    if(k==rta.length-2){
                        nuevoObjeto+=rta[k];
                    }else {
                        nuevoObjeto+=rta[k]+",";
                    }

                }
                OH.put(id, nuevoObjeto);

            });
        } catch (IOException e) {
            throw e;
        }
    }

    private void LoadFilePA() throws IOException {
        File file = this.loadFileFromResource(PA_file);

        try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
            stream.forEach((line) -> {

                String[] nuevo = line.split(",");
                String id = nuevo[0]+nuevo[1];
                String objeto = "";
                for(int j = 2; j<nuevo.length;j++){
                    objeto+= nuevo[j];
                }
                String[] rta = objeto.split("'");
                String nuevoObjeto = "";
                for(int k = 1; k<rta.length;k+=2){
                    if(k==rta.length-2){
                        nuevoObjeto+=rta[k];
                    }else {
                        nuevoObjeto+=rta[k]+",";
                    }

                }
                PA.put(id, nuevoObjeto);
                String res = AB.get(id);

            });
        } catch (IOException e) {
            throw e;
        }
    }

    private void LoadFileQC() throws IOException {
        File file = this.loadFileFromResource(QC_file);

        try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
            stream.forEach((line) -> {

                String[] nuevo = line.split(",");
                String id = nuevo[0]+nuevo[1];
                String objeto = "";
                for(int j = 2; j<nuevo.length;j++){
                    objeto+= nuevo[j];
                }
                String[] rta = objeto.split("'");
                String nuevoObjeto = "";
                for(int k = 1; k<rta.length;k+=2){
                    if(k==rta.length-2){
                        nuevoObjeto+=rta[k];
                    }else {
                        nuevoObjeto+=rta[k]+",";
                    }

                }
                QC.put(id, nuevoObjeto);
                String res = AB.get(id);

            });
        } catch (IOException e) {
            throw e;
        }
    }

    private void LoadFileWI() throws IOException {
        File file = this.loadFileFromResource(WI_file);

        try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
            stream.forEach((line) -> {
                String[] nuevo = line.split(",");
                String id = nuevo[0]+nuevo[1];
                String objeto = "";
                for(int j = 2; j<nuevo.length;j++){
                    objeto+= nuevo[j];
                }
                String[] rta = objeto.split("'");
                String nuevoObjeto = "";
                for(int k = 1; k<rta.length;k+=2){
                    if(k==rta.length-2){
                        nuevoObjeto+=rta[k];
                    }else {
                        nuevoObjeto+=rta[k]+",";
                    }

                }
                WI.put(id, nuevoObjeto);

            });
        } catch (IOException e) {
            throw e;
        }
    }

    private void LoadBusiness() throws IOException {
        File file = this.loadFileFromResource(business_file);

        try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
            stream.forEach((line) -> {
                String[] nuevo = line.split(";");
                if(nuevo.length>4){
                    String id = nuevo[0];
                    String name = nuevo[1];
                    String address = nuevo[2];
                    String city = nuevo[3];
                    String state = nuevo[3];
                    Business bu = new Business(id, name, address, city, state);
                    Business.put(id, bu);
                }
            });
        } catch (IOException e) {
            throw e;
        }
    }


    private void LoadUsers() throws IOException {
        File file = this.loadFileFromResource(users_file);

        try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
            stream.forEach((line) -> {
                String[] nuevo = line.split(",");
                if(nuevo.length>2){
                    String id = nuevo[0];
                    String username = nuevo[1];
                    String years =nuevo[2];

                    User usuario = new User(id, username, years);

                    Users.put(id, usuario);

                }
            });
        } catch (IOException e) {
            throw e;
        }
    }

    public File loadFileFromResource(String fileName){
        URL url = this.getClass().getClassLoader().getResource(fileName);
        File file = null;
        try {
            file = new File(url.toURI());
        } catch (URISyntaxException e) {
            file = new File(url.getPath());
        }
        return file;
    }
}
