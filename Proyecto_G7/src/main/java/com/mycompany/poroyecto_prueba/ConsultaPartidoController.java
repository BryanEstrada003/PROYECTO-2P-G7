/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.poroyecto_prueba;

import com.mycompany.model.Jugador;
import com.mycompany.model.Partido;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Clase de controlador FXML ConsultaPartidoController que pertenece al
 * paquete com.mycompany.poroyecto_prueba e implementa Initializable
 *
 * @author Michael Estrada
 * @author Carlos Tingo
 */
public class ConsultaPartidoController implements Initializable, Serializable {

    private final ArrayList<Partido> listPartido = Partido.listaPartido("WorldCupMatchesBrasil2014.csv");
    private final ArrayList<Jugador> listJugadores = Jugador.listaJugadores("WorldCupPlayersBrasil2014.csv");

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
    private HBox contenedorDatos;
    
    
    private VBox contenedor1 = new VBox();

    private VBox contenedor2 = new VBox();
    private VBox contenedor3 = new VBox();
    private VBox contenedor4 = new VBox();
    HBox eqLocal = new HBox();
    HBox eqVisit = new HBox();
    @FXML
    private VBox contenedorGeneralDatos;
    @FXML
    private HBox contenedorTitulo;
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
        btnConsultar.setOnAction(new EventHandler< ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Partido partidoSeleccionado = null;
                Label txtConsultaPartido = new Label();
                try {
                    for (Partido r : listPartido) {

                        if (fase.getSelectionModel().getSelectedItem().equals(r.getStage()) && eq1.getSelectionModel().getSelectedItem().equals(r.getHomeTN()) && eq2.getSelectionModel().getSelectedItem().equals(r.getAwayTN())) {
                            partidoSeleccionado = r;

                        }

                    }

                    contenedorGeneralDatos.getChildren().clear();
                    contenedor1.getChildren().clear();
                    contenedor2.getChildren().clear();
                    contenedor3.getChildren().clear();
                    contenedor4.getChildren().clear();
//                    contenedorFecha.getChildren().clear();
                    contenedorDatos.getChildren().clear();
                    HBox consultarPartidoTitulo = new HBox();
                    HBox datosPartido = new HBox();
                    if (partidoSeleccionado == null) {
                        contenedorGeneralDatos.getChildren().clear();

                        txtConsultaPartido.setText("Partido no encontrado");
                        txtConsultaPartido.setFont(Font.font("Arial", FontWeight.BOLD, 13));
                        consultarPartidoTitulo.getChildren().add(txtConsultaPartido);
                        contenedorGeneralDatos.getChildren().add(consultarPartidoTitulo);
                    } else {
                        txtConsultaPartido.setText("Resultado del partido");
                        txtConsultaPartido.setFont(Font.font("Arial", FontWeight.BOLD, 13));
                        contenedorTitulo.getChildren().add(txtConsultaPartido);
                        llenarContenido(partidoSeleccionado);

                    }

                } catch (NullPointerException npe) {

                }
            }
        });

