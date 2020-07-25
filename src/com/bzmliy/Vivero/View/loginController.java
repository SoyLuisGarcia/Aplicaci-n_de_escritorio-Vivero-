package com.bzmliy.Vivero.View;

import com.bzmliy.Vivero.Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginController {
	private Main main;
	
	@FXML
	private TextField user;
	@FXML
	private PasswordField password;
	@FXML
	private Button accept;
    @FXML
    private ComboBox<String> tipoServidor;
    
    ObservableList<String> lista = FXCollections.observableArrayList("MySQL","SQLServer","DB2");

	
	@FXML
	private void hacerClickUser() {
		if(tipoServidor.getValue()!=null)
		if(user.getText().compareTo("bzm")==0 && password.getText().compareTo("hola")==0 && (tipoServidor.getValue().compareTo("SQLServer")==0 || tipoServidor.getValue().compareTo("MySQL")==0))
		{
			main.abrirVentanaMenu();
			main.determinarBaseDatos(tipoServidor.getValue());
		} else if(user.getText().compareTo("liy")==0 && password.getText().compareTo("liy")==0 && (tipoServidor.getValue().compareTo("SQLServer")==0 || tipoServidor.getValue().compareTo("MySQL")==0 || tipoServidor.getValue().compareTo("DB2")==0)) {
			main.abrirVentanaMenu();
			main.determinarBaseDatos(tipoServidor.getValue());
		}
	}
	
	public void initialize() {
		tipoServidor.setItems(lista);
    } 
	
	public void setMain(Main main) {
		this.main = main;
	}
}
