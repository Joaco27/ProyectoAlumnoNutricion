import java.util.ArrayList;
import java.util.List;

public class ListaEtiquetas {
private List <String> ets=new ArrayList<String>();

	public ListaEtiquetas() {
		this.agregar("/imagenes/ExcesoGrasasTot.png");		//0  112
		this.agregar("/imagenes/ExcesoGrasasSat.png"); 		//1  113
		this.agregar("/imagenes/ExcesoCalorias.png");		//2  114
		this.agregar("/imagenes/ExcesoAzucar.png");			//3  115
		this.agregar("/imagenes/ExcesoSodio.png");			//4  116
		this.agregar("/imagenes/contieneEdulcorante.png");	//5  117
		this.agregar("/imagenes/contieneEdulcorante.png");	//6  118
	}
	
	public void agregar(String i) {
		ets.add(i);
	}
	
	public List<String> getLista(){
		return ets;
	}
}
