package com.bzmliy.Vivero.View;

import java.sql.ResultSet;
import java.util.Optional;

import com.bzmliy.Vivero.Main;
import com.bzmliy.Vivero.Model.Conexion;
import com.bzmliy.Vivero.Model.TablaProducto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VerProductoController {
	@FXML private TableView<TablaProducto> tabla;
    @FXML private TableColumn<TablaProducto, String> nombre;
    ObservableList<TablaProducto> lista = FXCollections.observableArrayList();
    
    @FXML private Label nombreProd;
    @FXML private Label tipo;
    @FXML private Label condicion;
    @FXML private Label fecha;
    
	private Conexion conn;
	private Main main;
	private Stage stage;
	private String id;
	
	@FXML private BorderPane border;

	  
	@FXML
	void salirClick() {
		stage.close();
	}
	
	@FXML
	void historialClick() {
		main.openHistorial(stage, id);
	}


	
	@FXML
	void eliminarClick() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmaccion");
		alert.setHeaderText(null);
		alert.setContentText("¿Esta seguro de borrar el producto?");

		Optional<ButtonType> result = alert.showAndWait();            // agregar la eliminacion
		if (result.get() == ButtonType.OK){
			
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Information");
			alerta.setHeaderText(null);
			alerta.setContentText("Se ha eliminado correctamente");
			alerta.showAndWait();
			conn.borrarProducto(id);
			stage.close();
			
		} else {
			
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Information");
			alerta.setHeaderText(null);
			alerta.setContentText("No se ha eliminado");

			alerta.showAndWait();
			
		}
	}

	@FXML
	void actualizarClik() {
		main.openActualizarProductos(stage, id);
		rellenarDatos();
	}
	
	private void rellenarDatos() {
		lista.clear();
		try {
			ResultSet rs = conn.obtenerDiasRiego(id);
			while(rs.next()) {
				lista.add(new TablaProducto("", rs.getString(4), ""));
			}
			nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
			tabla.setItems(lista);
		}catch(Exception e) {
			
		}
		
		try {
			ResultSet rs = conn.obtenerProducto();
			while(rs.next()) {
				if(id.compareTo(rs.getString(1))==0) {
					nombreProd.setText(rs.getString(2));
					tipo.setText(rs.getString(7));
					condicion.setText(rs.getString(4));
					fecha.setText(rs.getString(5));
				}
			}
		}catch(Exception e) {
			
		}
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setConn(Conexion conn) {
		this.conn = conn;
		rellenarDatos();
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
