    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author USER
 */
public class CopaMundial {
    private String year;
    private String country;
    private String winner;
    private String runnersUp;
    private String third;
    private String fourth;
    private String goalsScored;
    private String QualifiedTeams;
    private String MatchesPlayed;
    private String Attendance;
    
    //Constructor

    public CopaMundial(String year, String country, String winner, String runnersUp, String third, String fourth, String goalsScored, String QualifiedTeams, String MatchesPlayed, String Attendance) {
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
    //Getters
    public String getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getWinner() {
        return winner;
    }

    public String getRunnersUp() {
        return runnersUp;
    }

    public String getThird() {
        return third;
    }

    public String getFourth() {
        return fourth;
    }

    public String getGoalsScored() {
        return goalsScored;
    }

    public String getQualifiedTeams() {
        return QualifiedTeams;
    }

    public String getMatchesPlayed() {
        return MatchesPlayed;
    }

    public String getAttendance() {
        return Attendance;
    }
    
    //Setters

    public void setYear(String year) {
        this.year = year;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setRunnersUp(String runnersUp) {
        this.runnersUp = runnersUp;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public void setFourth(String fourth) {
        this.fourth = fourth;
    }

    public void setGoalsScored(String goalsScored) {
        this.goalsScored = goalsScored;
    }

    public void setQualifiedTeams(String QualifiedTeams) {
        this.QualifiedTeams = QualifiedTeams;
    }

    public void setMatchesPlayed(String MatchesPlayed) {
        this.MatchesPlayed = MatchesPlayed;
    }

    public void setAttendance(String Attendance) {
        this.Attendance = Attendance;
    }
    

    
}
