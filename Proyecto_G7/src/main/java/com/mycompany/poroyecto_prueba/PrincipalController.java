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
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Clase de controlador FXML PrincipalController que pertenece al paquete
 * com.mycompany.poroyecto_prueba e implementa Initializable
 *
 * @author Michael Estrada
 * @author Carlos Tingo
 */
public class PrincipalController implements Initializable {

    /**
     * Método sobreescrito que inicializa la clase de controlador.
     *
     * @param url La ubicación utilizada para resolver rutas relativas para el
     * objeto raíz, o nula si no se conoce la ubicación.
     * @param rb Los recursos usados ​​para localizar el objeto raíz, o nulo si
     * el objeto raíz no estaba localizado.
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
     * Método que controla la función del botón para que abra la ventana Consultar Partidos
     * @param ae la acción que hace el botón cuando le dan click en él
     */
    @FXML
    public void consultaPartidos(ActionEvent ae) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConsultaPartido.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            VBox root = new VBox(new Label("Lo sentimos, tuvimos problemas con la app :c"));
            root.setAlignment(Pos.CENTER);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
        }

    }

    /**
     * Método que controla la función del botón para que abra la ventana Consultar Copas Mundiales
     * @param ae la acción que hace el botón cuando le dan click en él
     */
    @FXML
    public void consultarCopasMundiales(ActionEvent ae) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConsultaCopaMundial.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            VBox root = new VBox(new Label("Lo sentimos, tuvimos problemas con la app :c"));
            root.setAlignment(Pos.CENTER);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
        }

    }

}
