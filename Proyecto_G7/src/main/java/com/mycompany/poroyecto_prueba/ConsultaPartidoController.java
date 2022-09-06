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
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
//import java.util.Calendar;
//import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Clase de controlador FXML ConsultaPartidoController que pertenece al paquete
 * com.mycompany.poroyecto_prueba e implementa Initializable
 *
 * @author Michael Estrada
 * @author Carlos Tingo
 */
public class ConsultaPartidoController implements Initializable {

    private final ArrayList<Partido> listPartido = Partido.listaPartido("WorldCupMatchesBrasil2014.csv");
    private final ArrayList<Jugador> listJugadores = Jugador.listaJugadores("WorldCupPlayersBrasil2014.csv");
    static int contador;
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
                    Eq1Cmb.getItems().clear();
                    Eq2Cmb.getItems().clear();
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
                    Collections.sort(Eq1Cmb.getItems());
                    Eq2Cmb.getItems().addAll(l.getAwayTN());
                    Collections.sort(Eq2Cmb.getItems());

                }

            }

        }

    }

    /**
     * Este metodo se encarga de verificar los equipos seleccionados para
     * comparar conforme a los datos y para poder cargar los cuadros despues
     *
     * @param fase recibe el ComboBox que contiene fases
     * @param eq1 recibe ComboBox que contiene el equipo1
     * @param eq2 recibe ComboBox que contiene el equipo2
     */
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

    /**
     * Este metodo es encargado de llenar contenido a los cuadros
     *
     * @param partidoSeleccionado recibe parametro de tipo Partido para poder
     * realizar la comparacion
     */
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
        contenedorBotones.getChildren().clear();
        contenedorBotones.getChildren().addAll(exportarGrupo, detalle);
        contenedorBotones.setAlignment(Pos.CENTER);
        contenedorBotones.setSpacing(20);
        contenedor1.getChildren().addAll(fechaHora, stage, stadium, ciudad);
        contenedor2.getChildren().addAll(eqLocal);
        contenedor3.getChildren().addAll(finalPartido, goles);
        contenedor3.setAlignment(Pos.TOP_CENTER);

        contenedor4.getChildren().add(eqVisit);
        contenedorDatos.setSpacing(50);
        contenedorGeneralDatos.getChildren().addAll(contenedorDatos, contenedorBotones);
        contenedorDatos.getChildren().addAll(contenedor1, contenedor2, contenedor3, contenedor4);
        contenedorDatos.setPadding(new Insets(10));

    }

    /**
     * Este metodo carga una ventana el cual da las opciones de exportar los
     * datos
     *
     * @param jugadores recibe un ArrayList de tipo Jugador para poder cargar
     * los datos de los jugadores
     */
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

        VBox root = new VBox();
        root.setPrefHeight(480);
        root.setPrefWidth(640);

        HBox contenedorLocal = new HBox();
        Label equiLocal = new Label();
        equiLocal.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        contenedorLocal.getChildren().add(equiLocal);
        FlowPane jugadoresEquipoLocal = new FlowPane();
        jugadoresEquipoLocal.setHgap(10);

        Label equiVisit = new Label();
        HBox contenedorVisit = new HBox();
        equiVisit.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        contenedorVisit.getChildren().add(equiVisit);

        FlowPane jugadoresEquipoVisit = new FlowPane();
        jugadoresEquipoVisit.setHgap(10);
        Label lblTitulo = new Label("Detalle de equipos");
        lblTitulo.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        VBox titulo = new VBox(lblTitulo);
        titulo.setAlignment(Pos.CENTER);
        root.getChildren().add(titulo);

        root.getChildren().add(contenedorLocal);
        root.getChildren().add(jugadoresEquipoLocal);
        root.getChildren().add(contenedorVisit);
        root.getChildren().add(jugadoresEquipoVisit);
        ArrayList<Jugador> jugadoresLocal = null;
        ArrayList<String> equipoParticipante = new ArrayList<>();
        for (Jugador r : jugadores) {

            if (!equipoParticipante.contains(r.getInciales())) {
                equipoParticipante.add(r.getInciales());

            }

        }
        equiLocal.setText(equipoParticipante.get(0));
        equiVisit.setText(equipoParticipante.get(1));

        //Cargar imagenes equipo local
        ImageView imgvLocal = null;
        Label lblImgNoEncontrada = null;
        FileInputStream fi = null;
        for (Jugador r : jugadores) {
            if (r.getInciales().equals(equipoParticipante.get(0))) {

                VBox contenedorJLocal = new VBox();

                try {
                    fi = new FileInputStream(Proyecto2P_G7.pathImg + r.getNombreJug() + "_" + r.getInciales() + ".jpg");
                    Image i = new Image(fi);
                    imgvLocal = new ImageView(i);
                    contenedorJLocal.getChildren().addAll(imgvLocal, new Label(r.getNombreJug()));
                    jugadoresEquipoLocal.getChildren().add(contenedorJLocal);
                    
                    imgvLocal.setFitHeight(80);
                    imgvLocal.setFitWidth(120);

                    contenedorJLocal.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
//                    System.out.println("");
                            String nomJugador = r.getNombreJug();
                            String iniciales = r.getInciales();
                            String numCamisa = r.getNumeroCamiseta();
                            String tecnico = r.getEntrenador();
                            crearNuevaVentana(Proyecto2P_G7.pathImg + nomJugador + "_" + r.getInciales() + ".jpg", Proyecto2P_G7.pathImg + "StandardImg.jpg", r.getNombreJug(), iniciales, numCamisa, tecnico);

                        }
                    });
                    //cargarImagenesHilo(r,contenedorJLocal,imgvLocal,new Label(r.getNombreJug()),jugadoresEquipoLocal);
                } catch (IOException ioe) {
                    lblImgNoEncontrada = new Label();
                    try {
                        fi = new FileInputStream(Proyecto2P_G7.pathImg + "StandardImg.jpg");
                        Image i = new Image(fi);
                        imgvLocal = new ImageView(i);
                    } catch (FileNotFoundException fnf2) {

                    }
                }

            }
        }
        //Visitante

        ImageView imgvVisit = null;
        Label lblimgne = null;
        FileInputStream fiv = null;
        for (Jugador r : jugadores) {
            if (r.getInciales().equals(equipoParticipante.get(1))) {
                VBox contenedorJVisit = new VBox();

                try {
                    fiv = new FileInputStream(Proyecto2P_G7.pathImg + r.getNombreJug() + "_" + r.getInciales() + ".jpg");
                    Image i = new Image(fiv);
                    imgvVisit = new ImageView(i);
                    contenedorJVisit.getChildren().addAll(imgvVisit, new Label(r.getNombreJug()));
                    jugadoresEquipoVisit.getChildren().add(contenedorJVisit);
                    imgvVisit.setFitHeight(80);
                    imgvVisit.setFitWidth(120);
                    contenedorJVisit.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
//                    System.out.println("");
                            String nomJugador = r.getNombreJug();
                            String iniciales = r.getInciales();
                            String numCamisa = r.getNumeroCamiseta();
                            String tecnico = r.getEntrenador();
                            crearNuevaVentana(Proyecto2P_G7.pathImg + nomJugador + "_" + r.getInciales() + ".jpg", Proyecto2P_G7.pathImg + "StandardImg.jpg", r.getNombreJug(), iniciales, numCamisa, tecnico);

                        }
                    });
                } catch (IOException ioe) {
                    lblImgNoEncontrada = new Label();
                    try {
                        fiv = new FileInputStream(Proyecto2P_G7.pathImg + "StandardImg.jpg");
                        Image i = new Image(fiv);
                        imgvVisit = new ImageView(i);
                    } catch (FileNotFoundException fnf2) {

                    }
                }

            }
        }
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    private void cargarImagenesHilo(Jugador jugador, VBox equipo, ImageView img, Label lbl, FlowPane contenedor) {
        
        
        Random r1 = new Random();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    FileInputStream fiv = new FileInputStream(Proyecto2P_G7.pathImg + jugador.getNombreJug() + "_" + jugador.getInciales() + ".jpg");
                    Image i = new Image(fiv);
                    img.setImage(i);
                    equipo.getChildren().addAll(img, new Label(jugador.getNombreJug()));
                    contenedor.getChildren().add(equipo);

                    Thread.sleep(r1.nextInt(15000) + 5000);

                    img.setFitHeight(80);
                    img.setFitWidth(120);

                } catch (IOException ioe) {

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

        });

    }

    /**
     * Este metodo se encarga de cargar un ArrayList de tipo Jugador para poder
     * trabajar con la nueva ventana
     *
     * @param partidoSeleccionado recibe parametro de tipo Partido
     * @return
     */
    private ArrayList<Jugador> equiposSeleccionados(Partido partidoSeleccionado) {
        String match = partidoSeleccionado.getMatchID();
        String round = partidoSeleccionado.getRoundID();
        ArrayList<Jugador> jugadores = new ArrayList<>();
        for (Jugador r : listJugadores) {
            if (match.equals(r.getMatchId())) {
                jugadores.add(r);

            }

        }

        return jugadores;
    }
    
    /**
     * este metodo carga una ventana para mostrar el jugador junto a su imagen y los segundos que se cerrará
     * @param ruta ruta de imagen
     * @param rutaStandard ruta de imagen standard 
     * @param nombre nombre del jugador
     * @param iniciales iniciales del equipo
     * @param numCamisa numero de camisa
     * @param tecnico nombre del tecnico
     */
    private void crearNuevaVentana(String ruta, String rutaStandard, String nombre, String iniciales, String numCamisa, String tecnico) {

        Stage s = new Stage();

        ImageView imageView = null;
        try ( FileInputStream fis = new FileInputStream(ruta)) {

            Image img = new Image(fis);
            imageView = new ImageView(img);

        } catch (IOException io) {
            try ( FileInputStream fi = new FileInputStream(rutaStandard)) {
                Image img = new Image(fi);
                imageView = new ImageView(img);

            } catch (IOException ioe) {

            }

        }
        imageView.setFitHeight(80);
        imageView.setFitWidth(120);

        Label lblNombre = new Label(nombre);
        lblNombre.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        Label lbIniciales = new Label(iniciales);
        Label lbCamisa = new Label("CAMISETA NRO. " + numCamisa);
        Label lbTecnico = new Label("DIR. TEC. " + tecnico);
        HBox contenedorContador = new HBox();
        Label lcontador = new Label();

        VBox contenedor2 = new VBox();
        contenedor2.setAlignment(Pos.CENTER);
        contenedor2.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
        contenedor2.getChildren().addAll(lbIniciales, lbCamisa, lbTecnico);

        contenedorContador.getChildren().addAll(new Label("Mostrando por "), lcontador, new Label("segundos"));
        contenedorContador.setAlignment(Pos.CENTER);

        Thread t;
        t = new Thread(() -> {

            for (int i = 0; i <= 10; i++) {
                crearThreadNuevaVentana(lcontador, String.valueOf(i), s);

                contador = i;

                try {
                    Thread.sleep(1000);

                } catch (InterruptedException ex) {
                }

            }

        });

        t.setDaemon(true);
        t.start();

        VBox root = new VBox(lblNombre, imageView, contenedor2, contenedorContador);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPadding(new Insets(30));

        Scene scene = new Scene(root, 300, 300);
        s.setScene(scene);
        s.show();

    }
    /**
     * Este metodo es encargado de crear la nueva ventana 
     * @param l etiqueta que mostrará de contador
     * @param msg mensaje contador
     * @param s escena que se cerrará
     */
    private void crearThreadNuevaVentana(Label l, String msg, Stage s) {
        Platform.runLater(() -> {
            l.setText(msg);
            if (Integer.valueOf(msg) == 10) {
                s.close();
            }
        });

    }

}