//        DateTimeFormatter esDateFormatLargo = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy '").withLocale(new Locale("es", "ES"));
    }

    private void llenarContenido(Partido partidoSeleccionado) {
        String[] dateTime = partidoSeleccionado.getDateTime().trim().split("-");
        HBox contenedorFecha = new HBox();

        String cadenaGoles = partidoSeleccionado.getHomeTG() + "-" + partidoSeleccionado.getAwayTG();

        ImageView imgvLocal = null;
        Label lblImgNoEncontrada = null;
        FileInputStream fi = null;

        try {
            fi = new FileInputStream(Proyecto2P_G7.pathImg + partidoSeleccionado.getHomeTN() + ".jpg");
            Image img = new Image(fi);
            imgvLocal = new ImageView(img);
            imgvLocal.setFitHeight(37);
            imgvLocal.setFitWidth(50);

        } catch (IOException ioe) {
            lblImgNoEncontrada = new Label();
            try {
                fi = new FileInputStream(Proyecto2P_G7.pathImg + "StandardImg.jpg");
                Image i = new Image(fi);
                imgvLocal = new ImageView(i);
            } catch (FileNotFoundException fnf2) {
                eqLocal.getChildren().clear();

                eqLocal.getChildren().add(new Label("Imagen no encontrada"));
            }
            imgvLocal.setFitHeight(37);
            imgvLocal.setFitWidth(50);
        }

        ImageView imgvVisit = null;
        Label lblimgne = null;
        FileInputStream fiv = null;
        try {
            fiv = new FileInputStream(Proyecto2P_G7.pathImg + partidoSeleccionado.getAwayTN() + ".jpg");
            Image img = new Image(fiv);
            imgvVisit = new ImageView(img);
            imgvVisit.setFitHeight(37);
            imgvVisit.setFitWidth(50);

        } catch (IOException ioe) {
            lblimgne = new Label();
            try {
                fiv = new FileInputStream(Proyecto2P_G7.pathImg + "StandardImg.jpg");
                Image i = new Image(fiv);
                imgvVisit = new ImageView(i);
            } catch (FileNotFoundException fnf2) {
                eqVisit.getChildren().clear();

                eqVisit.getChildren().add(new Label("Imagen no encontrada"));
            }
            imgvVisit.setFitHeight(37);
            imgvVisit.setFitWidth(50);
        }

//        contenedorFecha.getChildren().add()
        contenedorGeneralDatos.getChildren().setAll(new Label(dateTime[0].trim()), new Separator(), contenedorFecha);
        //ContenedorDatos
        Label fechaHora = new Label(partidoSeleccionado.getDateTime());
        Label stage = new Label(partidoSeleccionado.getStage());
        stage.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        Label stadium = new Label(partidoSeleccionado.getStadium());
        Label ciudad = new Label(partidoSeleccionado.getCity());
        Label lblLocal = new Label(partidoSeleccionado.getHomeTN());
        lblLocal.setFont(Font.font(24));

        Label finalPartido = new Label("Final del partido");
        Label goles = new Label(cadenaGoles);
        Label lblVisit = new Label(partidoSeleccionado.getAwayTN());
        lblVisit.setFont(Font.font(24));

        HBox eqLocal = new HBox();

        if (imgvLocal != null) {
            eqLocal.getChildren().addAll(imgvLocal, lblLocal);

        } else {
            //lblImgNoEncontrada
            eqLocal.getChildren().addAll(lblImgNoEncontrada, lblLocal);

        }
        HBox eqVisit = new HBox();
        if (imgvVisit != null) {
            eqVisit.getChildren().addAll(imgvVisit, lblVisit);

        } else {
            //lblImgNoEncontrada
            eqLocal.getChildren().addAll(lblimgne, lblVisit);

        }
        ArrayList<Jugador> jugadores = equiposSeleccionados(partidoSeleccionado); 
        Button exportarGrupo = new Button("EXPORTAR RESULTADO DE GRUPOS");
        Button detalle = new Button("VER DETALLE DE EQUIPO");
        exportarGrupo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                ventanaExportar(jugadores);
            }
        });
        detalle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                ventanaDetalle(jugadores);
            }
        });
        contenedorBotones.getChildren().addAll(exportarGrupo, detalle);
        contenedorBotones.setAlignment(Pos.CENTER);
        contenedorBotones.setSpacing(20);
        contenedor1.getChildren().addAll(fechaHora, stage, stadium, ciudad);
        contenedor2.getChildren().addAll(eqLocal);
        contenedor3.getChildren().addAll(finalPartido, goles);
        contenedor3.setAlignment(Pos.TOP_CENTER);

        contenedor4.getChildren().add(eqVisit);
        contenedorDatos.setSpacing(50);
        contenedorGeneralDatos.getChildren().addAll(contenedorDatos,contenedorBotones);
        contenedorDatos.getChildren().addAll(contenedor1, contenedor2, contenedor3, contenedor4);
        contenedorDatos.setPadding(new Insets(10));
        
        
        
        
        
        
    }
    private void ventanaExportar(ArrayList<Jugador> jugadores) {
        Stage stage = new Stage();
        Button aceptar = new Button("Aceptar");
        Button cancelar = new Button("Cancelar");
        HBox botones = new HBox(aceptar, cancelar);
        Label msg = new Label("¿Estás seguro que desea exportar el grupo de jugadores seleccionados?");
        botones.setSpacing(15);
        botones.setAlignment(Pos.TOP_RIGHT);
        aceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("exportResultGroup.ser"))) {
                    out.writeObject(jugadores);
                    out.flush();
                    msg.setText("Se ha generado el archivo correctamente");
                } catch (FileNotFoundException ex) {
                   msg.setText("Lo sentimos, no se pudo guardar");
                } catch (IOException ex) {
                    msg.setText("Lo sentimos, no se pudo guardar");
                }
            }
        });
        cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                stage.close();
            }
        });
        VBox root = new VBox(msg, botones);
        root.setSpacing(30);
        root.setPadding(new Insets(20, 10, 20, 10));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    private void ventanaDetalle(ArrayList<Jugador> jugadores) {
        Stage stage = new Stage();
        FlowPane root = new FlowPane();
        Label lblTitulo = new Label("Detalle de equipos");
        lblTitulo.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        VBox titulo = new VBox(lblTitulo);
        titulo.setAlignment(Pos.CENTER);
        root.getChildren().add(titulo);
        
        
        
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    private ArrayList<Jugador> equiposSeleccionados(Partido partidoSeleccionado) {
        String match = partidoSeleccionado.getMatchID();
        String round = partidoSeleccionado.getRoundID();
        ArrayList<Jugador> jugadores= new ArrayList<>();
        for(Jugador r:listJugadores){
            if(match.equals(r.getMatchId())){
                jugadores.add(r);
                
                
            }
            
        }
        

        return jugadores;
    }
}