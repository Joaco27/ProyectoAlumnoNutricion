package funcionalidades;
public class Puntaje {
	private int equipoV=0, equipoO=0;
	private String ultimo="";
	private boolean primeraVez=true;
	
	public int getEquipoV() {
		return equipoV;
	}

	public void aumentarEquipoV(int equipoV) {
		this.equipoV += equipoV;
	}
	
	public void setUltimoGanador(String ult) {
		this.ultimo=ult;
	}
	
	public String getUltimoGanador() {
		return this.ultimo;
	}

	public int getEquipoO() {
		return equipoO;
	}

	public void aumentarEquipoO(int equipoO) {
		this.equipoO += equipoO;
	}
	
	public void resetear() {
		this.equipoO=0;
		this.equipoV=0;
	}

	public boolean getPrimeraVez() {
		return primeraVez;
	}

	public void setPrimeraVez(boolean primeraVez) {
		this.primeraVez = primeraVez;
	}
	
	
	
	
}
