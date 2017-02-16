import java.net.InetAddress;
import java.net.UnknownHostException;

import processing.core.PApplet;

public class Main extends PApplet{
	private Logica log;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");
	}
	
	public void settings() {
		size(500, 300);
	}
	
	public void setup() {
		log = new Logica(this);
		// TODO Auto-generated method stub
		try {
			System.out.println(InetAddress.getLocalHost());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void draw() {
		// TODO Auto-generated method stub
		background(0);
		log.pintar();
		}

}
