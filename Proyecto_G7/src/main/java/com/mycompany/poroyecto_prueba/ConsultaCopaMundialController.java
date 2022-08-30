/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.poroyecto_prueba;

import com.mycompany.model.CopaMundial;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import static javafx.scene.text.Font.font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * Clase de controlador FXML ConsultaCopaMundialController que pertenece al
 * paquete com.mycompany.poroyecto_prueba e implementa Initializable
 *
 * @author Michael Estrada
 * @author Carlos Tingo
 */
public class ConsultaCopaMundialController implements Initializable {

    @FXML
    private VBox root;

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
        Label titulo = new Label("Consulta Histórica de Copas Mundiales");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        TextField anio = new TextField("Ingrese un año");
        VBox vbContenido = new VBox();
        VBox vbDatos = new VBox();
        HBox contenidos = new HBox();

        Button consultar = new Button("CONSULTAR");
        HBox buscador = new HBox(new Label("Año: "), anio, consultar);

        consultar.setOnAction((ActionEvent t) -> {
            consultar(anio, vbContenido, vbDatos, contenidos);
        });

        buscador.setAlignment(Pos.CENTER);
        buscador.setSpacing(30);
        contenidos.setSpacing(150);
        root.getChildren().addAll(titulo, buscador, contenidos);
    }

    /**
     * Método que sirve para obtener los resultados de la búsqueda del año que
     * ingrese el usuario
     *
     * @param txtAnio El año ingresado desde la ventana y el que se buscará
     * @param vbContenido VBox donde contendrá las posiciones de ganadores de
     * ese año
     * @param vbDatos VBox donde contendrá los datos de ese partido en dicho año
     * consultado
     * @param contenidos Contenedor donde estará toda la información de
     * vbContenido y vbDatos
     */
    public void consultar(TextField txtAnio, VBox vbContenido, VBox vbDatos, HBox contenidos) {

        ArrayList<CopaMundial> copasMundiales = CopaMundial.listaCopasMundiales("WorldCups.csv");
        int anio = 0;
        CopaMundial cm = null;
        try {

            anio = Integer.valueOf(txtAnio.getText().trim());
            for (CopaMundial cp : copasMundiales) {
                if (anio == cp.getYear()) {
                    cm = cp;
                }
            }
            if (cm != null) {
                vbContenido.getChildren().clear();
                vbDatos.getChildren().clear();
                contenidos.getChildren().clear();
                mostrarInformacion(cm, vbContenido, vbDatos, contenidos, copasMundiales, anio);
            } else {
                vbContenido.getChildren().clear();
                vbDatos.getChildren().clear();
                contenidos.getChildren().clear();
                contenidos.getChildren().addAll(new Label("No se ha encontrado el año, vuelva a ingresar otro año"));

            }
        } catch (NumberFormatException nfe) {
            vbContenido.getChildren().clear();
            vbDatos.getChildren().clear();
            contenidos.getChildren().clear();
            contenidos.getChildren().addAll(new Label("Debe colocar el año correctamente!"));
        }

    }

    /**
     * Método donde se rellena la información dentro de los contenedores
     * dependiendo de la copa mundial elegido
     *
     * @param elegido CopaMundial elegido, extraído por el año de consulta
     * @param vbContenido VBox donde contendrá las posiciones de ganadores de
     * ese año
     * @param vbDatos VBox donde contendrá los datos de ese partido en dicho año
     * consultado
     * @param contenidos Contenedor donde estará toda la información de
     * vbContenido y vbDatos
     * @param copasMundiales ArrayList de las copas mundiales históricas
     * @param anio año que se consultó
     */
    public void mostrarInformacion(CopaMundial elegido, VBox vbContenido, VBox vbDatos, HBox contenidos, ArrayList<CopaMundial> copasMundiales, int anio) {
        ArrayList<String> posiciones = new ArrayList<>();
        posiciones.add(elegido.getWinner());
        posiciones.add(elegido.getRunnersUp());
        posiciones.add(elegido.getThird());
        posiciones.add(elegido.getFourth());

        GridPane ganadores = new GridPane();

        ganadores.setVgap(20);
        ganadores.setHgap(40);
        ganadores.addColumn(0, new Label("Ganador"), new Label("Segundo"), new Label("Tercero"), new Label("Cuarto"));
        ArrayList<ImageView> imagenes = new ArrayList<>();
        for (String pos : posiciones) {
            ImageView imgv = null;
            FileInputStream fi = null;
            try {
                fi = new FileInputStream(Proyecto2P_G7.pathImg + pos + ".jpg");
                Image i = new Image(fi);
                imgv = new ImageView(i);
                imagenes.add(imgv);

            } catch (FileNotFoundException fnf) {
                try {
                    fi = new FileInputStream(Proyecto2P_G7.pathImg + "StandardImg.jpg");
                    Image i = new Image(fi);
                    imgv = new ImageView(i);
                    imagenes.add(imgv);
                } catch (FileNotFoundException fnf2) {
                    vbContenido.getChildren().clear();
                    vbDatos.getChildren().clear();
                    vbContenido.getChildren().add(new Label("Hubo un error al colocar las imágenes"));
                }
            }
            imgv.setFitHeight(17);
            imgv.setFitWidth(30);
        }

        ganadores.addColumn(1,
                new HBox(imagenes.get(0), new Label(elegido.getWinner())),
                new HBox(imagenes.get(1), new Label(elegido.getRunnersUp())),
                new HBox(imagenes.get(2), new Label(elegido.getThird())),
                new HBox(imagenes.get(3), new Label(elegido.getFourth()))
        );

        ArrayList<CopaMundial> copasSeleccionadas = new ArrayList<>();

        for (CopaMundial cm : copasMundiales) {
            if (cm.getYear() <= anio) {
                copasSeleccionadas.add(cm);
            }
        }
        int contWinner = 0;
        int contRunnersUp = 0;
        int contThird = 0;
        int contFourth = 0;
        HBox copasGanadasWinner = new HBox();
        HBox copasGanadasRunnersUp = new HBox();
        HBox copasGanadasThird = new HBox();
        HBox copasGanadasFourth = new HBox();

        for (CopaMundial cs : copasSeleccionadas) {
            if (cs.getWinner().equalsIgnoreCase(elegido.getWinner())) {
                contWinner += 1;
            } else if (cs.getWinner().equalsIgnoreCase(elegido.getRunnersUp())) {
                contRunnersUp += 1;
            } else if (cs.getWinner().equalsIgnoreCase(elegido.getThird())) {
                contThird += 1;
            } else if (cs.getWinner().equalsIgnoreCase(elegido.getFourth())) {
                contFourth += 1;
            }
        }

        ImageView imgCupWinner = null;
        if (contWinner != 0) {
            for (int i = 0; i < contWinner; i++) {
                try ( FileInputStream fi = new FileInputStream(Proyecto2P_G7.pathImg + "copa.png")) {
                    Image img1 = new Image(fi);
                    imgCupWinner = new ImageView(img1);
                    imgCupWinner.setFitHeight(20);
                    imgCupWinner.setFitWidth(20);
                } catch (IOException io) {
                    vbContenido.getChildren().clear();
                    vbDatos.getChildren().clear();
                    vbContenido.getChildren().add(new Label("Hubo un error al colocar las imágenes"));
                }
                copasGanadasWinner.getChildren().add(imgCupWinner);

            }
        }

        ImageView imgCupRunnersUp = null;
        if (contRunnersUp != 0) {
            for (int i = 0; i < contRunnersUp; i++) {
                try ( FileInputStream fi = new FileInputStream(Proyecto2P_G7.pathImg + "copa.png")) {
                    Image img2 = new Image(fi);
                    imgCupRunnersUp = new ImageView(img2);
                    imgCupRunnersUp.setFitHeight(20);
                    imgCupRunnersUp.setFitWidth(20);
                } catch (IOException io) {
                    vbContenido.getChildren().clear();
                    vbDatos.getChildren().clear();
                    vbContenido.getChildren().add(new Label("Hubo un error al colocar las imágenes"));
                }
                copasGanadasRunnersUp.getChildren().add(imgCupRunnersUp);

            }
        }

        ImageView imgCupThird = null;
        if (contThird != 0) {
            for (int i = 0; i < contThird; i++) {
                try ( FileInputStream fi = new FileInputStream(Proyecto2P_G7.pathImg + "copa.png")) {
                    Image img3 = new Image(fi);
                    imgCupThird = new ImageView(img3);
                    imgCupThird.setFitHeight(20);
                    imgCupThird.setFitWidth(20);
                } catch (IOException io) {
                    vbContenido.getChildren().clear();
                    vbDatos.getChildren().clear();
                    vbContenido.getChildren().add(new Label("Hubo un error al colocar las imágenes"));
                }
                copasGanadasThird.getChildren().add(imgCupThird);

            }
        }

        ImageView imgCupFourth = null;
        if (contFourth != 0) {
            for (int i = 0; i < contFourth; i++) {
                try ( FileInputStream fi = new FileInputStream(Proyecto2P_G7.pathImg + "copa.png")) {
                    Image img4 = new Image(fi);
                    imgCupFourth = new ImageView(img4);
                    imgCupFourth.setFitHeight(20);
                    imgCupFourth.setFitWidth(20);
                } catch (IOException io) {
                    vbContenido.getChildren().clear();
                    vbDatos.getChildren().clear();
                    vbContenido.getChildren().add(new Label("Hubo un error al colocar las imágenes"));
                }
                copasGanadasFourth.getChildren().add(imgCupFourth);

            }
        }

        ganadores.addColumn(2,
                copasGanadasWinner,
                copasGanadasRunnersUp,
                copasGanadasThird,
                copasGanadasFourth
        );

        Label lbTitleDatos = new Label("Datos generales");
        lbTitleDatos.setFont(new Font(16));
        Label lbPremios = new Label("Premios");
        lbPremios.setFont(new Font(16));
        VBox datos = new VBox(
                new Label("Goles anotados: " + String.valueOf(elegido.getGoalsScored())),
                new Label("Equipos: " + String.valueOf(elegido.getQualifiedTeams())),
                new Label("Partidos Jugados: " + String.valueOf(elegido.getMatchesPlayed())),
                new Label("Partidos Jugados: " + elegido.getAttendance())
        );
        datos.setSpacing(24);
        vbDatos.getChildren().setAll(lbTitleDatos, new Separator(), datos);
        vbContenido.getChildren().setAll(lbPremios, new Separator(), ganadores);
        contenidos.getChildren().addAll(vbContenido, vbDatos);

    }

}
