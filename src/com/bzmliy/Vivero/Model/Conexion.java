package com.bzmliy.Vivero.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Conexion {
	Connection conn;

	// Cambiar la centencias de busqueda de la tabla para que recoja el tipo
	
	public Conexion(String baseDatos){
		String url="";
		
		try{
			if(baseDatos.compareTo("MySQL")==0){
				url = "jdbc:mysql://localhost:3306/vivero?useUnicode=true&useJDBCCompliantTimezoneSh"
	    				+ "ift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url,"liy","liy"); 
			}
			
			else if(baseDatos.compareTo("SQLServer")==0){
				url = "jdbc:sqlserver://JORGELIY:1433;databaseName=Vivero"; 
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(url,"liy","liy"); 
			}
			
			else if (baseDatos.compareTo("DB2")==0) {
				Class.forName("com.ibm.db2.jcc.DB2Driver");
				conn = DriverManager.getConnection("jdbc:db2://192.168.1.78:50000/vivero2:retrieve"+"MessagesFromServerOnGetMessage=true;","db2admin","holadb2admin");
				System.out.println("Entro");
			}
			
		}catch(Exception e) {
			Alert aler = new Alert(AlertType.ERROR);
			aler.setTitle("Error");
			aler.setHeaderText(null);
			aler.setContentText("No conecto a la base de datos");
			aler.show();
		}
	}
	
	public ResultSet registroRiego()
	{
		try
		{
			String sSQL2 = "SELECT p.id, p.nombre, t.tipo FROM producto p, tipo t WHERE p.id_tipo = t.id";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL2);
			return rs;
		}catch(Exception e) {
		}
			return null;
	}
	public boolean validarRegistroRiego(int id) {
		try {
			String sSQL2 = "select * from producto";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL2);
			while(rs.next()) {
				if(rs.getInt(1) == id)
					return true;
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public ResultSet mostrarDatosRiego(int id)
	{
		try
		{
			String sSQL="select p.id id,c.id id_riego, p.nombre nombre, t.tipo tipo, c.fecha_riedo fecha from calendario c, producto p,tipo t \r\n" + 
					"where c.id_producto = p.id\r\n" + 
					"and p.id_tipo = t.id\r\n" + 
					"and p.id = '"+id+"'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			return rs;
		}catch(Exception e) {
		}
			return null;
	}
	
	public void agregarRegistroRiego(int id,String fecha)
	{
		try
		{
			String sSQL="insert into Calendario (id_producto,fecha_riedo)\r\n" + 
					"values ("+id+",'"+fecha+"')";
			Statement st = conn.createStatement();
			st.execute(sSQL);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void modificarRegistroRiego(int id,int id2,String fecha)
	{
		try
		{
			String sSQL="update calendario set fecha_riedo = '"+fecha+"'\r\n" + 
					"where id = "+id+"\r\n" + 
					"and id_producto="+id2+" ";
			Statement st = conn.createStatement();
			st.execute(sSQL);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void eliminarRegistroRiego(int id)
	{
		try
		{
			String sSQL="delete Calendario where id= "+id+" ";
			Statement st = conn.createStatement();
			st.execute(sSQL);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet mostrarGraficaFotosProductos()
	{
		try
		{
			String sSQL="SELECT p.nombre, COUNT(*) FROM historial h,  producto p WHERE h.id_producto = p.id GROUP BY p.id, p.nombre";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
			Alert aler = new Alert(AlertType.ERROR);
			aler.setTitle("Error");
			aler.setHeaderText(null);
			aler.setContentText("No creo la grafica");
			aler.show();
		}
			return null;
	}
	
	public ResultSet mostrarGraficaRiegosDiasProductos()
	{
		try
		{
			String sSQL="select fecha_riedo ,count(*) fotos from calendario\r\n" + 
					"group by fecha_riedo\r\n" + 
					"order by fecha_riedo";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			return rs;
		}catch(Exception e) {
		}
			return null;
	}
	
	
	// Jorge
	public ResultSet obtenerProducto() {
		try {
			String sSQL = "SELECT * FROM Producto a, tipo b WHERE a.id_tipo = b.id";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean validarIdProducto(String id) {
		try {
			String sSQL = "SELECT * FROM Producto";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			while(rs.next()) {
				if(rs.getString(1).compareTo(id)==0)
					return true;
			}
		}catch(Exception e) {
			
		}
		return false;
	}
	
	// Para ver producto
	
	public ResultSet obtenerDiasRiego(String id) {
		try {
			int id2 = Integer.valueOf(id);
			String sSQL = "SELECT * FROM riego r, dia d WHERE r.id_dia = d.id AND r.id_producto = '"+id2+"'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			return rs;
		}catch(Exception e) {
			
		}
		return null;
	}
	
	public void borrarProducto(String id) {
		int id2 = Integer.valueOf(id);
		String sSQL = "DELETE FROM producto WHERE id = '"+id2+"'";
		String sSQL2 = "DELETE FROM calendario WHERE id_producto = '"+id2+"'";
		String sSQL3 = "DELETE FROM historial  WHERE id_producto = '"+id2+"'";
		String sSQL4 = "DELETE FROM riego  WHERE id_producto = '"+id2+"'";
		try {
			Statement st = conn.createStatement();
			st.execute(sSQL);
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			Statement st2 = conn.createStatement();
			st2.execute(sSQL2);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Statement st3;
		try {
			st3 = conn.createStatement();
			st3.execute(sSQL3);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			Statement st4 = conn.createStatement();
			st4.execute(sSQL4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// para actualizar
	
	public void borrarDiasRiego(String id) {
		int id2 = Integer.valueOf(id);
		try {
			String sSQL = "DELETE FROM riego  WHERE id_producto = '"+id2+"'";
			Statement st = conn.createStatement();
			st.execute(sSQL);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void agregarDiaRiego(String id, int dia) {
		int id2 = Integer.valueOf(id);
		try {
			String sSQL = "INSERT INTO riego (id_producto, id_dia) VALUES ('"+id2+"','"+dia+"')";
			Statement st = conn.createStatement();
			st.execute(sSQL);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet obtenerTipos() {
		try {
			String sSQL = "SELECT * FROM tipo";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// Actualizar los datos en sSQL ;v
	public void actualizarProducto(String id, String nombre, String id_tipo, String condicion, String fecha) {
		int id2 = Integer.valueOf(id);
		int idTipo = Integer.valueOf(id_tipo);
		try {
			String sSQL = "UPDATE producto SET nombre = '"+nombre+"', id_tipo = '"+idTipo+"', "
					+ "condicion = '"+condicion+"', fecha_ingreso = '"+fecha+"' WHERE id = '"+id2+"'";
			Statement st = conn.createStatement();
			st.execute(sSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String obtenerIdTipo(String tipo) {
		try {
			String sSQL = "SELECT * FROM tipo";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			while (rs.next()) {
				if (tipo.compareTo(rs.getString(2))==0)
					return rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Funciones para crear producto
	public void agregarProductoNuevo(String nombre, String id_tipo, String estado, String fecha) {
		int idTipo = Integer.valueOf(id_tipo);
		try {
			String sSQL = "INSERT INTO producto (nombre , id_tipo, condicion, fecha_ingreso)"
					+ " VALUES ('"+nombre+"', '"+idTipo+"', '"+estado+"', '"+fecha+"')";
			Statement st = conn.createStatement();
			st.execute(sSQL);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String obtenerIdUltipoProd() {
		try {
			String sSQL = "SELECT * FROM producto ORDER BY id DESC";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			while(rs.next())
				return rs.getString(1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Funciones para tipos de productos
	
	public ResultSet obtenerTablaTipo() {
		try {
			String sSQL = "SELECT * FROM tipo";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			return rs;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean validarTipoNombreRepetido(String nombre) {
		try {
			String sSQL = "SELECT * FROM tipo";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			while(rs.next())
				if (rs.getString(2).compareTo(nombre)==0)
					return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean validarIdTipo(String id) {
		try {
			String sSQL = "SELECT * FROM tipo";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			while(rs.next()) 
				if (rs.getString(1).compareTo(id)==0)
					return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean vailidarTipoEnUso(String id) {
		try {
			String sSQL = "SELECT id_tipo FROM producto GROUP BY id_tipo";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			while(rs.next()) 
				if (rs.getString(1).compareTo(id)==0)
					return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void agregarTipo(String nombre) {
		try {
			String sSQL = "INSERT INTO tipo (tipo) VALUES ('"+nombre+"')";
			Statement st = conn.createStatement();
			st.execute(sSQL);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actualizarTipo(String id, String nombre) {
		int id2 = Integer.valueOf(id);
		try {
			String sSQL = "UPDATE tipo SET tipo = '"+nombre+"' WHERE id = '"+id2+"'";
			Statement st = conn.createStatement();
			st.execute(sSQL);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void borrarTipo(String id) {
		int id2 = Integer.valueOf(id);
		try {
			String sSQL = "DELETE FROM tipo WHERE id = '"+id2+"'";
			Statement st = conn.createStatement();
			st.execute(sSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//
	public ResultSet productosPorCondicion() {
		try {
			String sSQL = "SELECT condicion, COUNT(*) FROM producto GROUP BY condicion";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			return rs;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet productosPorTipo() {
		try {
			String sSQL = "SELECT tipo.tipo, COUNT(*) FROM producto, tipo WHERE producto.id_tipo = tipo.id GROUP BY tipo.tipo";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			return rs;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Operaciones para historial
	public ResultSet obtenerHistorial(String id) {
		int id2 = Integer.valueOf(id);
		try {
			String sSQL = "SELECT * FROM historial WHERE id_producto = '"+id2+"'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			return rs;
		}catch (Exception e) {
			e.printStackTrace();
		}
	return null;	
	}
	
	public void agregarHistorial(String id, String fecha) {
		int id2 = Integer.valueOf(id);
		try {
			String sSQL = "INSERT INTO Historial (id_producto, fecha, fotografia) VALUES ('"+id2+"','"+fecha+"','Imagenes/noHayImagen.jpg')";
			Statement st = conn.createStatement();
			st.execute(sSQL);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String obtenerUltiHistorial() {
		try {
			String sSQL = "SELECT * FROM historial ORDER BY id DESC";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			while (rs.next()) {
				return rs.getString(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void actualizarFotografia(String id, String foto) {
		int id2 = Integer.valueOf(id);
		try {
			String sSQL = "UPDATE historial SET fotografia = '"+foto+"' WHERE id = '"+id2+"'";
			Statement st = conn.createStatement();
			st.execute(sSQL);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean validarIdHistorial(String id, String id_foto) {
		int id2 = Integer.valueOf(id);
		try {
			String sSQL = "SELECT * FROM historial WHERE id_producto = '"+id2+"'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			while (rs.next()) {
				if (rs.getString(1).compareTo(id_foto) == 0)
					return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void borrarHistorial(String id) {
		int id2 = Integer.valueOf(id);
		try {
			String sSQL = "DELETE from historial WHERE id = '"+id2+"'";
			Statement st = conn.createStatement();
			st.execute(sSQL);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet obtenerHistorialXid(String id) {
		int id2 = Integer.valueOf(id);
		try {
			String sSQL = "SELECT * FROM historial WHERE id = '"+id2+"'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sSQL);
			return rs;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void actualizarFechaHistorial(String id, String fecha) {
		int id2 = Integer.valueOf(id);
		try {
			String sSQL = "UPDATE historial SET fecha = '"+fecha+"' WHERE id = '"+id2+"'";
			Statement st = conn.createStatement();
			st.execute(sSQL);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}


