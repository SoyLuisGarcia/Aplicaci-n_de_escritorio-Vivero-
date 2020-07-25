package com.bzmliy.Vivero.View;

import java.sql.ResultSet;

import com.bzmliy.Vivero.Main;
import com.bzmliy.Vivero.Model.Conexion;
import com.bzmliy.Vivero.Model.TablaProducto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ProductoController {
	private Conexion conn;
	private Stage stage;
	private Main main;
	
	ObservableList<TablaProducto> lista = FXCollections.observableArrayList();
	
	@FXML private TableView<TablaProducto> tabla;
    @FXML private TableColumn<TablaProducto, String> id;
    @FXML private TableColumn<TablaProducto, String> nombre;
    @FXML private TableColumn<TablaProducto, String> tipo;
	@FXML private TextField textoId;
	
	@FXML
	void verClick() {
		
		if (textoId.getText().isEmpty()) {    
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Information");
			alerta.setHeaderText("Error");
			alerta.setContentText("Introdusca una id");
			alerta.showAndWait();
		} else if (!conn.validarIdProducto(textoId.getText())) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Information");
			alerta.setHeaderText("Error");
			alerta.setContentText("Esa ID no existe");
			alerta.showAndWait();
		} else {
			main.openVerProducto(stage, textoId.getText());
			textoId.clear();
			crearTabla();
		}
	}
	
	@FXML
	void agregarClick(){
		main.openNuevoProducto(stage);
		crearTabla();
	}
	
	@FXML
	void regresarClick() {
		stage.close();
	}
	
	private void crearTabla() {
		lista.clear();
		try {
			ResultSet rs = conn.obtenerProducto();
			while(rs.next()) {
				lista.add(new TablaProducto(rs.getString(1), rs.getString(2), rs.getString(7)));
			}
		}catch(Exception e) {
			
		}
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		tabla.setItems(lista);
	}
	
	public void setConn(Conexion conn) {
		this.conn = conn;
		crearTabla();
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
}
