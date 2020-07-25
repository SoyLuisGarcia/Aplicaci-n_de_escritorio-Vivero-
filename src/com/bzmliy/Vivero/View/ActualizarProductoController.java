package com.bzmliy.Vivero.View;



import java.sql.ResultSet;

import com.bzmliy.Vivero.Model.Conexion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ActualizarProductoController {
	private Conexion conn;
	private Stage stage;
	private String id;
	
	@FXML private TextField nombre;
	@FXML private ComboBox<String> tipo;
    @FXML private TextField condicion;
    @FXML private DatePicker ingreso;
    @FXML private CheckBox lunes;
    @FXML private CheckBox martes;
    @FXML private CheckBox miercoles;
    @FXML private CheckBox jueves;
    @FXML private CheckBox viernes;
    @FXML private CheckBox sabado;
    @FXML private CheckBox domingo;
    @FXML private TextField fecha2;
    @FXML private TextField topo2;

    @FXML
    void aceptarClick() {
    	if(nombre.getText().isEmpty() || topo2.getText().isEmpty() || condicion.getText().isEmpty() || fecha2.getText().isEmpty()) {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Alerta");
			alert.setHeaderText("No actualizado");
			alert.setContentText("Hay campos vacios");
			alert.showAndWait();
    	} else {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Alerta");
			alert.setHeaderText("Actualizado");
			alert.setContentText("No ubieron problemas al actualizar");
			alert.showAndWait();
    		conn.actualizarProducto(id, nombre.getText(), topo2.getText(), condicion.getText(), fecha2.getText());
			conn.borrarDiasRiego(id);
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
    	}
    }

    @FXML
    void cancelarClick() {
    	stage.close();
    }
    
    private void llenarDatos() {
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
    	try {
    		ResultSet rs = conn.obtenerProducto();
    		while(rs.next()) {
    			if(rs.getString(1).compareTo(id)==0) {
    				nombre.setText(rs.getString(2));
    				tipo.setValue(rs.getString(7));
    				topo2.setText(conn.obtenerIdTipo(tipo.getValue()));
    				condicion.setText(rs.getString(4));
    				fecha2.setText(rs.getString(5));
    			}
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	try {
    		ResultSet rs = conn.obtenerDiasRiego(id);
    		while(rs.next()) {
    			switch(rs.getString(4)) {
    				case "Lunes":
    					lunes.setSelected(true);
    				break;
    				case "Martes":
    					martes.setSelected(true);
    				break;
    				case "Miercoles":
    					miercoles.setSelected(true);
    				break;
    				case "Jueves":
    					jueves.setSelected(true);
    				break;
    				case "Viernes":
    					viernes.setSelected(true);
    				break;
    				case "Sabado":
    					sabado.setSelected(true);
    				break;
    				case "Domingo":
    					domingo.setSelected(true);
    				break;
    			}
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
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
		llenarDatos();
	}
    
    public void setId(String id) {
		this.id = id;
	}
    
    public void setStage(Stage stage) {
    	this.stage = stage;
    }
    
    
}
