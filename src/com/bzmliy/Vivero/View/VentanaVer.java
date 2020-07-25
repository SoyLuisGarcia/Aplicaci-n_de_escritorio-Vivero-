package com.bzmliy.Vivero.View;

import java.sql.ResultSet;

import com.bzmliy.Vivero.Main;
import com.bzmliy.Vivero.Model.Conexion;
import com.bzmliy.Vivero.Model.Tabla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VentanaVer {
	Main main;
	Conexion conn;
	int id2;
    @FXML private Label id;
    @FXML private Label nombre;
    @FXML private Label tipo;
    @FXML
    private TableView<Tabla> tabla;
    @FXML
    private TableColumn<Tabla,String> fecha;
    @FXML
    private TableColumn<Tabla,String> id_riego;
    ObservableList<Tabla> lista = FXCollections.observableArrayList();

    @FXML
    void hacerClickBack() {
    	main.abrirVentanaRegistroRiego();
    }
    
     
    public void mostrarDatos()
    {
    	try {
	    	ResultSet rs = conn.mostrarDatosRiego(id2);
	    	while (rs.next()) {
	    		id.setText(rs.getString(1));
	    		nombre.setText(rs.getString(3));
	    		tipo.setText(rs.getString(4));
	    		lista.add(new Tabla("",rs.getString(2),"","",rs.getString(5)));
	    	}
	    }catch(Exception e) {
			e.printStackTrace();
		}
    	id_riego.setCellValueFactory(new PropertyValueFactory<>("id_riego"));
    	 fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
         tabla.setItems(lista);	
    }
	
	public void setMain(Main main,Conexion conn,int id2) {
		this.main = main;
		this.conn = conn;
		this.id2=id2;
		mostrarDatos();
	}
}
