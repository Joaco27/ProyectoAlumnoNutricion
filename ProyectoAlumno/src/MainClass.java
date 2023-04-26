

public class MainClass {

	public static void main(String[] args) {
		//CustomTUIOListener customTUIOListener = new CustomTUIOListener();
		//MyTuioListener listener = new MyTuioListener();
		TuioClient client = new TuioClient();
		ListenerMP listenerInter = new ListenerMP(client,0,0);
		//client.addTuioListener(listener);
		//client.addTuioListener(customTUIOListener);
		client.addTuioListener(listenerInter);
		client.connect();
		//System.out.println(client.isConnected());
		
		
	}

}
