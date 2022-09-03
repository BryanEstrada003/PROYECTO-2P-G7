/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.poroyecto_prueba;

import com.mycompany.model.Partido;
import java.net.URL;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ConsultaPartidoController implements Initializable {

    private final ArrayList<Partido> listPartido = Partido.listaPartido("WorldCupMatchesBrasil2014.csv");

    @FXML
    private ComboBox<String> faseCmb;
    @FXML
    private ComboBox<String> Eq1Cmb;
    @FXML
    private ComboBox<String> gruposCmb;
    @FXML
    private ComboBox<String> Eq2Cmb;
    @FXML
    private Button btnConsultar;

    /**
     * Initializes the controller class.
     */
    @FXML
    private HBox contenedorResultadoPartido;
    @FXML
    private HBox contenedorFecha;
    @FXML
    private HBox contenedorUltimo;
    @FXML
    private VBox contenedorDatos;
    @FXML
    private VBox contenedorResultadoFinal;
    @FXML
    private VBox contenedorBotones;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cargarFase();
        cargarGrupos();

    }

    /**
     * Este metodo se encarga de cargar el ComboBox Fase
     */
    private void cargarFase() {
        faseCmb.getItems().addAll(Partido.listaFase("WorldCupMatchesBrasil2014.csv"));
        faseCmb.setOnAction(new EventHandler() {
            @Override
            public void handle(Event t) {
                String s = faseCmb.getSelectionModel().getSelectedItem();
                //GRUPOS 

                if ("Group".equals(s)) {
                    gruposCmb.setDisable(false);
                    // LOS QUE NO SON DE GRUPOS
                } else {

                    String sg = faseCmb.getSelectionModel().getSelectedItem();
                    gruposCmb.setDisable(true);

                    cargarEquipos(sg);
                    seleccionarEquipo(faseCmb, Eq1Cmb, Eq2Cmb);
                }
            }
        });
    }

    /**
     * Este metodo carga los grupos al ComboBox cmbGrupos
     */
    private void cargarGrupos() {

        gruposCmb.getItems().addAll(Partido.listaGrupos("WorldCupMatchesBrasil2014.csv"));
        gruposCmb.setOnAction(new EventHandler() {
            @Override
            public void handle(Event t) {
                String sg = gruposCmb.getSelectionModel().getSelectedItem();
                System.out.println(sg);
                cargarEquipos(sg);
                seleccionarEquipo(gruposCmb, Eq1Cmb, Eq2Cmb);

            }
        });

    }

    /**
     * Este metodo carga los equipos
     *
     * @param sg recibe como parametro el tipo de seleccion para cada caso ya
     * sea si se busca por grupo o Fase
     */
    private void cargarEquipos(String sg) {
//        String sg = gruposCmb.getSelectionModel().getSelectedItem();
//        System.out.println(sg);
        Eq1Cmb.getItems().clear();
        Eq2Cmb.getItems().clear();
        for (Partido l : listPartido) {
            if (sg.equals(l.getStage())) {

                if (!(Eq1Cmb.getItems().contains(l.getHomeTN())) && !(Eq2Cmb.getItems().contains(l.getAwayTN()))) {

                    Eq1Cmb.getItems().addAll(l.getHomeTN());
                    Eq2Cmb.getItems().addAll(l.getAwayTN());

                }

            }

        }
    }

    private void seleccionarEquipo(ComboBox fase, ComboBox eq1, ComboBox eq2) {
        btnConsultar.setOnAction(new EventHandler< ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

                Partido partidoSeleccionado = null;
                Label txtConsultaPartido = new Label();

                for (Partido r : listPartido) {
                    contenedorResultadoPartido.getChildren().clear();

                    if (fase.getSelectionModel().getSelectedItem().equals(r.getStage()) && eq1.getSelectionModel().getSelectedItem().equals(r.getHomeTN()) && eq2.getSelectionModel().getSelectedItem().equals(r.getAwayTN())) {
                        partidoSeleccionado = r;

                    } else {
                        contenedorFecha.getChildren().clear();
                        contenedorUltimo.getChildren().clear();
                        contenedorDatos.getChildren().clear();
                        contenedorBotones.getChildren().clear();
                        contenedorResultadoPartido.getChildren().removeAll(txtConsultaPartido);
                        txtConsultaPartido.setText("Partido no encontrado");
                        contenedorResultadoPartido.getChildren().add(txtConsultaPartido);
                    }

                }

                contenedorResultadoPartido.getChildren().clear();
                txtConsultaPartido.setText("Resultado del partido");
                txtConsultaPartido.setFont(Font.font("Arial", FontWeight.BOLD, 13));
                contenedorResultadoPartido.getChildren().add(txtConsultaPartido);
                try {
                    if (partidoSeleccionado != null) {
                        String[] dateTime = partidoSeleccionado.getDateTime().trim().split("-");
                        contenedorFecha.getChildren().add(new Label(dateTime[0].trim()));
                    }

                } catch (NullPointerException npe) {

                }
            }
        });

//        DateTimeFormatter esDateFormatLargo = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy '").withLocale(new Locale("es", "ES"));
    }

   

//        if(){
    @FXML
    private void consultar(ActionEvent event) {

    }
}

//    @FXML
//    private void selectFase(ActionEvent e) {
//        String s = faseCmb.getSelectionModel().getSelectedItem();
//        System.out.println(s);
//        if (!"Group".equals(s)) {
//            gruposCmb.getItems().clear();
////            Eq1Cmb.getItems().addAll(Partido.listaEquipoLocal("WorldCupMatchesBrasil2014.csv"));
////            Eq2Cmb.getItems().addAll(Partido.listaEquipoVisitante("WorldCupMatchesBrasil2014.csv"));
//        } else {
//            gruposCmb.getItems().addAll(Partido.listaGrupos("WorldCupMatchesBrasil2014.csv"));
//
//        }
//
//    }
//// "WorldCupMatchesBrasil2014.csv"
//
//    @FXML
//    private void selectGrupos(ActionEvent e) {
//        String sg = gruposCmb.getSelectionModel().getSelectedItem();
//        //Grupo A
//        System.out.println(sg);
//        ArrayList<Partido> listPartido = Partido.listaPartido("WorldCupMatchesBrasil2014.csv");
//        Eq1Cmb.getItems().clear();
//        for (Partido l : listPartido) {
//            System.out.println(l.getStage() + " - " + l.getHomeTN());
//            if (sg.equals(l.getStage())) {
//                if(!(Eq1Cmb.getItems().contains(l.getHomeTN()))){
//                    Eq1Cmb.getItems().addAll(l.getHomeTN());
//                    
//                }
//                
//
//            } else {
////                   System.out.println(sg);
////                   System.out.println(l.getStage());
////                   System.out.println(l.getHomeTN());
//            }
//        }
//    }
//    //comparar equipos
//    private void compararEquipos(){
//        
//        
//    }

