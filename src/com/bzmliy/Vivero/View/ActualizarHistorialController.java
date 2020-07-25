package com.bzmliy.Vivero.View;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.util.Optional;

import com.bzmliy.Vivero.Model.Conexion;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ActualizarHistorialController {
	private Conexion conn;
	private Stage stage;
	private String id;
	private File imgFile;
	
	@FXML private DatePicker fecha;
    @FXML private TextField fecha2;
    @FXML private ImageView imagen;

    @FXML
    void agergarClick() {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Confirmacion");
    	alert.setHeaderText("Elige una respuesta");
    	alert.setContentText("¿Esta seguro de actualizar el historial?");

    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		conn.actualizarFechaHistorial(id, fecha2.getText());
    		if(imagen.getImage() == null) {
    			
    		} else {
    			Path origenPath = FileSystems.getDefault().getPath(String.valueOf(imgFile));
	            Path destinoPath = FileSystems.getDefault().getPath("Imagenes/"+id+".png");
	            try {
	                Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
	            }catch (Exception e) {
	            	e.printStackTrace();
				}
				conn.actualizarFotografia(id, "Imagenes/"+id+".png");
    		}
			stage.close();
    	} else {
    		Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Informacion");
			alerta.setHeaderText(null);
			alerta.setContentText("El historial no fue actualizado!");
			alerta.showAndWait();
    	}
    }

    @FXML
    void agregarFotoClick() {
    	FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");

        // Agregar filtros para facilitar la busqueda
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );


        // Obtener la imagen seleccionada
        imgFile = fileChooser.showOpenDialog(null);
        
        if(imgFile != null) {
        	Image image = new Image("file:" + imgFile.getAbsolutePath());
            imagen.setImage(image);
        }
    }

    @FXML
    void fechaClick() {
    	if(fecha.getValue() == null ) {
			
		} else {
			fecha2.setText(String.valueOf(fecha.getValue()));
		}
    }
    
    @FXML
    void cancelarClick() {
    	stage.close();
    }
	
	
	public void setDatos(Conexion conn, Stage stage, String id) {
		this.conn = conn;
		this.stage = stage;
		this.id = id;
		llenarDatos();
	}
	
	private void llenarDatos() {
		try {
			ResultSet rs = conn.obtenerHistorialXid(id);
			while(rs.next()) {
				fecha2.setText(rs.getString(3));
				imgFile = new File(rs.getString(4));
			}
			Image image = new Image("file:" + imgFile.getAbsolutePath());
            imagen.setImage(image);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
