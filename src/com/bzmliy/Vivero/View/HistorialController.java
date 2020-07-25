package com.bzmliy.Vivero.View;

import java.sql.ResultSet;
import java.util.Optional;

import com.bzmliy.Vivero.Main;
import com.bzmliy.Vivero.Model.Conexion;
import com.bzmliy.Vivero.Model.TablaHistorial;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HistorialController {
	private Main main;
	private Conexion conn;
	private Stage stage;
	private String id_Prod;
	
	@FXML private TableView<TablaHistorial> tabla;
	@FXML private TableColumn<TablaHistorial, String> id;
    @FXML private TableColumn<TablaHistorial, String> fecha;
    @FXML private TableColumn<TablaHistorial, String> imagen;
    
    @FXML private TextField id_producto;
    
    
    private void crearTabla() {
    	ObservableList<TablaHistorial> lista = FXCollections.observableArrayList();
    	ResultSet rs = conn.obtenerHistorial(id_Prod);
    	try {
    		while(rs.next()) {
    			lista.add(new TablaHistorial(rs.getString(1),rs.getString(3),rs.getString(4)));
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
		}
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		imagen.setCellValueFactory(new PropertyValueFactory<>("imagen"));
		tabla.setItems(lista);
    }
    
    @FXML
    void agregarClick() {
    	main.openNuevoHistorial(stage, id_Prod);
    	crearTabla();
    }
    
    @FXML
    void borrarClick(){
    	if(id_producto.getText().isEmpty()) {
    		Alert aler = new Alert(AlertType.INFORMATION);
	    	aler.setTitle("Informacion");
	    	aler.setHeaderText(null);
	    	aler.setContentText("Eliga un ID!");
	    	aler.showAndWait();
    	} else if(!conn.validarIdHistorial(id_Prod, id_producto.getText())) {
    		Alert aler = new Alert(AlertType.ERROR);
	    	aler.setTitle("Error");
	    	aler.setHeaderText(null);
	    	aler.setContentText("ID no valido!");
	    	aler.showAndWait();
    	} else {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("Confirmacion");
    		alert.setHeaderText("Elige una respuesta");
    		alert.setContentText("¿Estas seguro de eliminar este historial?");

    		Optional<ButtonType> result = alert.showAndWait();
    		if (result.get() == ButtonType.OK){
    			Alert aler = new Alert(AlertType.INFORMATION);
    	    	aler.setTitle("Informacion");
    	    	aler.setHeaderText(null);
    	    	aler.setContentText("Se ha eliminado el historial!");
    	    	aler.showAndWait();
    	    	conn.borrarHistorial(id_producto.getText());
    	    	crearTabla();
    		} else {
    			Alert aler = new Alert(AlertType.INFORMATION);
    	    	aler.setTitle("Informacion");
    	    	aler.setHeaderText(null);
    	    	aler.setContentText("No se ha eliminado el historial!");
    	    	aler.showAndWait();
    		}
    	}
    }
    
    @FXML
    void actualizarClick() {
    	if(id_producto.getText().isEmpty()) {
    		Alert aler = new Alert(AlertType.INFORMATION);
	    	aler.setTitle("Informacion");
	    	aler.setHeaderText(null);
	    	aler.setContentText("Eliga un ID!");
	    	aler.showAndWait();
    	} else if(!conn.validarIdHistorial(id_Prod, id_producto.getText())) {
    		Alert aler = new Alert(AlertType.ERROR);
	    	aler.setTitle("Error");
	    	aler.setHeaderText(null);
	    	aler.setContentText("ID no valido!");
	    	aler.showAndWait();
    	} else {
    		main.openActualizarHistorial(stage, id_producto.getText());
    		crearTabla();
    	}
    }
    
    @FXML
    void regrasarClick() {
    	stage.close();
    }
	
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void setId_Prod(String id_Prod) {
		this.id_Prod = id_Prod;
	}
	
	public void setConn(Conexion conn, Main main) {
		this.conn = conn;
		this.main = main;
		crearTabla();
	}
	
}
