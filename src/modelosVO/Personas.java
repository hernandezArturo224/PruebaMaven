package modelosVO;

public class Personas {
	
	private int id;
	private int id_ciudad;
	private String nombre;
	private String tipo;
	private short infectado;
	
	public Personas(int id,int id_ciudad,String nombre,String tipo,short infectado) {
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
	
	
	public void setInfectado(boolean infectado) {
		if(infectado) {
			this.infectado = 1;
		}else {
			this.infectado = 0;
		}
	}
	
	public String getDatosPrincipales() {
		StringBuilder builder = new StringBuilder("ID: ");
		builder.append(this.id);
		builder.append("\n");
		builder.append("ID CIUDAD: ");
		builder.append(this.id_ciudad);
		builder.append("\n");
		builder.append("Nombre: ");
		builder.append(this.nombre);
		builder.append("\n");
		builder.append("Tipo: ");
		builder.append(this.tipo);
		builder.append("\n");
		builder.append("INFECTADO: ");
		builder.append(this.infectado);
		builder.append("\n");
		
		
		return builder.toString();
	}

}
