package modelosVO;

public class Pacientes extends Personas implements Infectable, Moveable{
	public int prob_super=10;
	public int prob_trabajo=12;
	public int prob_transporte=16; //lo dejo como variable normal, sin ser estatica ni final
									//porque si se vacuna, seria logico que al vacuna bajase la probabilidad de infeccion de cada objeto paciente
									//o al menos yo lo veo así vaya
	
	public Pacientes(int id, int id_ciudad, String nombre, String tipo,short infectado) {
		super(id,id_ciudad,nombre,tipo,infectado);
	}

	@Override
	public void infectar(boolean infectado) {
		super.setInfectado(infectado);
	}

	@Override
	public void visitarSuper() {
		int probabilidad = (int)(Math.random()*100);
		if(probabilidad <= this.prob_super) {
			this.infectar(true);
		}else {
			this.infectar(false);
		}
		
	}

	@Override
	public void visitarTrabajo() {
		// TODO Auto-generated method stub
		int probabilidad = (int)Math.random()*100;
		if(probabilidad <= this.prob_trabajo) {
			this.infectar(true);
		}else {
			this.infectar(false);
		}
		
	}

	@Override
	public void visitartransporte() {
		// TODO Auto-generated method stub
		int probabilidad = (int)Math.random()*100;
		if(probabilidad <= this.prob_transporte) {
			this.infectar(true);
		}else {
			this.infectar(false);
		}
		
	}

}
