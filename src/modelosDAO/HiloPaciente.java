package modelosDAO;
import controladores.ControladorPersonas;
import modelosVO.*;

public class HiloPaciente extends Thread{
	
	public static final int DORMIR_SUPER=1000;
	public static final int DORMIR_TRANSPORTE=500;
	public static final int DORMIR_CURRO=8000;
	
	private Pacientes paciente;
	
	
	public HiloPaciente(Pacientes pac) {
		this.paciente = pac;
	}
	
	public void run() {
		
		while(ControladorPersonas.stop) {
			tareasPaciente(paciente);
		}
		
		
	}
	
	private void tareasPaciente(Pacientes paciente) {
		int tareas;
		tareas = (int)(Math.random()*3);
		int i;
		for(i=0;i<=tareas;i++) {
			realizaTareaAleatoria(paciente);
			if(paciente.getInfectado() == 1) { //si nos infectamos salimos del bucle de tareas
				return;
			}
		}
		
	}
	
	private void realizaTareaAleatoria(Pacientes paciente) {
		int aleatorio;
		aleatorio= (int)(Math.random()*100);
		if(aleatorio < 33) {
			paciente.visitarSuper();
			try {
				Thread.sleep(DORMIR_SUPER);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(aleatorio > 33 && aleatorio < 66) {
			paciente.visitarTrabajo();
			try {
				Thread.sleep(DORMIR_CURRO);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			paciente.visitartransporte();
			try {
				Thread.sleep(DORMIR_TRANSPORTE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
