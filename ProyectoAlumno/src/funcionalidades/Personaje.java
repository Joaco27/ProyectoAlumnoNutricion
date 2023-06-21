package funcionalidades;

public class Personaje {
	
	private String id;
	private String path;
	
	public Personaje(String id) {
		super();
		this.id = id;
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
