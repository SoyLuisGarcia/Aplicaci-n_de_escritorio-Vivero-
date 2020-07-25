package com.bzmliy.Vivero.View;


import java.sql.ResultSet;
import java.util.Optional;

import com.bzmliy.Vivero.Model.Conexion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NuevoProductoController {
	Conexion conn; 
	
	@FXML private TextField nombre;
	@FXML private ComboBox<String> tipo;
    @FXML private TextField condicion;
    @FXML private DatePicker ingreso;
    @FXML private TextField fecha2;
    @FXML private CheckBox lunes;
    @FXML private CheckBox martes;
    @FXML private CheckBox miercoles;
    @FXML private CheckBox jueves;
    @FXML private CheckBox viernes;
    @FXML private CheckBox sabado;
    @FXML private CheckBox domingo;
    @FXML private TextField topo2;
    
	private Stage stage;
	
	@FXML
	void aceptarClick() {
		if(nombre.getText().isEmpty() || topo2.getText().isEmpty() || condicion.getText().isEmpty() || fecha2.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Campos vacios");
			alert.setContentText("Favor de llenar todos los campos");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Contestar");
			alert.setHeaderText("Confirma la aceptacion");
			alert.setContentText("Esta seguro de agregar el producto?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setTitle("Information");
				alert2.setHeaderText(null);
				alert2.setContentText("Se ha creado correctamente");
				alert2.showAndWait();
				
				conn.agregarProductoNuevo(nombre.getText(), topo2.getText(), condicion.getText(), fecha2.getText());
				String id = conn.obtenerIdUltipoProd();
				if(lunes.isSelected()) 
					conn.agregarDiaRiego(id, 1);
				if(martes.isSelected()) 
					conn.agregarDiaRiego(id, 2);
				if(miercoles.isSelected()) 
					conn.agregarDiaRiego(id, 3);
				if(jueves.isSelected()) 
					conn.agregarDiaRiego(id, 4);
				if(viernes.isSelected()) 
					conn.agregarDiaRiego(id, 5);
				if(sabado.isSelected()) 
					conn.agregarDiaRiego(id, 6);
				if(domingo.isSelected()) 
					conn.agregarDiaRiego(id, 7);
				stage.close();
			} else {
				Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setTitle("Information");
				alert2.setHeaderText(null);
				alert2.setContentText("Se ha cancelado correctamente");
				alert2.showAndWait();
			}
		}
		
		
	}
	
	@FXML
	void cancelarClick() {
		stage.close();
	}
	
	@FXML
    void fechaClick() {
    	if (ingreso.getValue() == null) {
    	} else {
    		fecha2.setText(String.valueOf(ingreso.getValue()));
    	}
    }
	
	@FXML
    void tipoClick() {
    	if (tipo.getValue() == null) {
    		
    	} else {
    		topo2.setText(conn.obtenerIdTipo(tipo.getValue()));
    	}
    }
	
	public void setConn(Conexion conn) {
		this.conn = conn;
		ObservableList<String> lista = FXCollections.observableArrayList();
    	try {
    		ResultSet rs = conn.obtenerTipos();
    		while(rs.next()) {
    			lista.add(rs.getString(2));
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	tipo.setItems(lista);
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	
}
