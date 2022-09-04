/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Jugador implements Serializable {

    private String RoundId;
    private String matchId;
    private String inciales;
    private String entrenador;
    private String alineacion;
    private String numeroCamiseta;
    private String nombreJug;
    private String position;
    private String evento;

    /**
     * Constructor de la clase jugador
     *
     * @param RoundId id de la ronda
     * @param matchId id del partido jugado
     * @param inciales iniciales del equipo
     * @param entrenador nombre del entrenador
     * @param alineacion alineacion del equipo
     * @param numeroCamiseta numero de camiseta del jugador
     * @param nombreJug nombre del jugador del equipo
     * @param position posicion del jugador
     * @param evento eventos marcados por el jugador
     */
    public Jugador(String RoundId, String matchId, String inciales, String entrenador, String alineacion, String numeroCamiseta, String nombreJug, String position, String evento) {
        this.RoundId = RoundId;
        this.matchId = matchId;
        this.inciales = inciales;
        this.entrenador = entrenador;
        this.alineacion = alineacion;
        this.numeroCamiseta = numeroCamiseta;
        this.nombreJug = nombreJug;
        this.position = position;
        this.evento = evento;
    }

    /**
     * metodo get de RoundID
     *
     * @return retorna el id de la ronda
     */
    public String getRoundId() {
        return RoundId;
    }

    /**
     * Asigna RoundId
     *
     * @param RoundId recibe nuevo RoundId
     */
    public void setRoundId(String RoundId) {
        this.RoundId = RoundId;
    }

    /**
     * metodo get de MatchId
     *
     * @return retorna el matchId
     */
    public String getMatchId() {
        return matchId;
    }

    /**
     * metodo set de matchID
     *
     * @param matchId recibe nuevo parametro String de MatchID
     */
    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    /**
     * metodo get de las iniciales del equipo
     *
     * @return retorna las iniciales del equipo
     */
    public String getInciales() {
        return inciales;
    }

    /**
     * metodo set de iniciales
     *
     * @param inciales recibe parametro inciales del equipo
     */
    public void setInciales(String inciales) {
        this.inciales = inciales;
    }

    /**
     * metodo get de entrenador
     *
     * @return retorna el entrenador del equipo
     */
    public String getEntrenador() {
        return entrenador;
    }

    /**
     * metodo set de entrenador
     *
     * @param entrenador parametro de tipo String
     */
    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    /**
     * metodo get de alineacion
     *
     * @return retorna la alineacion del equipo
     */
    public String getAlineacion() {
        return alineacion;
    }

    /**
     * metodo set de alineacion
     *
     * @param alineacion parametro de tipo String para alineacion
     */
    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
    }

    /**
     * metodo get numero de camiseta
     *
     * @return retorna numero de camiseta
     */
    public String getNumeroCamiseta() {
        return numeroCamiseta;
    }

    /**
     * metodo set de numero de camiseta
     *
     * @param numeroCamiseta parametro de tipo entero para numero de camiseta
     * del jugador
     */
    public void setNumeroCamiseta(String numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    /**
     * metodo get nombre del jugador
     *
     * @return retorna nombre del jugador
     */
    public String getNombreJug() {
        return nombreJug;
    }

    /**
     * metodo set del nombre del jugador
     *
     * @param nombreJug parametro de tipo String para nombre del jugador
     */
    public void setNombreJug(String nombreJug) {
        this.nombreJug = nombreJug;
    }

    /**
     * metodo get de posicion
     *
     * @return retorna la posicion que juega el jugador
     */
    public String getPosition() {
        return position;
    }

    /**
     * metodo set de posicion
     *
     * @param position parametro de tipo string de la posicion del jugador
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * metodo get de evento
     *
     * @return retorna el evento marcado por el jugador
     */
    public String getEvento() {
        return evento;
    }

    /**
     * metodo set evento
     *
     * @param evento parametro de tipo String del evento marcado por el jugador
     */
    public void setEvento(String evento) {
        this.evento = evento;
    }
    /**
     * metodo sobreescrito toString 
     * @return un String de los atributos de la clase
     */
    @Override
    public String toString() {
        return     nombreJug +"_"+ inciales ;
    }
    
    

    /**
     * metodo que retorna lista de jugadores del archivo
     *
     * @param archivo parametro String del archivo que se va a leer
     * @return retorna un ArrayList de tipo Jugador
     */
    public static ArrayList<Jugador> listaJugadores(String archivo) {
        ArrayList<Jugador> listaJ = new ArrayList<>();
        try ( BufferedReader bf = new BufferedReader(new FileReader(archivo,StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String datos[] = linea.trim().split(",");

                if (datos.length == 9) {
                    listaJ.add(new Jugador(datos[0].trim(), datos[1].trim(), datos[2].trim(), datos[3].trim(), datos[4].trim(), datos[5].trim(), datos[6].trim(), datos[7].trim(), datos[8].trim()));

                } else if (datos.length == 8) {
                    listaJ.add(new Jugador(datos[0].trim(), datos[1].trim(), datos[2].trim(), datos[3].trim(), datos[4].trim(), datos[5].trim(), datos[6].trim(), datos[7].trim(), null));

                } else if (datos.length == 7) {
                    listaJ.add(new Jugador(datos[0].trim(), datos[1].trim(), datos[2].trim(), datos[3].trim(), datos[4].trim(), datos[5].trim(), datos[6].trim(), null, null));

                }
//                if(!(listaP.contains(datos[8])) && !"Away Team Name".equals(datos[8])){
//                                    }

            }
        } catch (FileNotFoundException fnfe) {

        } catch (IOException ioe) {

        }
        listaJ.remove(0);
        return listaJ;

    }

   

}
