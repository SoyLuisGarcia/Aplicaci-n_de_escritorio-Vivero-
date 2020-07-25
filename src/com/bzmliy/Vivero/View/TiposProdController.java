package com.bzmliy.Vivero.View;

import java.sql.ResultSet;
import java.util.Optional;

import com.bzmliy.Vivero.Model.Conexion;
import com.bzmliy.Vivero.Model.TablaProducto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TiposProdController {
	private Stage stage;
	private Conexion conn;
	
	@FXML private TextField id_tipo;
    @FXML private TextField nombre;
    
    @FXML private TableView<TablaProducto> tabla;
    @FXML private TableColumn<TablaProducto, String> tipo;
    @FXML private TableColumn<TablaProducto, String> id;
    
    
	
	
	@FXML
	void actualizarClick() {
		if (id_tipo.getText().isEmpty() || nombre.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Rellene todos los campos");
			alert.showAndWait();
		} else {
			if(!conn.validarIdTipo(id_tipo.getText())) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Ese id no existe");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmacion");
				alert.setHeaderText("Seleccione una opcion");
				alert.setContentText("¿Esta seguro de actualizar el tipo?");

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK){
					Alert alert2 = new Alert(AlertType.INFORMATION);
					alert2.setTitle("Informacion");
					alert2.setHeaderText(null);
					alert2.setContentText("Actualizacion correcta");
					alert2.showAndWait();
					conn.actualizarTipo(id_tipo.getText(), nombre.getText());
					generarTabla();
				} else {
					Alert alert2 = new Alert(AlertType.INFORMATION);
					alert2.setTitle("Informacion");
					alert2.setHeaderText(null);
					alert2.setContentText("Actualizacion cancelada");
					alert2.showAndWait();
				}
			}
		}
	}
	
	@FXML
	void borraClick() {
		if(id_tipo.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Introdusca la ID del producto a borrar");
			alert.showAndWait();
		} else if (!conn.validarIdTipo(id_tipo.getText())) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Ese id no existe!");
			alert.showAndWait();
		} else if (conn.vailidarTipoEnUso(id_tipo.getText())) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Uno o varios productos estan usando este tipo");
			alert.setContentText("Cambiel el tipo o borre los productos para borrar el TIPO!");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmacion");
			alert.setHeaderText("Seleccione una opcion");
			alert.setContentText("¿Desea borrar el producto?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setTitle("Informacion");
				alert2.setHeaderText(null);
				alert2.setContentText("Producto borrado");
				alert2.showAndWait();
				conn.borrarTipo(id_tipo.getText());
				generarTabla();
			} else {
				Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setTitle("Informacion");
				alert2.setHeaderText(null);
				alert2.setContentText("Producto no borrado");
				alert2.showAndWait();
			}
		}
	}
	
	@FXML
	void agregarClick() {
		if (nombre.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Agrege el nombre del tipo");
			alert.showAndWait();
		} else if(conn.validarTipoNombreRepetido(nombre.getText())) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Ese tipo ya existe!");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmacion");
			alert.setHeaderText("Elige una respuesta");
			alert.setContentText("¿Esta seguro de agregar esta tipo?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setTitle("Informacion");
				alert2.setHeaderText(null);
				alert2.setContentText("Producto agregado");
				alert2.showAndWait();
				conn.agregarTipo(nombre.getText());
				generarTabla();
			} else {
				Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setTitle("Informacion");
				alert2.setHeaderText(null);
				alert2.setContentText("Producto no agregado");
				alert2.showAndWait();
			}
		}
	}
	
	@FXML
	void regresarClick() {
		stage.close();
	}
	
	private void generarTabla() {
		ObservableList<TablaProducto> lista = FXCollections.observableArrayList();
		try {
			ResultSet rs = conn.obtenerTablaTipo();
			while(rs.next()) {
				lista.add(new TablaProducto(rs.getString(1), "", rs.getString(2)));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		tabla.setItems(lista);
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void setConn(Conexion conn) {
		this.conn = conn;
		generarTabla();
	}
}
