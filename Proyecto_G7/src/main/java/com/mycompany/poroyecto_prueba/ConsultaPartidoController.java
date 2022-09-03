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
 * Clase de controlador FXML ConsultaPartidoController que pertenece al
 * paquete com.mycompany.poroyecto_prueba e implementa Initializable
 *
 * @author Michael Estrada
 * @author Carlos Tingo
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
    
    /**
     * Método sobreescrito que permite Inicializa la clase de controlador.
     *
     * @param url La ubicación utilizada para resolver rutas relativas para el
     * objeto raíz, o nula si no se conoce la ubicación.
     * @param rb Los recursos usados ​​para localizar el objeto raíz, o nulo si
     * el objeto raíz no estaba localizado.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        btnConsultar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Label txtConsultaPartido = new Label();
                Partido partidoSeleccionado= null;
                for (Partido r : listPartido) {
                    contenedorResultadoPartido.getChildren().clear();
                    if (fase.getSelectionModel().getSelectedItem().equals(r.getStage()) && eq1.getSelectionModel().getSelectedItem().equals(r.getHomeTN()) && eq2.getSelectionModel().getSelectedItem().equals(r.getAwayTN())) {
                        partidoSeleccionado = r;
                    }

                }
                if (partidoSeleccionado != null) {
                    contenedorFecha.getChildren().clear();
                    contenedorUltimo.getChildren().clear();
                    contenedorDatos.getChildren().clear();
                    contenedorBotones.getChildren().clear();
                    contenedorResultadoPartido.getChildren().clear();
                    txtConsultaPartido.setText("Resultado del partido");
                    txtConsultaPartido.setFont(Font.font("Arial", FontWeight.BOLD, 13));
                    contenedorResultadoPartido.getChildren().add(txtConsultaPartido);
                    String[] dateTime = partidoSeleccionado.getDateTime().trim().split("-");
                    contenedorFecha.getChildren().add(new Label(dateTime[0].trim()));

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
        });

    }

}