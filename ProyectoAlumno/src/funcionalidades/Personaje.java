package funcionalidades;

public class Personaje {
	
	private String id;
	private int X;
	private int Y;
	private String path;
	
	public Personaje(String id) {
		super();
		this.id = id;
	}
	
	public void setX(int cordX) {
		this.X = cordX;
	}
	
	public void setY(float cordY) {
		int alto = 768;
		int posY = (int)(cordY * alto)-50;
		this.Y = posY;
	}
	
	public int getX() {
		
		return X;
	}
	
	public int getY() {

		return Y;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String p) {
		
		this.path=p;
	}
	
}