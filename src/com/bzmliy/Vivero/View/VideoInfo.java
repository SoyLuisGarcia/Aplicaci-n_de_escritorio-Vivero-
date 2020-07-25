package com.bzmliy.Vivero.View;

import java.io.File;

import com.bzmliy.Vivero.Main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoInfo {
	Main main;
	private MediaPlayer mp;
	
	@FXML private MediaView video;	
    @FXML private Button play;
    @FXML private Button stop;

    @FXML
    void hacerClickPlay() {
    	mp.play();
    }
    @FXML
    void hacerClikStop() {
    	mp.stop();
    }
    @FXML
    void hacerClickBack() {
    	main.abrirVentanaMenu();
    }
    
    @FXML
    void initialize()
    {
    	File f = new File("src/com/bzmliy/Vivero/Media/proyectoBaseDatos.mp4");
    	Media media = new Media(f.toURI().toString());
    	mp = new MediaPlayer(media);
    	video.setMediaPlayer(mp);
    }
    
    public void setMain(Main main) {
		this.main = main;
	}
}
