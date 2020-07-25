package com.bzmliy.Vivero.View;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class VideoController {
	private Stage stage;
	@FXML private VBox video;
	@FXML private MediaView videazo;
	private MediaPlayer mp;
	
	@FXML
	void pararClick() {
		mp.stop();
	}

    @FXML
    void reproducirClick() {
    	mp.play();
    }

    @FXML
    void salirClick() {
		mp.stop();
		stage.close();
    }
    
    public void setStage(Stage stage) {
    	this.stage = stage;
    }
    
    @FXML
    void initialize() {
    	File f = new File("src/com/bzmliy/Vivero/Video/Auto.mp4");
    	Media media = new Media(f.toURI().toString());
    	mp = new MediaPlayer(media);
    	videazo.setMediaPlayer(mp);
    }
}


/*
  Paginas wev
  http://acodigo.blogspot.com/2017/02/javafx-reproduccion-de-audio-y-video.html
  https://www.jc-mouse.net/javafx/reproducir-video-con-javafx-y-html5
 
 */
