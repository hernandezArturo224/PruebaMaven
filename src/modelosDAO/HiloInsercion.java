package modelosDAO;

public class HiloInsercion extends Thread{
	
	private int init;
	private int fin;
	
	public static int finTotal=0;
	
	
	
	public HiloInsercion(int init,int fin) {
		this.init=init;
		this.fin=fin;
	}
	
	
	public void run() {
		PersonasInformesDAO.insertaInformes(init, fin);
		
		
	}

}
