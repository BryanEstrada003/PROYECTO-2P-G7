/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.poroyecto_prueba;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Clase de controlador FXML PrincipalController que pertenece al paquete com.mycompany.poroyecto_prueba e implementa Initializable
 * 
 * @author Michael Estrada
 * @author Carlos Tingo
 */
public class PrincipalController implements Initializable {

    /**
     * Método sobreescrito que inicializa la clase de controlador.
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private Button btnconsultarPartidos;
    
    @FXML
    private Button btnconsultarCopasMundiales;
    
    /**
     * 
     * @param ae 
     */
    @FXML
    public void consultaPartidos(ActionEvent ae){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConsultaPartido.fxml"));
            Parent root = loader.load();
//            ConsultaCopaMundialController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            System.out.println("OJO VER COMO ARREGLAMOS ESTE CATCH PARA QUE NO SALGA ESTE MENSAJE");//OJITO
        }
        
    }
    
    /**
     * 
     * @param ae 
     */
    @FXML
    public void consultarCopasMundiales(ActionEvent ae){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConsultaCopaMundial.fxml"));
            Parent root = loader.load();
//            ConsultaCopaMundialController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            System.out.println("OJO VER COMO ARREGLAMOS ESTE CATCH PARA QUE NO SALGA ESTE MENSAJE");//OJITO
        }
        
    }
    
    
    
}
