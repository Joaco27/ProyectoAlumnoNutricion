package funcionalidades;
import java.util.ArrayList;
import java.util.List;

public class ListaEtiquetas {
private List <String> ets=new ArrayList<String>();
private String [][] etiquetas = new String [7][2];

	public ListaEtiquetas() {
		this.agregar("/imagenes/Sellos/azucar");			//0  112
		this.agregar("/imagenes/Sellos/grasasTot");			//1  113
		this.agregar("/imagenes/Sellos/grasasSat"); 		//2  114
		this.agregar("/imagenes/Sellos/sodio");				//3  115
		this.agregar("/imagenes/Sellos/calorias");			//4  116
		this.agregar("/imagenes/Sellos/edulcorante");		//5  117
		this.agregar("/imagenes/Sellos/cafeina");			//6  118
	}
	public void agregar(String i) {
		ets.add(i);
	}
	
	public List<String> getLista(){
		return ets;
	}
}
