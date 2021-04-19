package vistas;
import javax.swing.JOptionPane;

import controladores.*;
import modelosDAO.PersonasInformesDAO;
import modelosVO.*;

public class VistaPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//para probar usar la ciudad 9 que si tiene enfermeros
		
		int id_ciudad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la ciudad que quieres consultar"));
		ControladorPersonas.rellenaEnfermerosPacientesFromCiudad(id_ciudad);
		
		//Enfermeros enfermero = (Enfermeros) ControladorPersonas.enfermeros.get(7);
		//System.out.println(enfermero.getDatosPrincipales());
		
		ControladorPersonas.simularDia();
		
		//Pacientes paciente = (Pacientes)ControladorPersonas.pacientes.get(512);
		
		ControladorPersonas.muestraPacientes();
		
		
		//ControladorPersonas.generarInformes();
		
		ControladorPersonas.muestraInfectados();
		
		JOptionPane.showMessageDialog(null, "Pulsa OK para parar los hilos");
		
		ControladorPersonas.stop = false;
		ControladorPersonas.muestraPacientes();
		
		
		
		

	}

}
