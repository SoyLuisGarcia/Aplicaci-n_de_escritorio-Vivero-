package com.bzmliy.Vivero.View;

import java.sql.ResultSet;

import com.bzmliy.Vivero.Model.Conexion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class CantXTipoController {
	private Stage stage;
	private Conexion conn;
	@FXML private LineChart<String, Integer> chartBarras;
    @FXML private CategoryAxis xAxis;
    
    private void crearGrafica() {
    	XYChart.Series<String, Integer> dataSeries = new XYChart.Series<>();
    	ObservableList<String> lista = FXCollections.observableArrayList();
    	try {
    		ResultSet rs = conn.productosPorTipo();
	    	while(rs.next()) {
	    		lista.add(""+rs.getString(1));
	    		dataSeries.getData().add(new XYChart.Data<>(""+rs.getString(1),rs.getInt(2)));
	    	}
	    	xAxis.setCategories(lista);
	    	chartBarras.getData().add(dataSeries);
    	} catch (Exception e) {
    		e.printStackTrace();
		}
    }
    
    @FXML
    void regresasClick() {
    	stage.close();
    }
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void setConn(Conexion conn) {
		this.conn = conn;
		crearGrafica();
	}

}
