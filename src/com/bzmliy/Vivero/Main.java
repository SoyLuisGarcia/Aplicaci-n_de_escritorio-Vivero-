package com.bzmliy.Vivero;
	
import com.bzmliy.Vivero.View.ActualizarHistorialController;
import com.bzmliy.Vivero.View.ActualizarProductoController;
import com.bzmliy.Vivero.View.CantXCondController;
import com.bzmliy.Vivero.View.CantXTipoController;
import com.bzmliy.Vivero.View.HistorialController;
import com.bzmliy.Vivero.View.NuevoHistorialController;
import com.bzmliy.Vivero.View.NuevoProductoController;
import com.bzmliy.Vivero.View.ProductoController;
import com.bzmliy.Vivero.View.TiposProdController;
import com.bzmliy.Vivero.View.VentanaActualizar;
import com.bzmliy.Vivero.View.VentanaAgregar;
import com.bzmliy.Vivero.View.VentanaEliminar;
import com.bzmliy.Vivero.View.VentanaFotosProductosController;
import com.bzmliy.Vivero.View.VentanaHistorialFotosController;
import com.bzmliy.Vivero.View.VentanaMenuController;
import com.bzmliy.Vivero.View.VentanaRegistroRiegoController;
import com.bzmliy.Vivero.View.VentanaRiegosDiaController;
import com.bzmliy.Vivero.View.VentanaVer;
import com.bzmliy.Vivero.View.VerProductoController;
import com.bzmliy.Vivero.View.VideoController;
import com.bzmliy.Vivero.View.VideoInfo;

