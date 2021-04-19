package modelosVO;

public class PersonasInforme {

	private int id;
	private int id_ciudad;
	private String nombre;
	private String tipo;
	private short infectado;
	
	public PersonasInforme(int id,int id_ciudad,String nombre,String tipo,short infectado) {
		this.id = id;
		this.id_ciudad = id_ciudad;
		this.nombre = nombre;
		this.tipo = tipo;
		this.infectado = infectado;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getIdCiudad() {
		return this.id_ciudad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public short getInfectado() {
		return this.infectado;
	}
	
	
}
