import java.util.ArrayList;
import java.util.List;

public class ListaEtiquetas {
private List <String> ets=new ArrayList<String>();

	public ListaEtiquetas() {
		//Cargar Etiquetas
	}
	
	public void agregar(String i) {
		ets.add(i);
	}
	
	public List<String> getLista(){
		return ets;
	}
}
