package funcionalidades;
import java.util.ArrayList;
import java.util.List;

public class ListaEtiquetas {
private List <String> ets=new ArrayList<String>();
private String [][] etiquetas = new String [7][2];

	public ListaEtiquetas() {
		this.agregar("/imagenes/azucar");			//0  112
		this.agregar("/imagenes/grasasTot");		//1  113
		this.agregar("/imagenes/grasasSat"); 		//2  114
		this.agregar("/imagenes/sodio");			//3  115
		this.agregar("/imagenes/calorias");		//4  116
		this.agregar("/imagenes/edulcorante");	//5  117
		this.agregar("/imagenes/cafeina");		//6  118
	}
	public void agregar(String i) {
		ets.add(i);
	}
	
	public List<String> getLista(){
		return ets;
	}
}
