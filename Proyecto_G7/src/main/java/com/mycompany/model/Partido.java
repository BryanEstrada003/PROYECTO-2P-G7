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
     
    
    //ListaFase
    public static ArrayList<String> listaFase(String nombreArchivo){
        ArrayList<String> grupoFase = new ArrayList<>();
        
         try(BufferedReader bf=new BufferedReader(new FileReader(nombreArchivo))){
            String linea;
            grupoFase.add("Group");  
            while((linea = bf.readLine())!= null){
                String datos[] = linea.split("\\|");
                //DatoFase
                
                if(!(grupoFase.contains(datos[2])) && !"Stage".equals(datos[2]) && !datos[2].startsWith("G")){
                                      
                    grupoFase.add(datos[2]);
              
                }
                
            }
            
        }catch(IOException ioe){
            System.out.println("Ocurrió un problema con el aplicativo");
            
        }
        return grupoFase;
        
        
    }
    
    //listaGrupo
    public static ArrayList<String> listaGrupos(String nombreArchivo){
        ArrayList<String> grupoLista = new ArrayList<>();
        
         try(BufferedReader bf=new BufferedReader(new FileReader(nombreArchivo))){
            String linea;
            
            while((linea = bf.readLine())!= null){
//                System.out.println(linea);
                String datos[] = linea.split("\\|");
                //DatoFase
                
                if(!(grupoLista.contains(datos[2])) && !"Stage".equals(datos[2]) && datos[2].startsWith("G")){
                    
                    grupoLista.add(datos[2]);
              
                }
                
            }
            
        }catch(IOException ioe){
            System.out.println("Ocurrió un problema con el aplicativo");
            
        }
        return grupoLista;
    }          
        
    //Lectura de archivo y creacion de quipo local
    public static ArrayList<String> listaEquipoLocal(String nombreArchivo){
        ArrayList<String> grupoEquipo = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(nombreArchivo))){
            String linea;
            while((linea=bf.readLine())!=null){
                String equipo[] = linea.split("\\|");
                if(!(grupoEquipo.contains(equipo[5])) && !"Home Team Name".equals(equipo[5])){
                    String equipoconresultados = equipo[5];
//                    System.out.println(Arrays.toString(equipoconresultados));
                    
                    grupoEquipo.add(equipoconresultados);
              
                }
                
            }
            
        }catch(FileNotFoundException fnfe){
            System.out.println("Archivo no encontrado");
        }catch(IOException ioe){
            System.out.println("Error de programa");
        }
        
        return grupoEquipo;
    }
    
    //ListaEquipoVisitante
    public static ArrayList<String> listaEquipoVisitante(String nombreArchivo){
        ArrayList<String> grupoEquipo = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(nombreArchivo))){
            String linea;
            while((linea=bf.readLine())!=null){
                String datos[] = linea.split("\\|");
                if(!(grupoEquipo.contains(datos[8])) && !"Away Team Name".equals(datos[8])){
                    String equipoconresultados =datos[8];
//                    System.out.println(Arrays.toString(equipoconresultados));
                    
                    grupoEquipo.add(equipoconresultados);
              
                }
                
            }
            
        }catch(FileNotFoundException fnfe){
            System.out.println("Archivo no encontrado");
        }catch(IOException ioe){
            System.out.println("Error de programa");
        }
        
        return grupoEquipo;
    }
    
    
    
//    public static void main(String[] args) {
//        System.out.println(Partido.listaFase("WorldCupMatchesBrasil2014.csv"));
//        System.out.println(Partido.listaGrupos("WorldCupMatchesBrasil2014.csv"));
//        System.out.println(Partido.listaEquipoLocal("WorldCupMatchesBrasil2014.csv"));
//        System.out.println(Partido.listaEquipoVisitante("WorldCupMatchesBrasil2014.csv"));
//        
//    }
  
//    }
}
