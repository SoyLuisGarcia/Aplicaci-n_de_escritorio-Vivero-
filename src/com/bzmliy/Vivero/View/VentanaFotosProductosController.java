package com.bzmliy.Vivero.View;

import java.sql.ResultSet;

import com.bzmliy.Vivero.Main;
import com.bzmliy.Vivero.Model.Conexion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class VentanaFotosProductosController {
	Main main;
	Conexion conn;
    @FXML
    private LineChart<String,Integer> grafica;
    @FXML
    private CategoryAxis xAxis;

    @FXML
    void hacerClickMenu() {
    	main.abrirVentanaMenu();
    }
    
    private void mostrarGrafica()
    {
    	XYChart.Series<String, Integer> dataSeries1 = new XYChart.Series<>();
    	ObservableList<String> leyenda =  FXCollections.observableArrayList();
    	try
    	{
    		ResultSet rs = conn.mostrarGraficaFotosProductos();
	    	 while (rs.next()){ 
	             leyenda.add(""+rs.getString(1)); // se agrega como leyenda el campo que que quiera, debe coincidir con la serie
	             dataSeries1.getData().add(new XYChart.Data<>(""+rs.getString(1), rs.getInt(2))); // posicion 1 es la leyenda  
	         }
	    	//xAxis.setCategories(leyenda);  // se asigna la leyenda a la grafica
	        grafica.getData().add(dataSeries1);
    	}catch(Exception e) {
			e.printStackTrace();
		}
    	
    }

	public void setMain(Main main,Conexion conn) {
		this.main = main;
		this.conn = conn;
				mostrarGrafica();
		}
}
