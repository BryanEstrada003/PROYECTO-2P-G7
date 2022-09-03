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
 * Clase Partido que pertenece al paquete com.mycompany.model
 * @author Carlos Tingo
 * @author Michael Estrada
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
    /**
     * Constructor de la clase
     * @param year año que jugaron
     * @param dateTime fecha y hora que jugaron
     * @param stage Fases
     * @param stadium estadio donde se jugó
     * @param city Ciudad del partido
     * @param homeTN nombre del equipo local
     * @param homeTG goles del equipo local
     * @param awayTG goles del equipo visitante
     * @param awayTN nombre del equipo visitante
     * @param winConditions condiciones que el equipo ganó
     * @param attendance asistencias
     * @param halfTimeHomeGoals goles de la mitad del primer tiempo del eq. local
     * @param halfTimeAwayGoals goles de la mitad del primer tiempo del eq. visitante
     * @param referee árbitro
     * @param assistant1 asistente 1
     * @param assistant2 asistente 2
     * @param roundID ID de las rondas jugadas
     * @param matchID ID del partido jugado
     * @param homeTeamInitials comienzo del partido del eq. local
     * @param awayTeamInitials comienzo del partido del eq. visitante
     */
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


    /**
     * Método getter de year
     * @return año que jugaron
     */
    public String getYear() {
        return year;
    }
    

    /**
     * Método getter de dateTime
     * @return fecha y hora que jugaron
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Método getter de stage
     * @return fase
     */
    public String getStage() {
        return stage;
    }

    /**
     * Método getter de stadium
     * @return estadio donde se jugó
     */
    public String getStadium() {
        return stadium;
    }

    /**
     * Método getter de city
     * @return 
     */
    public String getCity() {
        return city;
    }

    /**
     * Método getter de homeTN
     * @return nombre del equipo local
     */
    public String getHomeTN() {
        return homeTN;
    }

    /**
     * Método getter de homeTG
     * @return goles del equipo local
     */
    public String getHomeTG() {
        return homeTG;
    }

    /**
     * Método getter de awayTG
     * @return goles del equipo visitante
     */
    public String getAwayTG() {
        return awayTG;
    }

    /**
     * Método getter de awayTN
     * @return nombre del equipo visitante
     */
    public String getAwayTN() {
        return awayTN;
    }

    /**
     * 
     * @return 
     */
    public String getWinConditions() {
        return winConditions;
    }

    /**
     * Método getter de attendance
     * @return asistencias
     */
    public String getAttendance() {
        return attendance;
    }

    /**
     * Método getter de halfTimeHomeGoals
     * @return goles de la mitad del primer tiempo del eq. local
     */
    public String getHalfTimeHomeGoals() {
        return halfTimeHomeGoals;
    }

    /**
     * Método getter de halfTimeAwayGoals
     * @return goles de la mitad del primer tiempo del eq. visitante
     */
    public String getHalfTimeAwayGoals() {
        return halfTimeAwayGoals;
    }

    /**
     * Método getter de referee
     * @return árbitro
     */
    public String getReferee() {
        return referee;
    }

    /**
     * Método getter de assistant1
     * @return asistente 1
     */
    public String getAssistant1() {
        return assistant1;
    }

    /**
     * Método getter de assistant2
     * @return asistente 2
     */
    public String getAssistant2() {
        return assistant2;
    }

    /**
     * Método getter de roundID
     * @return ID de las rondas jugadas
     */
    public String getRoundID() {
        return roundID;
    }

    /**
     * Método getter de matchID
     * @return ID del partido jugado
     */
    public String getMatchID() {
        return matchID;
    }
    
    /**
     * Método getter de homeTeamInitials
     * @return comienzo del partido del eq. local
     */
    public String getHomeTeamInitials() {
        return homeTeamInitials;
    }
    
    /**
     * Método getter de awayTeamInitials
     * @return comienzo del partido del eq. visitante
     */
    public String getAwayTeamInitials() {
        return awayTeamInitials;
    }
    
    /**
     * Método setter de year
     * @param year año modificado
     */
    public void setYear(String year) {
        this.year = year;
    }
    /**
     * Método setter de dateTime
     * @param dateTime fecha y hora que jugaron modificado
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    /**
     * Método setter de stage
     * @param stage Fases modificada
     */
    public void setStage(String stage) {
        this.stage = stage;
    }
    /**
     * Método setter de stadium
     * @param stadium estadio donde se jugó modificado
     */
    public void setStadium(String stadium) {
        this.stadium = stadium;
    }
    /**
     * Método setter de city
     * @param city Ciudad del partido modificado
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * Método setter de homeTN
     * @param homeTN nombre del equipo loca
     */
    public void setHomeTN(String homeTN) {
        this.homeTN = homeTN;
    }
    /**
     * Método setter de homeTG
     * @param homeTG goles del equipo local modificado
     */
    public void setHomeTG(String homeTG) {
        this.homeTG = homeTG;
    }
    /**
     * Método setter de awayTG
     * @param awayTG goles del equipo visitante modificado
     */
    public void setAwayTG(String awayTG) {
        this.awayTG = awayTG;
    }
    /**
     * Método setter de awayTN 
     * @param awayTN nombre del equipo visitante modificado
     */
    public void setAwayTN(String awayTN) {
        this.awayTN = awayTN;
    }
    /**
     * Método setter de winConditions
     * @param winConditions condiciones que el equipo ganó modificado
     */
    public void setWinConditions(String winConditions) {
        this.winConditions = winConditions;
    }
    /**
     * Método setter de attendance
     * @param attendance asistencias modificadas
     */
    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
    /**
     * Método setter de halfTimeHomeGoals
     * @param halfTimeHomeGoals goles de la mitad del primer tiempo del eq. local modificado
     */
    public void setHalfTimeHomeGoals(String halfTimeHomeGoals) {
        this.halfTimeHomeGoals = halfTimeHomeGoals;
    }
    /**
     * Método setter de halfTimeAwayGoals
     * @param halfTimeAwayGoals goles de la mitad del primer tiempo del eq. visitante modificado
     */
    public void setHalfTimeAwayGoals(String halfTimeAwayGoals) {
        this.halfTimeAwayGoals = halfTimeAwayGoals;
    }
    /**
     * Método setter de referee
     * @param referee árbitro modificado
     */
    public void setReferee(String referee) {
        this.referee = referee;
    }
    /**
     * Método setter de assistant1 modificado
     * @param assistant1 asistente 1 modificado
     */
    public void setAssistant1(String assistant1) {
        this.assistant1 = assistant1;
    }
    /**
     * Método setter de assistant1 modificado
     * @param assistant2 asistente 2 modificado
     */
    public void setAssistant2(String assistant2) {
        this.assistant2 = assistant2;
    }
    /**
     * Método setter de roundID
     * @param roundID ID de las rondas jugadas modificado
     */
    public void setRoundID(String roundID) {
        this.roundID = roundID;
    }
    /**
     * Método setter de matchID
     * @param matchID ID del partido jugado midificado
     */
    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }
    /**
     * Método setter de homeTeamInitials
     * @param homeTeamInitials comienzo del partido del eq. local modificado
     */
    public void setHomeTeamInitials(String homeTeamInitials) {
        this.homeTeamInitials = homeTeamInitials;
    }
    /**
     * Método setter de awayTeamInitials
     * @param awayTeamInitials comienzo del partido del eq. visitante modificado
     */
    public void setAwayTeamInitials(String awayTeamInitials) {
        this.awayTeamInitials = awayTeamInitials;
    }
    /**
     * Método que muestra los atributos de la clase Partido
     * @return Una cadena con la información de la clase Partido
     */
    @Override
    public String toString() {
        return "Partido{" + "year=" + year + ", dateTime=" + dateTime + ", stage=" + stage + ", stadium=" + stadium + ", city=" + city + ", homeTN=" + homeTN + ", homeTG=" + homeTG + ", awayTG=" + awayTG + ", awayTN=" + awayTN + ", winConditions=" + winConditions + ", attendance=" + attendance + ", halfTimeHomeGoals=" + halfTimeHomeGoals + ", halfTimeAwayGoals=" + halfTimeAwayGoals + ", referee=" + referee + ", assistant1=" + assistant1 + ", assistant2=" + assistant2 + ", roundID=" + roundID + ", matchID=" + matchID + ", homeTeamInitials=" + homeTeamInitials + ", awayTeamInitials=" + awayTeamInitials + '}';
    }

    /**
     * Método que carga las fases leyendo un archivo
     * @param nombreArchivo nombre del archivo que será leído
     * @return una lista de las fases que existe
     */
    public static ArrayList<String> listaFase(String nombreArchivo) {
        ArrayList<String> grupoFase = new ArrayList<>();

        try ( BufferedReader bf = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            grupoFase.add("Group");
            while ((linea = bf.readLine()) != null) {
                String datos[] = linea.split("\\|");

                if (!(grupoFase.contains(datos[2])) && !"Stage".equals(datos[2]) && !datos[2].startsWith("G")) {

                    grupoFase.add(datos[2]);

                }

            }

        } catch (IOException ioe) {
            System.out.println("Ocurrió un problema con el aplicativo");

        }
        return grupoFase;

    }

    /**
     * Método que carga los grupos leyendo un archivo
     * @param nombreArchivo nombre del archivo que será leído
     * @return una lista de los grupos extraídos
     */
    public static ArrayList<String> listaGrupos(String nombreArchivo) {
        ArrayList<String> grupoLista = new ArrayList<>();

        try ( BufferedReader bf = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            while ((linea = bf.readLine()) != null) {
                String datos[] = linea.split("\\|");

                if (!(grupoLista.contains(datos[2])) && !"Stage".equals(datos[2]) && datos[2].startsWith("G")) {

                    grupoLista.add(datos[2]);

                }

            }

        } catch (IOException ioe) {
            System.out.println("Ocurrió un problema con el aplicativo");

        }
        return grupoLista;
    }

    
    /**
     * Método que carga los partidos leyendo un archivo 
     * @param archivo nombre del archivo que será leído
     * @return una lista de los partidos extraídos
     */
    public static ArrayList<Partido> listaPartido(String archivo) {
        ArrayList<Partido> listaP = new ArrayList<>();
        try ( BufferedReader bf = new BufferedReader(new FileReader(archivo))) {
            String linea = null;
            while ((linea = bf.readLine()) != null) {
                String datos[] = linea.split("\\|");
                listaP.add(new Partido(datos[0].trim(), datos[1].trim(), datos[2].trim(), datos[3].trim(), datos[4].trim(), datos[5].trim(), datos[6].trim(), datos[7].trim(), datos[8].trim(), datos[9].trim(), datos[10].trim(), datos[11].trim(), datos[12].trim(), datos[13].trim(), datos[14].trim(), datos[15].trim(), datos[16].trim(), datos[17].trim(), datos[18].trim(), datos[19].trim()));

            }
        } catch (FileNotFoundException fnfe) {

        } catch (IOException ioe) {

        }
        listaP.remove(0);
        return listaP;

    }

}
