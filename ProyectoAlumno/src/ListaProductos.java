import java.util.ArrayList;
import java.util.Random;

import java.util.List;

public class ListaProductos {
	
	private List <Producto> products=new ArrayList<Producto>();
	
	public ListaProductos() {
		Producto p = new Producto("Queso Casancrem");
		p.agregar(112);
		p.agregar(113);
		p.agregar(116);
		p.setPath("/imagenes/casancrem.png");
		products.add(p);
		
		p = new Producto("ChocoArroz Blanco");
		p.agregar(112);
		p.agregar(113);
		p.agregar(114);
		p.agregar(115);
		p.setPath("/imagenes/chocoarroz-blanco.png");
		products.add(p);
		
		p = new Producto("Turron");
		p.agregar(114);
		p.agregar(115);
		p.setPath("/imagenes/turron.png");
		products.add(p);
		
		p = new Producto("Manzana");
		p.setPath("/imagenes/ManzanaD2.png");
		products.add(p);
		
		p = new Producto("Danonino");
		p.setPath("/imagenes/danonino.png");
		p.agregar(115);
		products.add(p);
		
		p = new Producto("Galletitas Traviata");
		p.setPath("/imagenes/galletitas-traviata.png");
		p.agregar(112);
		p.agregar(113);
		p.agregar(114);
		p.agregar(116);
		products.add(p);
		
		p = new Producto("Jugo Baggio");
		p.setPath("/imagenes/jugo-baggio.png");
		p.agregar(114);
		p.agregar(115);
		products.add(p);
		
		p = new Producto("Garoto");
		p.setPath("/imagenes/garoto.jpg");
		p.agregar(112);
		p.agregar(113);
		p.agregar(114);
		p.agregar(115);
		p.agregar(117);
		p.agregar(118);
		products.add(p);
	}
	
	public List<Producto> getLista(){
		return products;
	}
	
	public Producto getProducto() {
		Random r = new Random();
		int i = r.nextInt(this.products.size());
		Producto p = this.products.get(i);
		this.products.remove(i);
		return p;
	}
	
	public Producto getProducto(int i) {
		Producto p = this.products.get(i);
		return p;
	}
	
	
}
