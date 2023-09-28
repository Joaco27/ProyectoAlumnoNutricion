package funcionalidades;
import java.util.ArrayList;
import java.util.Random;

import java.util.List;

public class ListaPersonajes {
	
	private List <Personaje> persons = new ArrayList<Personaje>();
	
	public ListaPersonajes() {
		/*Personaje p = new Personaje("Personaje Naranja");
		p.setPath("/imagenes/Pj/canionO(Vacio).png");
		persons.add(p);
		
		p = new Personaje("Personaje Violeta");
		p.setPath("/imagenes/Pj/canionV(Vacio).png");
		persons.add(p);*/
		
		Personaje p = new Personaje("Personaje Naranja");
		p.setPath("/imagenes/Pj/canionO(2Tercios).png");
		persons.add(p);
		
		p = new Personaje("Personaje Violeta");
		p.setPath("/imagenes/Pj/canionV(2Tercios).png");
		persons.add(p);
		
		p = new Personaje("Personaje Naranja");
		p.setPath("/imagenes/Pj/canionO(Lleno).png");
		persons.add(p);
		
		p = new Personaje("Personaje Violeta");
		p.setPath("/imagenes/Pj/canionV(Lleno).png");
		persons.add(p);
		
		p = new Personaje("Personaje Naranja");
		p.setPath("/imagenes/Pj/canionO(1Tercio).png");
		persons.add(p);
		
		p = new Personaje("Personaje Violeta");
		p.setPath("/imagenes/Pj/canionV(1Tercio).png");
		persons.add(p);
		
	}
	
	public List<Personaje> getLista(){
		return persons;
	}
	
	public Personaje getPersonaje(int i) {
		int x = i;
		Personaje p = this.persons.get(x);
		return p;
	}
	
	
}
