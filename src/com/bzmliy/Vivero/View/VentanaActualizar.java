package com.bzmliy.Vivero.View;

import com.bzmliy.Vivero.Main;
import com.bzmliy.Vivero.Model.Conexion;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class VentanaActualizar {
	Main main;
	Conexion conn;
	int id2;
    @FXML
    private Button back;
    @FXML
    private DatePicker fecha;
    @FXML
    private Button actualizar;
    @FXML
    private TextField id;
    
    @FXML
    void hacerClickActualizar() {
    	conn.modificarRegistroRiego(Integer.valueOf(id.getText()),id2,String.valueOf(fecha.getValue()));
    	Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Actualizado");
		alert.setHeaderText(null);
		alert.setContentText("Registro a sido modificado");
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
