package com.mycompany.poroyecto_prueba;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;

/**
 * Clase Proyecto2P_G7 que pertenece al paquete com.mycompany.poroyecto_prueba y
 * extiende de la clase abstracta Application
 *
 * @author Michael Estrada
 * @author Carlos Tingo
 */
public class Proyecto2P_G7 extends Application {
    public static String pathImg="src/main/resources/images/";

    private static Scene scene;
    
    /**
     * Método sobreescrito que permite abrir la ventana la cual recibe como parámetro
     * @param s Ventana que se abre
     * @throws IOException Excepción que se desea lanzar a otro método que lo implemente
     */
    @Override
    public void start(Stage s) throws IOException {
        FXMLLoader fxmllowder = new FXMLLoader(Proyecto2P_G7.class.getResource("Principal.fxml"));
        Parent root = fxmllowder.load();
        scene = new Scene(root, 800, 480);
        s.setScene(scene);
        s.show();
    }
    
    /**
     * Método principal
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

}
