import java.util.ArrayList;
import java.util.List;

public class ListaProductos {
	
	private List <Producto> products=new ArrayList<Producto>();
	
	public ListaProductos() {
		Producto p = new Producto(1);
		p.agregar(1);
		p.agregar(3);
		
		p = new Producto(2);
		p.agregar(0);
		p.agregar(2);
	}
	
	public List<Producto> getLista(){
		return products;
	}
	
	
}
