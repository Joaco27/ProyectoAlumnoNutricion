package funcionalidades;
import java.util.ArrayList;
import java.util.Random;

import java.util.List;

public class ListaProductosD2 {
	
	
	private List <Producto> products=new ArrayList<Producto>();
	
	//Categorias: 1. Frutas y Verduras|| 2. Lacteos || 3.Legumbres || 4. Carnes || 5. Semillas || 6.Procesados 
	
	public ListaProductosD2() {
		Producto p = new Producto("Queso Casancrem");
		p.setPath("/imagenes/Productos/casancrem.png");
		p.setCategoria(2);
		products.add(p);
		
		p = new Producto("ChocoArroz Blanco");
		p.setPath("/imagenes/Productos/chocoArrozBlanco.png");
		p.setCategoria(6);
		products.add(p);
		
		p = new Producto("Turron");
		p.setPath("/imagenes/Productos/turron.png");
		p.setCategoria(6);
		products.add(p);
		
		p = new Producto("Manzana");
		p.setPath("/imagenes/Productos/Manzana(768x1024).png");
		p.setCategoria(1);
		products.add(p);
		
		p = new Producto("Danonino");
		p.setPath("/imagenes/Productos/danonino.png");
		p.setCategoria(2);
		products.add(p);
		
		p = new Producto("Huevos");
		p.setPath("/imagenes/Productos/huevos.png");
		p.setCategoria(4);
		products.add(p);
		
		p = new Producto("Galletitas Traviata");
		p.setPath("/imagenes/Productos/traviata.png");
		p.setCategoria(6);
		products.add(p);
		
		p = new Producto("Arroz");
		p.setPath("/imagenes/Productos/arroz.png");
		p.setCategoria(3);
		products.add(p);
		
		p = new Producto("Jugo Baggio");
		p.setPath("/imagenes/Productos/baggio.png");
		p.setCategoria(6);
		products.add(p);
		
		p = new Producto("Almendras");
		p.setPath("/imagenes/Productos/almendras.png");
		p.setCategoria(5);
		products.add(p);
		
		p = new Producto("Garoto");
		p.setPath("/imagenes/Productos/garoto.png");
		p.setCategoria(6);
		products.add(p);
		
		p = new Producto("Palta");
		p.setPath("/imagenes/Productos/palta.png");
		p.setCategoria(1);
		products.add(p);
		
		p = new Producto("Apio");
		p.setPath("/imagenes/Productos/apio.png");
		p.setCategoria(1);
		products.add(p);
		
		p = new Producto("Bananas");
		p.setPath("/imagenes/Productos/Bananas.png");
		p.setCategoria(1);
		products.add(p);
		
		p = new Producto("Lechuga");//15
		p.setPath("/imagenes/Productos/lechuga.png");
		p.setCategoria(1);
		products.add(p);
		
		p = new Producto("Aceite de Girasol");
		p.setPath("/imagenes/Productos/Aceite.png");
		p.setCategoria(5);
		products.add(p);
		
		p = new Producto("Aceite de Oliva");
		p.setPath("/imagenes/Productos/Aceite Oliva.png");
		p.setCategoria(5);
		products.add(p);
		
		p = new Producto("Chia");
		p.setPath("/imagenes/Productos/Chia.png");
		p.setCategoria(5);
		products.add(p);
		
		p = new Producto("Quinoa");
		p.setPath("/imagenes/Productos/quinoa.png");
		p.setCategoria(3);
		products.add(p);
		
		p = new Producto("Frutos Secos");//20
		p.setPath("/imagenes/Productos/frutosSecos.png");
		p.setCategoria(5);
		products.add(p);
		
		p = new Producto("Porotos");
		p.setPath("/imagenes/Productos/Porotos.png");
		p.setCategoria(3);
		products.add(p);
		
		p = new Producto("Arvejas");
		p.setPath("/imagenes/Productos/arvejas.png");
		p.setCategoria(3);
		products.add(p);
		
		p = new Producto("queso");
		p.setPath("/imagenes/Productos/queso.png");
		p.setCategoria(2);
		products.add(p);
		
		p = new Producto("queso brie");
		p.setPath("/imagenes/Productos/Brie Cheese.png");
		p.setCategoria(2);
		products.add(p);
		
		p = new Producto("queso rallado");//25
		p.setPath("/imagenes/Productos/Queso Rallado.png");
		p.setCategoria(2);
		products.add(p);
		
		p = new Producto("Leche");
		p.setPath("/imagenes/Productos/leche.png");
		p.setCategoria(2);
		products.add(p);
		
		p = new Producto("cerdo");
		p.setPath("/imagenes/Productos/Cerdo.png");
		p.setCategoria(4);
		products.add(p);
		
		p = new Producto("Pechuga");
		p.setPath("/imagenes/Productos/Pechuga.png");
		p.setCategoria(4);
		products.add(p);
		
		p = new Producto("Res");
		p.setPath("/imagenes/Productos/Res.png");
		p.setCategoria(4);
		products.add(p);
		
		p = new Producto("Salmon");//30
		p.setPath("/imagenes/Productos/salmon.png");
		p.setCategoria(4);
		products.add(p);
		
		p = new Producto("patitas");
		p.setPath("/imagenes/Productos/patitas.png");
		p.setCategoria(6);
		products.add(p);
		
	}
	
	//Categorias: 1. Frutas y Verduras|| 2. Lacteos || 3.Legumbres || 4. Carnes || 5. Semillas || 6.Procesados 
	
	
	public Producto getProducto() {
		Random r = new Random();
		int i = r.nextInt(this.products.size());
		Producto p = this.products.get(i);
	//	this.products.remove(i);
		return p;
	}
//	
	public Producto getProducto(int i) {
		Producto p = this.products.get(i);
		return p;
	}
	
	
}
