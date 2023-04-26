package NoUsados;
import java.util.ArrayList;

import java.util.List;

import TUIO.*;

public class MyTuioListener implements TUIO.TuioListener{
	
	List <Integer> lista = new ArrayList <Integer>();
	List <Integer> listaActivos = new ArrayList <Integer>();
	TuioObject [] vector = new TuioObject[8];
	int cantElement = 0;

	@Override
	public void addTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void cargarLista() {
		// Del 1 al 4 seran vegetales, los otros carbohidratos
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
		lista.add(6);
		lista.add(7);
		lista.add(8);
	}

	@Override
	public void addTuioCursor(TuioCursor arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTuioObject(TuioObject tuioObj) {
		System.out.println("Aparecio el objeto: "+tuioObj.getSymbolID());
		this.cantElement += 1;
		this.vector[tuioObj.getSymbolID()-1] = tuioObj;
		this.listaActivos.add(tuioObj.getSymbolID());
		if (tuioObj.getSymbolID()>=1 && tuioObj.getSymbolID()<=4) {
			System.out.println("VERDURA");
		}
		else {
			System.out.println("CARBOHIDRATO");
		}
		
		//System.out.println("Angulo: "+tuioObj.getAngle());
		//System.out.println("Posicion X,Y: "+tuioObj.getX()+" , "+tuioObj.getY());
		
	}

	@Override
	public void refresh(TuioTime arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTuioCursor(TuioCursor arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTuioObject(TuioObject tuioObj) {
		System.out.println("Salio "+ tuioObj.getSymbolID());
		this.cantElement -= 1;
		int pos = this.listaActivos.indexOf(tuioObj.getSymbolID());
		this.listaActivos.remove(pos);
		this.vector[tuioObj.getSymbolID()-1] = null;
		/*if (this.cantElement==0) {
			System.out.println("No hay elementos en la mesa");
		}*/
		if (this.listaActivos.indexOf(5)!=-1 || this.listaActivos.indexOf(6)!=-1 ||
				this.listaActivos.indexOf(7)!=-1 || this.listaActivos.indexOf(8)!=-1) {
			System.out.println("AUN QUEDAN CARBOHIDRATOS");
		}
		else {
			if (this.listaActivos.size()>0) {
				System.out.println("PLATO SANO");
			}
		}
		
		
	}

	@Override
	public void updateTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTuioCursor(TuioCursor arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean estanTodasVerduras() {
		boolean ok1 = this.vector[0]!=null;
		boolean ok2 = this.vector[1]!=null;
		boolean ok3 = this.vector[2]!=null;
		boolean ok4 = this.vector[3]!=null;
		return ok1 && ok2 && ok3 && ok4;
	}
	
	public boolean estaEnElPlato(TuioObject to) {
		return to.getX()>=0.4 && to.getX()<=0.8 && to.getY()>=0.6;
	}
	
	@Override
	public void updateTuioObject(TuioObject tuioObj) {
		boolean plato = true;
		this.vector[tuioObj.getSymbolID()-1] = tuioObj;
		if (this.estanTodasVerduras()) {
			for (int i=0; i<4; i++) {
				plato = plato && this.estaEnElPlato(this.vector[i]);
			}
			if (plato) {
				System.out.println("PLATO LLENO DE VERDURAS");
			}
		}
		/*float x, y;
		x = tuioObj.getX(); 
		y = tuioObj.getY(); 
		System.out.println("Posicion X,Y: "+tuioObj.getX()+" , "+tuioObj.getY());
		if (x > 0.5 && y < 0.5) {
			System.out.println("Cuadrante 1");
		}
		else {
			if (x < 0.5 && y < 0.5) {
				System.out.println("Cuadrante 2");
			}
			else {
				if (x < 0.5 && y > 0.5) {
					System.out.println("Cuadrante 3");
				}
				else {
					System.out.println("Cuadrante 4");
				}
			}
		}*/
	}

}
