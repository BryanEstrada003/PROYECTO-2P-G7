    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase CopaMundial que pertenece al paquete com.mycompany.model
 *
 * @author Michael Estrada
 * @author Carlos Tingo
 */
public class CopaMundial {

    private int year;
    private String country;
    private String winner;
    private String runnersUp;
    private String third;
    private String fourth;
    private int goalsScored;
    private int QualifiedTeams;
    private int MatchesPlayed;
    private String Attendance;

    /**
     * Constructor de la clase CopaMundial
     *
     * @param year año historico de la copa mundial
     * @param country país donde se jugó
     * @param winner ganador de la copa mundial
     * @param runnersUp subcampeón de la copa mundial
     * @param third tercero de la copa mundial
     * @param fourth cuarto de la copa mundial
     * @param goalsScored goles anotados
     * @param QualifiedTeams equipos
     * @param MatchesPlayed partidos jugados
     * @param Attendance asistencia
     */
    public CopaMundial(int year, String country, String winner, String runnersUp, String third, String fourth, int goalsScored, int QualifiedTeams, int MatchesPlayed, String Attendance) {
        this.year = year;
        this.country = country;
        this.winner = winner;
        this.runnersUp = runnersUp;
        this.third = third;
        this.fourth = fourth;
        this.goalsScored = goalsScored;
        this.QualifiedTeams = QualifiedTeams;
        this.MatchesPlayed = MatchesPlayed;
        this.Attendance = Attendance;
    }

    /**
     * Método estático que permite extraer los datos para luego guardarlos en un
     * ArrayList de CopaMundial
     *
     * @param nombreArchivo nombre del archivo que se va a leer
     * @return un ArrayList de CopaMundial
     */
    public static ArrayList<CopaMundial> listaCopasMundiales(String nombreArchivo) {
        ArrayList<CopaMundial> listaCP = new ArrayList<>();
        ArrayList<String> listLine = new ArrayList<>();
        try ( BufferedReader bfr = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            while ((linea = bfr.readLine()) != null) {
                listLine.add(linea.trim());

            }
            String encabezado = listLine.remove(0);
            for (String l : listLine) {
                String[] datos = l.split(",");
                listaCP.add(new CopaMundial(Integer.valueOf(datos[0].trim()), datos[1].trim(), datos[2].trim(), datos[3].trim(), datos[4].trim(), datos[5].trim(), Integer.valueOf(datos[6].trim()), Integer.valueOf(datos[7].trim()), Integer.valueOf(datos[8].trim()), datos[9].trim()));
            }

            try {
                bfr.close();
            } catch (IOException io) {
                System.out.println("lo sentimos, hubo un error en la lectura de datos");
            }

        } catch (FileNotFoundException fnf) {
            System.out.println("Lo sentimos, no hemos encontrado el fichero");
        } catch (IOException io) {
            System.out.println("Lo sentimos, hubo un error en la lectura de datos");
        }

        return listaCP;
    }

    /**
     * Método getter de year
     *
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Método getter de country
     *
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Método getter de winner
     *
     * @return winner
     */
    public String getWinner() {
        return winner;
    }

    /**
     * Método getter de runnersUp
     *
     * @return runnersUp
     */
    public String getRunnersUp() {
        return runnersUp;
    }

    /**
     * Método getter de third
     *
     * @return third
     */
    public String getThird() {
        return third;
    }

    /**
     * Método getter de fourth
     *
     * @return fourth
     */
    public String getFourth() {
        return fourth;
    }

    /**
     * Método getter de goalsScored
     *
     * @return goalsScored
     */
    public int getGoalsScored() {
        return goalsScored;
    }

    /**
     * Método getter de QualifiedTeams
     *
     * @return QualifiedTeams
     */
    public int getQualifiedTeams() {
        return QualifiedTeams;
    }

    /**
     * Método getter de MatchesPlayed
     *
     * @return MatchesPlayed
     */
    public int getMatchesPlayed() {
        return MatchesPlayed;
    }

    /**
     * Método getter de Attendance
     *
     * @return Attendance
     */
    public String getAttendance() {
        return Attendance;
    }

    /**
     * Método setter de year
     *
     * @param year año historico de la copa mundial
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Método setter de country
     *
     * @param country país donde se jugó
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Método setter de winner
     *
     * @param winner ganador de la copa mundial
     */
    public void setWinner(String winner) {
        this.winner = winner;
    }

    /**
     * Método setter de runnersUp
     *
     * @param runnersUp subcampeón de la copa mundial
     */
    public void setRunnersUp(String runnersUp) {
        this.runnersUp = runnersUp;
    }

    /**
     * Método setter de third
     *
     * @param third tercero de la copa mundial
     */
    public void setThird(String third) {
        this.third = third;
    }

    /**
     * Método setter de fourth
     *
     * @param fourth cuarto de la copa mundial
     */
    public void setFourth(String fourth) {
        this.fourth = fourth;
    }

    /**
     * Método setter de goalsScored
     *
     * @param goalsScored goles anotados
     */
    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    /**
     * Método setter de QualifiedTeams
     *
     * @param QualifiedTeams equipos
     */
    public void setQualifiedTeams(int QualifiedTeams) {
        this.QualifiedTeams = QualifiedTeams;
    }

    /**
     * Método setter de MatchesPlayed
     *
     * @param MatchesPlayed partidos jugados
     */
    public void setMatchesPlayed(int MatchesPlayed) {
        this.MatchesPlayed = MatchesPlayed;
    }

    /**
     * Método setter de Attendance
     *
     * @param Attendance asistencia
     */
    public void setAttendance(String Attendance) {
        this.Attendance = Attendance;
    }

    /**
     * Método sobreescrito que devuelve los atributos del objeto CopaMundial
     *
     * @return String de los atributos de CopaMundial
     */
    @Override
    public String toString() {
        return "CopaMundial{" + "year=" + year + ", country=" + country + ", winner=" + winner + ", runnersUp=" + runnersUp + ", third=" + third + ", fourth=" + fourth + ", goalsScored=" + goalsScored + ", QualifiedTeams=" + QualifiedTeams + ", MatchesPlayed=" + MatchesPlayed + ", Attendance=" + Attendance + '}';
    }

}
