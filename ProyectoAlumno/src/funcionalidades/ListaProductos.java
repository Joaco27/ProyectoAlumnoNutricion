package funcionalidades;
import java.util.ArrayList;
import java.util.Random;

import java.util.List;

public class ListaProductos {
	
	private List <Producto> products=new ArrayList<Producto>();
	
	public ListaProductos() {
		Producto p = new Producto("Queso Casancrem Light");
		p.agregar(113);
		p.agregar(114);
		p.agregar(115);
		p.setPath("/imagenes/Productos/casancremLight.png");
		products.add(p);
		
		p = new Producto("Queso Casancrem");
		p.agregar(113);
		p.agregar(114);
		p.setPath("/imagenes/Productos/casancrem.png");
		products.add(p);
		
		p = new Producto("ChocoArroz Negro");
		p.agregar(112);
		p.agregar(113);
		p.agregar(114);
		p.agregar(116);
		p.setPath("/imagenes/Productos/chocoArrozNegro.png");
		products.add(p);
		
		p = new Producto("ChocoArroz Blanco");
		p.agregar(112);
		p.agregar(113);
		p.agregar(114);
		p.agregar(116);
		p.setPath("/imagenes/Productos/chocoArrozBlanco.png");
		products.add(p);
		
		p = new Producto("Zucaritas");
		p.setPath("/imagenes/Productos/cereales.png");
		p.agregar(112);
		p.agregar(116);
		products.add(p);
		
		p = new Producto("Cindor");
		p.agregar(112);
		p.setPath("/imagenes/Productos/cindor.png");
		products.add(p);
		
		p = new Producto("Danonino");
		p.agregar(112);
		p.setPath("/imagenes/Productos/danonino.png");
		products.add(p);
		
		p = new Producto("Manzana");
		p.setPath("/imagenes/Productos/ManzanaD2.png");
		products.add(p);
		
		p = new Producto("Huevos");
		p.setPath("/imagenes/Productos/huevos.png");
		products.add(p);
		
		p = new Producto("Frutos Secos");
		p.setPath("/imagenes/Productos/frutosSecos.png");
		products.add(p);
		
		p = new Producto("Palta");
		p.setPath("/imagenes/Productos/palta.png");
		products.add(p);
		
		p = new Producto("CerealMix");
		p.setPath("/imagenes/Productos/cereal.png");
		p.agregar(112);
		p.agregar(116);
		products.add(p);
		
//		p = new Producto("Hogarenas");
//		p.setPath("/imagenes/Productos/hogarenas.png");
//		p.agregar(113);
//		p.agregar(114);
//		p.agregar(115);
//		p.agregar(116);
//		products.add(p);
		
		p = new Producto("Traviata");
		p.setPath("/imagenes/Productos/traviata.png");
		p.agregar(113);
		p.agregar(114);
		p.agregar(115);
		p.agregar(116);
		products.add(p);
		
		p = new Producto("Jugo Baggio");
		p.setPath("/imagenes/Productos/baggio.png");
		p.agregar(112);
		p.agregar(116);
		products.add(p);
		
		p = new Producto("Surtidas");
		p.setPath("/imagenes/Productos/surtidas.png");
		p.agregar(112);
		p.agregar(113);
		p.agregar(114);
		p.agregar(116);
		products.add(p);
		
		p = new Producto("Garoto");
		p.setPath("/imagenes/Productos/garoto.png");
		p.agregar(112);
		p.agregar(113);
		p.agregar(114);
		p.agregar(115);
		p.agregar(116);
		products.add(p);
		
		p = new Producto("Mermelada");
		p.setPath("/imagenes/Productos/mermelada.png");
		p.agregar(112);
		products.add(p);
		
		p = new Producto("Jugo Exp");
		p.setPath("/imagenes/Productos/jugoExp.png");
		p.agregar(112);
		products.add(p);
		
		p = new Producto("Gelatina");
		p.setPath("/imagenes/Productos/gelatina.png");
		p.agregar(115);
		p.agregar(117);
		products.add(p);
		
		p = new Producto("Quick");
		p.setPath("/imagenes/Productos/quick.png");
		p.agregar(115);
		products.add(p);
		
		p = new Producto("Patitas");
		p.setPath("/imagenes/Productos/patitas.png");
		p.agregar(113);
		p.agregar(115);
		p.agregar(116);
		products.add(p);

		p = new Producto("Salchcichas");
		p.setPath("/imagenes/Productos/salchichas.png");
		p.agregar(113);
		p.agregar(114);
		p.agregar(115);
		products.add(p);
		
		p = new Producto("Turron");
		p.setPath("/imagenes/Productos/turron.png");
		p.agregar(112);
		p.agregar(116);
		products.add(p);
		
		p = new Producto("Yogur");
		p.setPath("/imagenes/Productos/yogur.png");
		p.agregar(112);
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
//	
	public Producto getProducto(int i) {
		Producto p = this.products.get(i);
		return p;
	}
	
	
}
