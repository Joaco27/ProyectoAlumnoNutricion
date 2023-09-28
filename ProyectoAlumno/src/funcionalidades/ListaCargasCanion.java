package funcionalidades;
import java.util.ArrayList;
import java.util.Random;

import java.util.List;

public class ListaCargasCanion {
	
	private List <Personaje> persons = new ArrayList<Personaje>();
	
	public ListaCargasCanion() {
		/*Personaje p = new Personaje("Personaje Naranja");
		p.setPath("/imagenes/Pj/canionO(Vacio).png");
		persons.add(p);
		
		p = new Personaje("Personaje Violeta");
		p.setPath("/imagenes/Pj/canionV(Vacio).png");
		persons.add(p);*/
		
		Personaje p = new Personaje("Personaje Naranja");
		p.setPath("/imagenes/Pj/CargacanionO(2Tercios).png");
		persons.add(p);
		
		p = new Personaje("Personaje Violeta");
		p.setPath("/imagenes/Pj/CargacanionV(2Tercios).png");
		persons.add(p);
		
		p = new Personaje("Personaje Naranja");
		p.setPath("/imagenes/Pj/CargacanionO(Lleno).png");
		persons.add(p);
		
		p = new Personaje("Personaje Violeta");
		p.setPath("/imagenes/Pj/CargacanionV(Lleno).png");
		persons.add(p);
		
		p = new Personaje("Personaje Naranja");
		p.setPath("/imagenes/Pj/CargacanionO(1Tercio).png");
		persons.add(p);
		
		p = new Personaje("Personaje Violeta");
		p.setPath("/imagenes/Pj/CargacanionV(1Tercio).png");
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
