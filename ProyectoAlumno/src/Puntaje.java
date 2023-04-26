
public class Puntaje {
	private int equipoV, equipoO;

	public Puntaje() {
		super();
		this.equipoV = 0;
		this.equipoO = 0;
	}

	public int getEquipoV() {
		return equipoV;
	}

	public void aumentarEquipoV(int equipoV) {
		this.equipoV += equipoV;
	}

	public int getEquipoO() {
		return equipoO;
	}

	public void aumentarEquipoO(int equipoO) {
		this.equipoO += equipoO;
	}
	
	
	
	
}
