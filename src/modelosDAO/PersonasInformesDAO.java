package modelosDAO;

import basedatos.Conexion;
import controladores.ControladorPersonas;
import logs.UsoLogger;

import java.sql.*;
import java.util.*;

import org.apache.log4j.Logger;

import modelosVO.*;

public class PersonasInformesDAO {
	
	public static Logger log = UsoLogger.getLogger(PersonasInformesDAO.class);
	
	
	public static void insertaInformes(int init,int fin) {
		Connection conex = Conexion.getConexion();
		HashMap<Integer,Infectable> informes = ControladorPersonas.pacientes;
		ArrayList<Infectable> lista = new ArrayList<Infectable>();
		for(Map.Entry<Integer, Infectable> entrada: informes.entrySet()) {
			lista.add(entrada.getValue());
		}
		
		int i;
		for(i=init;i<fin;i++) {
			Pacientes paciente = (Pacientes) lista.get(i);
			PersonasInforme informe = new PersonasInforme(paciente.getId(),paciente.getIdCiudad(),paciente.getNombre(),paciente.getTipo(),paciente.getInfectado());
			insertaInformeUnico(informe,conex);
		}
		
		HiloInsercion.finTotal++;
		while(HiloInsercion.finTotal < 4) { //esperamos a que acaben los 4
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				log.fatal("Error al esperar con sleep");
				e.printStackTrace();
			}
		}
		log.info("Informes insertados");
		Conexion.desconectar();
	}
	
	synchronized public static void insertaInformeUnico(PersonasInforme informe,Connection conex) {
		PreparedStatement stmt;
		try {
			stmt = conex.prepareStatement("INSERT INTO `personas_informe` (`id`, `id_ciudad`, `Nombre`, `Tipo`, `Infectado`) VALUES ('"+informe.getId()+"', '"+informe.getIdCiudad()+"', '"+informe.getNombre()+"', '"+informe.getTipo()+"', '"+informe.getInfectado()+"');");
			 
			 stmt.execute();
			 conex.commit();
		}catch(SQLException e) {
			log.fatal("Error al insertar un informe");
			e.printStackTrace();
		}
	}
	
	public static int getInfectados() { //He tardado mucho en este metodo, no me queda mucho para el opcional
		Connection conex = Conexion.getConexion();
		int resultado=-1;
		try {
			CallableStatement stmt = conex.prepareCall("{?=call get_num_pacientes()}");
			stmt.registerOutParameter(1, Types.INTEGER);
			stmt.execute();
			resultado = stmt.getInt(1);
			System.out.println(resultado);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.fatal("Error al consultar los infectados");
			e.printStackTrace();
		}
		
		log.info("Infectados obtenidos");
		
		return resultado;
		
	}
	
	

}
