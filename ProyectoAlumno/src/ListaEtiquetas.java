import java.util.ArrayList;
import java.util.List;

public class ListaEtiquetas {
private List <String> ets=new ArrayList<String>();

	public ListaEtiquetas() {
		this.agregar("<html>Exceso de<br>Grasas Totales</html>");	//0
		this.agregar("<html>Exceso de<br>Grasas Saturadas</html>"); 	//1
		this.agregar("<html>Exceso de<br>Calorias</html>");			//2
		this.agregar("<html>Exceso de<br>Azucar</html>");				//3
		this.agregar("<html>Exceso de<br>Sodio</html>");				//4
		this.agregar("<html>Contiene<br>Edulcorante</html>");			//5
	}
	
	public void agregar(String i) {
		ets.add(i);
	}
	
	public List<String> getLista(){
		return ets;
	}
}
