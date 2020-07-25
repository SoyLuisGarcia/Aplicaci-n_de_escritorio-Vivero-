package com.bzmliy.Vivero.View;

import com.bzmliy.Vivero.Main;
import com.bzmliy.Vivero.Model.Conexion;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;

public class VentanaAgregar {
	Main main;
	Conexion conn;
	int id2;
    @FXML
    private Button agregar;
    @FXML
    private DatePicker fecha;

    @FXML
    void hacerClickAgregar() {
    	conn.agregarRegistroRiego(id2,String.valueOf(fecha.getValue()));
    	Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Agregado");
		alert.setHeaderText(null);
		alert.setContentText("Registro a sido agregado");
		alert.showAndWait();
    }
    @FXML
    void hacerClickBack() {
    	main.abrirVentanaRegistroRiego();
    }
	
	public void setMain(Main main,Conexion conn,int id2) {
		this.main = main;
		this.conn = conn;
		this.id2=id2;
	}
}
