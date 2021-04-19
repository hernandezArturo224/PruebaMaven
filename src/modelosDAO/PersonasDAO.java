package modelosDAO;

import java.sql.*;
import java.util.*;
import basedatos.*;
import modelosVO.*;



public class PersonasDAO {
	
	public static ArrayList<Personas> getPersonasFromCiudad(int id_ciudad){
		
		ArrayList<Personas> arrayPersonas = new ArrayList<Personas>();
		 Connection conex = Conexion.getConexion();
			Personas persona;
			 try {
				 PreparedStatement st = conex.prepareStatement("SELECT * FROM `personas` WHERE id_ciudad ="+id_ciudad);
				 ResultSet result = st.executeQuery();
				 
				while(result.next()) {
					arrayPersonas.add(new Personas(result.getInt("id"),result.getInt("id_ciudad"),result.getString("Nombre"),result.getString("Tipo"),result.getShort("Infectado")));
				}
				
				 
			 }catch(SQLException e) {
				 //e.printStackTrace();
				 arrayPersonas = null;
			 }
			 
			 return arrayPersonas;
	}
	
	
	

}
