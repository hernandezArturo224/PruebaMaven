package controladores;
import modelosVO.*;

import modelosDAO.*;
import java.util.*;

import basedatos.Conexion;


public class ControladorPersonas {
	
	public static HashMap<Integer,Vacunable> enfermeros = new HashMap<Integer,Vacunable>();
	public static HashMap<Integer,Infectable> pacientes = new HashMap<Integer,Infectable>();
	private static boolean enfermeroActivo = false;
	
	public static boolean stop=true;
	
	
	public static void muestraPersonasFromCiudad(int id_ciudad) {
		ArrayList<Personas> personas = PersonasDAO.getPersonasFromCiudad(id_ciudad);
		
		Iterator<Personas> it = personas.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getDatosPrincipales());
		}
	}
	
	
	public static void rellenaEnfermerosPacientesFromCiudad(int id_ciudad) {
		ArrayList<Personas> personas = PersonasDAO.getPersonasFromCiudad(id_ciudad);
		Iterator<Personas> it = personas.iterator();
		while(it.hasNext()) {
			Personas persona = it.next();
			if(persona.getTipo().equals("E")) {
				Enfermeros enfermero = new Enfermeros(persona.getId(),persona.getIdCiudad(),persona.getNombre(),persona.getTipo(),persona.getInfectado());
				enfermeros.put(enfermero.getId(), enfermero);
			}else {
				Pacientes paciente = new Pacientes(persona.getId(),persona.getIdCiudad(),persona.getNombre(),persona.getTipo(),persona.getInfectado());
				pacientes.put(paciente.getId(), paciente);
			}
			
		}
		System.out.println("Enfermeros/Pacientes actualizados");
	}
	
	
	private static Enfermeros getEnfermero() {//usamos una pila para este metodo
		if(!enfermeroActivo) {
			Stack<Vacunable> pila = new Stack<Vacunable>();
			for(Map.Entry<Integer, Vacunable> entrada: enfermeros.entrySet()) {
				pila.add(entrada.getValue());
			}
			
			return (Enfermeros) pila.pop(); //extraemos el ultimo que entro de la pila
		}else {
			System.out.println("Ya hay un enfermero");
			return null;
		}
		
		
	}
	
	public static void simularDia() {
		for(Map.Entry<Integer, Infectable> entrada: pacientes.entrySet()) {
			Pacientes paciente = (Pacientes) entrada.getValue();
			HiloPaciente pacienteHilo = new HiloPaciente(paciente);
			pacienteHilo.start();
		}
		
		Enfermeros enfermera = getEnfermero(); //obtenemos el ultimo enfermero de la pila
		
		HiloEnfermera enfermeraHilo = new HiloEnfermera(enfermera);
		enfermeraHilo.setDaemon(true);
		enfermeraHilo.start();
		
		
		
	}//fin simulacion
	
	public static void generarInformes() {
		int total = getSizeInformes();
		int partes = total/4;
		
		HiloInsercion hilo1 = new HiloInsercion(0,partes);
		HiloInsercion hilo2 = new HiloInsercion(partes,partes*2);
		HiloInsercion hilo3 = new HiloInsercion(partes*2,partes*3);
		HiloInsercion hilo4 = new HiloInsercion(partes*3,total);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		
	}
	
	public static void muestraPacientes() {
		for(Map.Entry<Integer, Infectable> entrada: pacientes.entrySet()) {
			Pacientes paciente = (Pacientes) entrada.getValue();
			System.out.println(paciente.getDatosPrincipales());
		}
	}
	
	
	private static int getSizeInformes() {
		return pacientes.size();
	}
	
	public static void muestraInfectados() {
		System.out.println("Hay "+PersonasInformesDAO.getInfectados()+" personas infectadas en esta ciduad");
	}
	

}
