package modelosVO;
import java.util.*;

public interface Vacunable {
	
	void vacunar(Infectable infectado);
	
	void vacunar(HashMap<Integer,Infectable> coleccion);

}
