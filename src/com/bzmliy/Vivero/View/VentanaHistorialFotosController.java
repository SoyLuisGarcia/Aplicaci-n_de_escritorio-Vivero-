package com.bzmliy.Vivero.View;

import java.sql.ResultSet;

import com.bzmliy.Vivero.Main;
import com.bzmliy.Vivero.Model.Conexion;
import com.bzmliy.Vivero.Model.Tabla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class VentanaHistorialFotosController {
	Main main;
	Conexion conn;
    @FXML
    private TableView<Tabla> tabla;
    @FXML
    private TableColumn<Tabla,String> id;
    @FXML
    private TableColumn<Tabla,String> foto;
    @FXML
    private TableColumn<Tabla,String> fecha;
    @FXML
    private TextField idProducto;

    ObservableList<Tabla> lista = FXCollections.observableArrayList();

    @FXML
    void hacerClickActualizar() {
    	if (!idProducto.getText().isEmpty()&&conn.validarRegistroRiego(Integer.valueOf(idProducto.getText())))
    	{
    		main.mostrarDatos(Integer.valueOf(idProducto.getText()));
    		main.abrirVentanaActualizar();
    	}
    	else if(idProducto.getText().isEmpty())
    	{
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Campo vacio");
			alert.setContentText("Favor de llenar el campo");
			alert.showAndWait();
    	}
    	else if(!conn.validarRegistroRiego(Integer.valueOf(idProducto.getText())))
    	{
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Id no encontrado");
			alert.setContentText("Favor de llenar el campo nuevamente");
			alert.showAndWait();
    	}
    }

    @FXML
    void hacerClickAgregar() {
    	if (!idProducto.getText().isEmpty()&&conn.validarRegistroRiego(Integer.valueOf(idProducto.getText())))
    	{
    		main.mostrarDatos(Integer.valueOf(idProducto.getText()));
    		main.abrirVentanaAgregar();
    	}
    	else if(idProducto.getText().isEmpty())
    	{
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Campo vacio");
			alert.setContentText("Favor de llenar el campo");
			alert.showAndWait();
    	}
    	else if(!conn.validarRegistroRiego(Integer.valueOf(idProducto.getText())))
    	{
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Id no encontrado");
			alert.setContentText("Favor de llenar el campo nuevamente");
			alert.showAndWait();
    	}
    }

    @FXML
    void hacerClickEliminar() {
    	if (!idProducto.getText().isEmpty()&&conn.validarRegistroRiego(Integer.valueOf(idProducto.getText())))
    	{
    		main.mostrarDatos(Integer.valueOf(idProducto.getText()));
    		main.abrirVentanaEliminar();
    	}
    	else if(idProducto.getText().isEmpty())
    	{
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Campo vacio");
			alert.setContentText("Favor de llenar el campo");
			alert.showAndWait();
    	}
    	else if(!conn.validarRegistroRiego(Integer.valueOf(idProducto.getText())))
    	{
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Id no encontrado");
			alert.setContentText("Favor de llenar el campo nuevamente");
			alert.showAndWait();
    	}
    }

    @FXML
    void hacerClickVer() {
    	if (!idProducto.getText().isEmpty()&&conn.validarRegistroRiego(Integer.valueOf(idProducto.getText())))
    	{
    		main.mostrarDatos(Integer.valueOf(idProducto.getText()));
    		main.abrirVentanaVer();
    	}
    	else if(idProducto.getText().isEmpty())
    	{
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Campo vacio");
			alert.setContentText("Favor de llenar el campo");
			alert.showAndWait();
    	}
    	else if(!conn.validarRegistroRiego(Integer.valueOf(idProducto.getText())))
    	{
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Id no encontrado");
			alert.setContentText("Favor de llenar el campo nuevamente");
			alert.showAndWait();
    	}
    }
    @FXML
    void hacerClickMenu() {
    	main.abrirVentanaMenu();
    }


	public void setMain(Main main,Conexion conn) {
		this.main = main;
		this.conn = conn;
		mostrarTabla();
	}
	
	public void mostrarTabla() {
		try
		{
			ResultSet rs = conn.registroRiego();
	    	while (rs.next()) {
	            lista.add(new Tabla(rs.getString(1), rs.getString(2),rs.getString(3)));
	    	}
	    }catch(Exception e) {
			e.printStackTrace();
		}
    	id.setCellValueFactory(new PropertyValueFactory<>("id"));
        foto.setCellValueFactory(new PropertyValueFactory<>("foto"));
        fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tabla.setItems(lista);	
	}
}
