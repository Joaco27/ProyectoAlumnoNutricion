package funcionalidades;
import funcionalidades.*;
import java.util.ArrayList;
import java.util.Random;

import java.util.List;

public class ListaPersonajes {
	
	private List <Personaje> persons = new ArrayList<Personaje>();
	
	public ListaPersonajes() {
		Personaje p = new Personaje("Personaje Naranja");
		p.setPath("/imagenes/CartoonLittleKidOrange (1024x768).png");
		persons.add(p);
		
		p = new Personaje("Personaje Violeta");
		p.setPath("/imagenes/CartoonLittleKidViolet (1024x768).png");
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
