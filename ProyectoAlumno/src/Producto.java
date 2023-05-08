import java.util.ArrayList;
import java.util.List;

public class Producto {
	
	private int id;
	private List <Integer> etiquetas;
	private String path;
	public Producto(int id) {
		super();
		this.id = id;
		this.etiquetas = new ArrayList <Integer>();
	}
	public int getId() {
		return id;
	}
	public List<Integer> getEtiquetas() {
		return etiquetas;
	}
	
	public void agregar(int i) {
		etiquetas.add(i);
	}
	
	public void setPath(String p) {
		this.path=p;
	}
	
}
