package modelosVO;

import java.util.HashMap;
import java.util.Map;

public class Enfermeros extends Personas implements Vacunable{

	public Enfermeros(int id, int id_ciudad, String nombre, String tipo,short infectado) {
		super(id,id_ciudad,nombre,tipo,infectado);
	}

	@Override
	public void vacunar(Infectable infectado) {
		// TODO Auto-generated method stub
		infectado.infectar(false); //cambiamos la infeccion a false, si no esta infectado y esta vacunado pues se queda como false
		
	}

	@Override
	public void vacunar(HashMap<Integer, Infectable> paciente) {
		// TODO Auto-generated method stub
		for(Map.Entry<Integer, Infectable> entrada: paciente.entrySet()) {
			this.vacunar(entrada.getValue()); //vacunamos a cada paciente
		}
		
	}
	
}
