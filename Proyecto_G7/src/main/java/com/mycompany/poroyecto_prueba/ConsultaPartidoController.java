/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.poroyecto_prueba;

import com.mycompany.model.Partido;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * Clase de controlador FXML ConsultaPartidoController que pertenece al
 paquete com.mycompany.poroyecto_prueba e implementa Initializable
 *
 * @author Michael Estrada
 * @author Carlos Tingo
 */
public class ConsultaPartidoController implements Initializable {

    @FXML
    private ComboBox<String> faseCmb;
    @FXML
    private ComboBox<String> Eq1Cmb;
    @FXML
    private ComboBox<String> gruposCmb;
    @FXML
    private ComboBox<String> Eq2Cmb;

    /**
     * Método sobreescrito que inicializa la clase de controlador.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> listG = Partido.listaGrupos("WorldCupMatchesBrasil2014.csv");
        ArrayList<String> listF = Partido.listaFase("WorldCupMatchesBrasil2014.csv");
        ArrayList<String> listEquipLocal = Partido.listaEquipoLocal("WorldCupMatchesBrasil2014.csv");
        ArrayList<String> listEquipoVisit = Partido.listaEquipoVisitante("WorldCupMatchesBrasil2014.csv");
        //setear CmbBox
        gruposCmb.getItems().setAll(listG);
        faseCmb.getItems().setAll(listF);
        Eq1Cmb.getItems().setAll(listEquipLocal);
        Eq2Cmb.getItems().setAll(listEquipoVisit);
        
    }

}
