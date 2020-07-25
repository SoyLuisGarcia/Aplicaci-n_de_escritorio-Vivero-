package com.bzmliy.Vivero.View;

import com.bzmliy.Vivero.Main;
import com.bzmliy.Vivero.Model.Conexion;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class VentanaEliminar {
	Main main;
	Conexion conn;
	int id2;
    @FXML
    private Button back;
    @FXML
    private Button eliminar;
    @FXML
    private TextField id;
    
    @FXML
    void hacerClickBack() {
    	main.abrirVentanaRegistroRiego();
    }

    @FXML
    void hacerClickEliminar() {
    	conn.eliminarRegistroRiego(Integer.valueOf(id.getText()));

    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Eliminado");
			alert.setHeaderText(null);
			alert.setContentText("Registro a sido eliminado");
			alert.showAndWait();
    }
    
    public void setMain(Main main,Conexion conn,int id2) {
		this.main = main;
		this.conn = conn;
		this.id2=id2;          
	}
}
