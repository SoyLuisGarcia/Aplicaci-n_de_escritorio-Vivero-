package com.bzmliy.Vivero.View;

import com.bzmliy.Vivero.Main;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MenuController {
	private Stage stage;
	private Main main;
	
	@FXML
	void abrir1Click() {
		main.openProducto(stage);
	}
	
	@FXML
	void tiposClick() {
		main.openTiposProd(stage);
	}
	
	@FXML
	void prosXcond() {
		main.openCantXCond(stage);
	}
	
	@FXML
	void prodsXtipo() {
		main.openCantXTipo(stage);
	}
	
	@FXML
    void videoClick() {
		main.openVideo(stage);
    }
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	
}