import com.bzmliy.Vivero.Main;
import com.bzmliy.Vivero.Model.Conexion;
import com.bzmliy.Vivero.View.loginController;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private Stage stage;
	public Conexion conn;
	private int md;
	
	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/login.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            primaryStage.setTitle("Welcome");
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			loginController loginControler = loader.getController();
			loginControler.setMain(this);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void abrirVentanaMenu() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/VentanaMenu.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageMenu = new Stage();
			Scene scene = new Scene(root,800,600);
			stageMenu.initOwner(stage);
			stageMenu.setTitle("Menu");
			stageMenu.setScene(scene);
			stageMenu.setResizable(false);
			VentanaMenuController menuControler = loader.getController();
			menuControler.setMain(this,conn,stageMenu);
			stageMenu.initModality(Modality.WINDOW_MODAL);
			stage.close();
			stageMenu.show();
			stage=stageMenu;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void determinarBaseDatos(String baseDatos)
	{
		conn = new Conexion(baseDatos);
	}
	
	public void abrirVentanaRegistroRiego() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/VentanaRegistroRiego.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageRiego = new Stage();
			Scene scene = new Scene(root,400,400);
			stageRiego.initOwner(stage);
			stageRiego.setTitle("Registro Roiego");
			stageRiego.setScene(scene);
			stageRiego.setResizable(false);
			VentanaRegistroRiegoController RiegoControler = loader.getController();
			RiegoControler.setMain(this,conn);
			stageRiego.initModality(Modality.WINDOW_MODAL);
			stage.close();
			stageRiego.show();
			stage=stageRiego;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abrirVentanaHistorialFotos() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/VentanaHistorialFotos.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageFotos = new Stage();
			Scene scene = new Scene(root,400,400);
			stageFotos.initOwner(stage);
			stageFotos.setTitle("Historial Fotos");
			stageFotos.setScene(scene);
			stageFotos.setResizable(false);
			VentanaHistorialFotosController fotosControler = loader.getController();
			fotosControler.setMain(this,conn);
			stageFotos.initModality(Modality.WINDOW_MODAL);
			stage.close();
			stageFotos.show();
			stage=stageFotos;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abrirVentanaRiegosDia() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/VentanaRiegosDia.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageRiegosDia = new Stage();
			Scene scene = new Scene(root,600,600);
			stageRiegosDia.initOwner(stage);
			stageRiegosDia.setTitle("Historial Fotos");
			stageRiegosDia.setScene(scene);
			stageRiegosDia.setResizable(false);
			VentanaRiegosDiaController riegosDiaControler = loader.getController();
			riegosDiaControler.setMain(this,conn);
			stageRiegosDia.initModality(Modality.WINDOW_MODAL);
			stage.close();
			stageRiegosDia.show();
			stage=stageRiegosDia;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void abrirVentanaFotosProductos() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/VentanaFotosProductos.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageFotosProductos = new Stage();
			Scene scene = new Scene(root,600,600);
			stageFotosProductos.initOwner(stage);
			stageFotosProductos.setTitle("Historial Fotos");
			stageFotosProductos.setScene(scene);
			stageFotosProductos.setResizable(false);
			VentanaFotosProductosController fotosProductosControler = loader.getController();
			fotosProductosControler.setMain(this,conn);
			stageFotosProductos.initModality(Modality.WINDOW_MODAL);
			stage.close();
			stageFotosProductos.show();
			stage=stageFotosProductos;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/////////////////////////////////
	public void abrirVentanaAgregar()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/VentanaAgregar.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageAgregar = new Stage();
			Scene scene = new Scene(root,500,500);
			stageAgregar.initOwner(stage);
			stageAgregar.setTitle("Agregar");
			stageAgregar.setScene(scene);
			stageAgregar.setResizable(false);
			VentanaAgregar agregarControler = loader.getController();
			agregarControler.setMain(this,conn,md);
			stageAgregar.initModality(Modality.WINDOW_MODAL);
			stage.close();
			stageAgregar.show();
			stage=stageAgregar;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void abrirVentanaVer()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/VentanaVer.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageVer = new Stage();
			Scene scene = new Scene(root,500,500);
			stageVer.initOwner(stage);
			stageVer.setTitle("Informacion");
			stageVer.setScene(scene);
			stage.setResizable(false);
			VentanaVer verControler = loader.getController();
			verControler.setMain(this,conn,md);
			stageVer.initModality(Modality.WINDOW_MODAL);
			stage.close();
			stageVer.show();
			stage=stageVer;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void abrirVentanaActualizar()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/VentanaActualizar.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageActualizar = new Stage();
			Scene scene = new Scene(root,500,500);
			stageActualizar.initOwner(stage);
			stageActualizar.setTitle("Actualizar");
			stageActualizar.setScene(scene);
			stageActualizar.setResizable(false);
			VentanaActualizar actualizarControler = loader.getController();
			actualizarControler.setMain(this,conn,md);
			stageActualizar.initModality(Modality.WINDOW_MODAL);
			stage.close();
			stageActualizar.show();
			stage=stageActualizar;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void abrirVentanaEliminar()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/VentanaEliminar.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageEliminar = new Stage();
			Scene scene = new Scene(root,500,500);
			stageEliminar.initOwner(stage);
			stageEliminar.setTitle("Eliminar");
			stageEliminar.setScene(scene);
			stageEliminar.setResizable(false);
			VentanaEliminar eliminarControler = loader.getController();
			eliminarControler.setMain(this,conn,md);
			stageEliminar.initModality(Modality.WINDOW_MODAL);
			stage.close();
			stageEliminar.show();
			stage=stageEliminar;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	///////////////////////////////////////////////////
	public void abrirVentanaLogin() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/login.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stage1 = new Stage();
            stage1.setTitle("Welcome");
			Scene scene = new Scene(root,400,400);
			stage1.setScene(scene);
			stage1.setResizable(false);
			loginController loginControler = loader.getController();
			loginControler.setMain(this);
			stage.close();
			stage1.show();
			stage=stage1;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abrirVentanaVideoInfo() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/VideoInfo.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            Stage stageInfo = new Stage();
			Scene scene = new Scene(root,800,500);
			stageInfo.initOwner(stage);
			stageInfo.setTitle("Informacion");
			stageInfo.setScene(scene);
			stageInfo.setResizable(false);
			VideoInfo infoControler = loader.getController();
			infoControler.setMain(this);
			stageInfo.initModality(Modality.WINDOW_MODAL);
			stage.close();
			stageInfo.show();
			stage=stageInfo;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//
	public void mostrarDatos(int id)
	{
		md = id;
	}
	
	// Jorge
	
	public void openProducto(Stage random) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Producto.fxml"));
			AnchorPane root = loader.load();
			Scene scene = new Scene(root, 400, 400);
			Stage stageProducto = new Stage();
			stageProducto.setScene(scene);
			stageProducto.setResizable(false);
			stageProducto.setTitle("Producto");
			stageProducto.initModality(Modality.WINDOW_MODAL);
			stageProducto.initOwner(random);
			ProductoController layoutRoot = loader.getController();
			layoutRoot.setStage(stageProducto);
			layoutRoot.setConn(conn);
			layoutRoot.setMain(this);
			stageProducto.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openVerProducto(Stage random, String id) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/VerProducto.fxml"));
			AnchorPane root =  loader.load();
			Scene scene = new Scene(root, 500, 370);
			Stage stageVerProducto = new Stage();
			stageVerProducto.setScene(scene);
			stageVerProducto.setTitle("Productos");
			stageVerProducto.setResizable(false);
			stageVerProducto.initModality(Modality.WINDOW_MODAL);
			stageVerProducto.initOwner(random);
			VerProductoController layoutRoot = loader.getController();
			layoutRoot.setStage(stageVerProducto);
			layoutRoot.setId(id);
			layoutRoot.setMain(this);
			layoutRoot.setConn(conn);
			stageVerProducto.showAndWait();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openActualizarProductos(Stage random, String id) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/ActualizarProducto.fxml"));
			AnchorPane root =  loader.load();
			Scene scene = new Scene(root, 500, 350);
			Stage stageActualizarProducto = new Stage();
			stageActualizarProducto.setScene(scene);
			stageActualizarProducto.setTitle("Actualizar producto");
			stageActualizarProducto.setResizable(false);
			stageActualizarProducto.initModality(Modality.WINDOW_MODAL);
			stageActualizarProducto.initOwner(random);
			ActualizarProductoController layoutRoot = loader.getController();
			layoutRoot.setStage(stageActualizarProducto);
			layoutRoot.setId(id);
			layoutRoot.setConn(conn);
			stageActualizarProducto.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openNuevoProducto(Stage random) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/NuevoProducto.fxml"));
			AnchorPane root =  loader.load();
			Scene scene = new Scene(root, 500, 350);
			Stage stageNuevoProducto = new Stage();
			stageNuevoProducto.setScene(scene);
			stageNuevoProducto.setTitle("Nuevo producto");
			stageNuevoProducto.setResizable(false);
			stageNuevoProducto.initModality(Modality.WINDOW_MODAL);
			stageNuevoProducto.initOwner(random);
			NuevoProductoController layoutRoot = loader.getController();
			layoutRoot.setStage(stageNuevoProducto);
			layoutRoot.setConn(conn);
			stageNuevoProducto.showAndWait();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openTiposProd(Stage random) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/TiposProd.fxml"));
			AnchorPane root =  loader.load();
			Scene scene = new Scene(root, 300, 400);
			Stage stageTiposProd = new Stage();
			stageTiposProd.setScene(scene);
			stageTiposProd.setTitle("Tipos de producto");
			stageTiposProd.setResizable(false);
			stageTiposProd.initModality(Modality.WINDOW_MODAL);
			stageTiposProd.initOwner(random);
			TiposProdController layoutRoot = loader.getController();
			layoutRoot.setStage(stageTiposProd);
			layoutRoot.setConn(conn);
			stageTiposProd.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openCantXCond(Stage random) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/CantXCond.fxml"));
			AnchorPane root =  loader.load();
			Scene scene = new Scene(root, 600, 600);
			Stage stageCantXCond = new Stage();
			stageCantXCond.setScene(scene);
			stageCantXCond.setTitle("Tabla");
			stageCantXCond.setResizable(false);
			stageCantXCond.initModality(Modality.WINDOW_MODAL);
			stageCantXCond.initOwner(random);
			CantXCondController rootLayout = loader.getController();
			rootLayout.setConn(conn);
			rootLayout.setStage(stageCantXCond);
			stageCantXCond.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openCantXTipo(Stage random) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/CantXTipo.fxml"));
			AnchorPane root =  loader.load();
			Scene scene = new Scene(root, 600, 600);
			Stage stageCantXTipo = new Stage();
			stageCantXTipo.setScene(scene);
			stageCantXTipo.setTitle("Tabla");
			stageCantXTipo.setResizable(false);
			stageCantXTipo.initModality(Modality.WINDOW_MODAL);
			stageCantXTipo.initOwner(random);
			CantXTipoController layoutRoot = loader.getController();
			layoutRoot.setStage(stageCantXTipo);
			layoutRoot.setConn(conn);
			stageCantXTipo.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openVideo(Stage random) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Video.fxml"));
			AnchorPane root = loader.load();
			Scene scene = new Scene(root, 600, 600);
			Stage stageVideo = new Stage();
			stageVideo.setScene(scene);
			stageVideo.setTitle("Video");
			stageVideo.setResizable(false);
			stageVideo.initModality(Modality.WINDOW_MODAL);
			stageVideo.initOwner(random);
			VideoController layoutRoot = loader.getController();
			layoutRoot.setStage(stageVideo);
			stageVideo.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void openHistorial(Stage random, String id) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/Historial.fxml"));
			AnchorPane root = loader.load();
			Scene scene = new Scene(root, 400, 400);
			Stage stegeHistorial = new Stage();
			stegeHistorial.setScene(scene);
			stegeHistorial.setTitle("Historial");
			stegeHistorial.setResizable(false);
			stegeHistorial.initModality(Modality.WINDOW_MODAL);
			stegeHistorial.initOwner(random);
			HistorialController layoutRoot = loader.getController();
			layoutRoot.setStage(stegeHistorial);
			layoutRoot.setId_Prod(id);
			layoutRoot.setConn(conn, this);
			stegeHistorial.showAndWait();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openNuevoHistorial(Stage random, String id) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/NuevoHistorial.fxml"));
			AnchorPane root = loader.load();
			Scene scene = new Scene(root, 400, 450);
			Stage stageNuevoHistorial = new Stage();
			stageNuevoHistorial.setScene(scene);
			stageNuevoHistorial.setTitle("Nuevo Historial");
			stageNuevoHistorial.setResizable(false);
			stageNuevoHistorial.initModality(Modality.WINDOW_MODAL);
			stageNuevoHistorial.initOwner(random);
			NuevoHistorialController layoutRoot = loader.getController();
			layoutRoot.setId(id);
			layoutRoot.setStage(stageNuevoHistorial);
			layoutRoot.setConn(conn);
			stageNuevoHistorial.showAndWait();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openActualizarHistorial(Stage random, String id) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("View/ActualizarHistorial.fxml"));
			AnchorPane root = loader.load();
			Scene scene = new Scene(root, 400, 450);
			Stage stageActualizar = new Stage();
			stageActualizar.setScene(scene);
			stageActualizar.setTitle("Actualizar");
			stageActualizar.setResizable(false);
			stageActualizar.initModality(Modality.WINDOW_MODAL);
			stageActualizar.initOwner(random);
			ActualizarHistorialController layoutRoot = loader.getController();
			layoutRoot.setDatos(conn, stageActualizar, id);
			stageActualizar.showAndWait();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
