package funcionalidades;

import java.util.ArrayList;
import java.util.List;

public class ListaCategorias {
	
	//Categorias: 1. Frutas || 2. Lacteos || 3.Legumbres || 4. Carnes || 5. Semillas || 6.Procesados 

private List <Categoria> categories = new ArrayList<Categoria>();
	
	public ListaCategorias() {
		Categoria p = new Categoria("FrutasYVerduras Naranja");
		p.setPath("/imagenes/Categorias/FrutasYVerduras_Naranja.png");
		categories.add(p);
		
		p = new Categoria("FrutasYVerduras Violeta");
		p.setPath("/imagenes/Categorias/FrutasYVerduras_Violeta.png");
		categories.add(p);
		
		p = new Categoria("Lacteos Naranja");
		p.setPath("/imagenes/Categorias/Lacteos_Naranja.png");
		categories.add(p);
		
		p = new Categoria("Lacteos Violeta");
		p.setPath("/imagenes/Categorias/Lacteos_Violeta.png");
		categories.add(p);
		
		p = new Categoria("Legumbres Naranja");
		p.setPath("/imagenes/Categorias/LegumbresYCereales_Naranja.png");
		categories.add(p);
		
		p = new Categoria("Legumbres Violeta");
		p.setPath("/imagenes/Categorias/LegumbresYCereales_Violeta.png");
		categories.add(p);
		
		p = new Categoria("Carnes Naranja");
		p.setPath("/imagenes/Categorias/CarnesYHuevos_Naranja.png");
		categories.add(p);
		
		p = new Categoria("Carnes Violeta");
		p.setPath("/imagenes/Categorias/CarnesYHuevos_Violeta.png");
		categories.add(p);
		
		p = new Categoria("FrutosSecos Naranja");
		p.setPath("/imagenes/Categorias/FrutosSecos_Naranja.png");
		categories.add(p);
		
		p = new Categoria("FrutosSecos Violeta");
		p.setPath("/imagenes/Categorias/FrutosSecos_Violeta.png");
		categories.add(p);
		
		p = new Categoria("Procesados Naranja");
		p.setPath("/imagenes/Categorias/Procesados_Naranja.png");
		categories.add(p);
		
		p = new Categoria("Procesados Violeta");
		p.setPath("/imagenes/Categorias/Procesados_Violeta.png");
		categories.add(p);
		
	}
	
	public List<Categoria> getLista(){
		return categories;
	}
	
	public Categoria getCategoria(int i) {
		int x = i;
		Categoria p = this.categories.get(x);
		return p;
	}
	
	
}
