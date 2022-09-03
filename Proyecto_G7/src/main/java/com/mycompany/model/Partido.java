package com.mycompany.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author USER
 */
public class Partido {

    private String year;
    private String dateTime;
    private String stage; //Fases
    private String stadium;
    private String city;
    private String homeTN;
    private String homeTG;
    private String awayTG;
    private String awayTN;
    private String winConditions;
    private String attendance;
    private String halfTimeHomeGoals;
    private String halfTimeAwayGoals;
    private String referee;
    private String assistant1;
    private String assistant2;
    private String roundID;
    private String matchID;
    private String homeTeamInitials;
    private String awayTeamInitials;

    public Partido(String year, String dateTime, String stage, String stadium, String city, String homeTN, String homeTG, String awayTG, String awayTN, String winConditions, String attendance, String halfTimeHomeGoals, String halfTimeAwayGoals, String referee, String assistant1, String assistant2, String roundID, String matchID, String homeTeamInitials, String awayTeamInitials) {
        this.year = year;
        this.dateTime = dateTime;
        this.stage = stage;
        this.stadium = stadium;
        this.city = city;
        this.homeTN = homeTN;
        this.homeTG = homeTG;
        this.awayTG = awayTG;
        this.awayTN = awayTN;
        this.winConditions = winConditions;
        this.attendance = attendance;
        this.halfTimeHomeGoals = halfTimeHomeGoals;
        this.halfTimeAwayGoals = halfTimeAwayGoals;
        this.referee = referee;
        this.assistant1 = assistant1;
        this.assistant2 = assistant2;
        this.roundID = roundID;
        this.matchID = matchID;
        this.homeTeamInitials = homeTeamInitials;
        this.awayTeamInitials = awayTeamInitials;
    }

//Getters
    public String getYear() {
        return year;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getStage() {
        return stage;
    }

    public String getStadium() {
        return stadium;
    }

    public String getCity() {
        return city;
    }

    public String getHomeTN() {
        return homeTN;
    }

    public String getHomeTG() {
        return homeTG;
    }

    public String getAwayTG() {
        return awayTG;
    }

    public String getAwayTN() {
        return awayTN;
    }

    public String getWinConditions() {
        return winConditions;
    }

    public String getAttendance() {
        return attendance;
    }

    public String getHalfTimeHomeGoals() {
        return halfTimeHomeGoals;
    }

    public String getHalfTimeAwayGoals() {
        return halfTimeAwayGoals;
    }

    public String getReferee() {
        return referee;
    }

    public String getAssistant1() {
        return assistant1;
    }

    public String getAssistant2() {
        return assistant2;
    }

    public String getRoundID() {
        return roundID;
    }

    public String getMatchID() {
        return matchID;
    }

    public String getHomeTeamInitials() {
        return homeTeamInitials;
    }

    public String getAwayTeamInitials() {
        return awayTeamInitials;
    }

    //Setters
    public void setYear(String year) {
        this.year = year;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setHomeTN(String homeTN) {
        this.homeTN = homeTN;
    }

    public void setHomeTG(String homeTG) {
        this.homeTG = homeTG;
    }

    public void setAwayTG(String awayTG) {
        this.awayTG = awayTG;
    }

    public void setAwayTN(String awayTN) {
        this.awayTN = awayTN;
    }

    public void setWinConditions(String winConditions) {
        this.winConditions = winConditions;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public void setHalfTimeHomeGoals(String halfTimeHomeGoals) {
        this.halfTimeHomeGoals = halfTimeHomeGoals;
    }

    public void setHalfTimeAwayGoals(String halfTimeAwayGoals) {
        this.halfTimeAwayGoals = halfTimeAwayGoals;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public void setAssistant1(String assistant1) {
        this.assistant1 = assistant1;
    }

    public void setAssistant2(String assistant2) {
        this.assistant2 = assistant2;
    }

    public void setRoundID(String roundID) {
        this.roundID = roundID;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public void setHomeTeamInitials(String homeTeamInitials) {
        this.homeTeamInitials = homeTeamInitials;
    }

    public void setAwayTeamInitials(String awayTeamInitials) {
        this.awayTeamInitials = awayTeamInitials;
    }

    @Override
    public String toString() {
        return "Partido{" + "year=" + year + ", dateTime=" + dateTime + ", stage=" + stage + ", stadium=" + stadium + ", city=" + city + ", homeTN=" + homeTN + ", homeTG=" + homeTG + ", awayTG=" + awayTG + ", awayTN=" + awayTN + ", winConditions=" + winConditions + ", attendance=" + attendance + ", halfTimeHomeGoals=" + halfTimeHomeGoals + ", halfTimeAwayGoals=" + halfTimeAwayGoals + ", referee=" + referee + ", assistant1=" + assistant1 + ", assistant2=" + assistant2 + ", roundID=" + roundID + ", matchID=" + matchID + ", homeTeamInitials=" + homeTeamInitials + ", awayTeamInitials=" + awayTeamInitials + '}';
    }

    //ListaFase
    public static ArrayList<String> listaFase(String nombreArchivo) {
        ArrayList<String> grupoFase = new ArrayList<>();

        try ( BufferedReader bf = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            grupoFase.add("Group");
            while ((linea = bf.readLine()) != null) {
                String datos[] = linea.split("\\|");
                //DatoFase

                if (!(grupoFase.contains(datos[2])) && !"Stage".equals(datos[2]) && !datos[2].startsWith("G")) {

                    grupoFase.add(datos[2]);

                }

            }

        } catch (IOException ioe) {
            System.out.println("Ocurrió un problema con el aplicativo");

        }
        return grupoFase;

    }

    //listaGrupo
    public static ArrayList<String> listaGrupos(String nombreArchivo) {
        ArrayList<String> grupoLista = new ArrayList<>();

        try ( BufferedReader bf = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            while ((linea = bf.readLine()) != null) {
//                System.out.println(linea);
                String datos[] = linea.split("\\|");
                //DatoFase

                if (!(grupoLista.contains(datos[2])) && !"Stage".equals(datos[2]) && datos[2].startsWith("G")) {

                    grupoLista.add(datos[2]);

                }

            }

        } catch (IOException ioe) {
            System.out.println("Ocurrió un problema con el aplicativo");

        }
        return grupoLista;
    }

    //Lectura de archivo y creacion de quipo local
    public static ArrayList<String> listaEquipoLocal(String nombreArchivo) {
        ArrayList<String> grupoEquipo = new ArrayList<>();
        try ( BufferedReader bf = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String equipo[] = linea.split("\\|");
                if (!(grupoEquipo.contains(equipo[5])) && !"Home Team Name".equals(equipo[5])) {
                    String equipoconresultados = equipo[5];
//                    System.out.println(Arrays.toString(equipoconresultados));

                    grupoEquipo.add(equipoconresultados);

                }

            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ioe) {
            System.out.println("Error de programa");
        }

        return grupoEquipo;
    }

    //ListaEquipoVisitante
    public static ArrayList<String> listaEquipoVisitante(String nombreArchivo) {
        ArrayList<String> grupoEquipo = new ArrayList<>();
        try ( BufferedReader bf = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String datos[] = linea.split("\\|");
                if (!(grupoEquipo.contains(datos[8])) && !"Away Team Name".equals(datos[8])) {
                    String equipoconresultados = datos[8];
//                    System.out.println(Arrays.toString(equipoconresultados));

                    grupoEquipo.add(equipoconresultados);

                }

            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ioe) {
            System.out.println("Error de programa");
        }

        return grupoEquipo;
    }

    //ListaConstructor
    public static ArrayList<Partido> listaPartido(String archivo) {
        ArrayList<Partido> listaP = new ArrayList<>();
        try ( BufferedReader bf = new BufferedReader(new FileReader(archivo))) {
            String linea = null;
            while ((linea = bf.readLine()) != null) {
                String datos[] = linea.split("\\|");
//                if(!(listaP.contains(datos[8])) && !"Away Team Name".equals(datos[8])){
//                                    }
                listaP.add(new Partido(datos[0].trim(), datos[1].trim(), datos[2].trim(), datos[3].trim(), datos[4].trim(), datos[5].trim(), datos[6].trim(), datos[7].trim(), datos[8].trim(), datos[9].trim(), datos[10].trim(), datos[11].trim(), datos[12].trim(), datos[13].trim(), datos[14].trim(), datos[15].trim(), datos[16].trim(), datos[17].trim(), datos[18].trim(), datos[19].trim()));

            }
        } catch (FileNotFoundException fnfe) {

        } catch (IOException ioe) {

        }
        listaP.remove(0);
        return listaP;

    }

    

//    @Override
//    public int compareTo(Partido o) {
//        if (this.getStage() > o.getStage()) {
//            return 1;
//
//        } else if (this.getStage() < o.getStage()) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }

}
