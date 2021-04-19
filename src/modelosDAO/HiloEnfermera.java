package modelosDAO;

import java.util.Map;

import org.apache.log4j.Logger;

import modelosVO.*;
import controladores.*;
import logs.*;
public class HiloEnfermera extends Thread{
	public static final int DORMIR=1000;
	public Logger log;
	private Enfermeros enfermero;
	
		public HiloEnfermera(Enfermeros enfermero) {
			this.enfermero = enfermero;
			log = UsoLogger.getLogger(HiloEnfermera.class);
			
		}
		
		public void run() {
			while(ControladorPersonas.stop) {
				for(Map.Entry<Integer, Infectable> entrada: ControladorPersonas.pacientes.entrySet()) { //primera pasada, probabilidad de 2 entre 5
					Pacientes paciente = (Pacientes) entrada.getValue();
					if(paciente.getInfectado() == 1) { //si el paciente está infectado...
						int prob = (int)(Math.random()*5);
						if(prob <= 2 ) {
							this.enfermero.vacunar(paciente);
						}
					}//fin comprobaciones de vacunacion
				}//fin for
				
				for(Map.Entry<Integer, Infectable> entrada: ControladorPersonas.pacientes.entrySet()) { //primera pasada, probabilidad de 2 entre 5
					Pacientes paciente = (Pacientes) entrada.getValue();
					if(paciente.getInfectado() == 1) { //si el paciente está infectado...
						int prob = (int)(Math.random()*5);
						if(prob <= 1 ) {
							this.enfermero.vacunar(paciente);
						}
					}//fin comprobaciones de vacunacion
				}//fin for
				try {
					Thread.sleep(DORMIR);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					log.fatal("Error al hacer sleep ");
					e.printStackTrace();
				}
			}
			
			
		}

}
