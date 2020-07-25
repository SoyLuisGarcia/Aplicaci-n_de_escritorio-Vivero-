package com.bzmliy.Vivero.View;

import com.bzmliy.Vivero.Main;
import com.bzmliy.Vivero.Model.Conexion;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VentanaMenuController {
	Main main;
	Conexion conn;
	Stage stage;
	
    @FXML
    private Button registroRiego;
    @FXML
    private Button historialFotos;
    @FXML
    private Button riegoDia;
    @FXML
    private Button fotosProducto;
 
    @FXML
    void hacerClickLogin() {
    	main.abrirVentanaLogin();
    }
    @FXML
    void hacerClickRegistroRiego() {
    	main.abrirVentanaRegistroRiego();
    }   
    
    @FXML
    void hacerClickRiegoDia() {
    	main.abrirVentanaRiegosDia();
    }   
    @FXML
    void hacerClickFotosProductos() {
    	main.abrirVentanaFotosProductos();
    }  
    @FXML
    void hacerClickInfo() {
    	main.abrirVentanaVideoInfo();
    }
    
    @FXML
    void productosClick() {
    	main.openProducto(stage);
    }
    
    @FXML
    void tiposDeProdClick() {
    	main.openTiposProd(stage);
    }
    
    @FXML
    void productosPorCond() {
    	main.openCantXCond(stage);
    }
    
    @FXML
    void productosPorTipo() {
    	main.openCantXTipo(stage);
    }
	
	public void setMain(Main main,Conexion conn, Stage stage) {
		this.main = main;
		this.conn = conn;
		this.stage = stage;
	}
}
