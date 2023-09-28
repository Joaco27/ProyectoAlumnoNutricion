package funcionalidades;

public class Categoria {
	
	private String id;
	private int X;
	private int Y;
	private String path;
	
	public Categoria(String id) {
		super();
		this.id = id;
	}
	
	public void setX(int cordX) {
		this.X = cordX;
	}
	
	public void setY(int cordY) {
		this.Y = cordY;
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