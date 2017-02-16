import java.net.DatagramPacket;
import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;

public class Logica implements Observer{
	private PApplet app;
	public int x, y, vel, color, id, send;
	public Comunicacion com;
	public String ip;
	String data;
	
	public Logica(PApplet app) {

		data="";
		this.app = app;
		com = new Comunicacion();
		com.addObserver(this);
		Thread hilo = new Thread(com);
		hilo.start();
		
		x = 20;
		y = app.height/2;
		vel = 0;
		id = 3;
		color = (int) app.random(255);
	}
	
	public void llegada() {
		String msg = "El jugador " + id + "llego";
//		com.enviar(msg, "228.5.6.7", 5000);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		DatagramPacket dPacket = (DatagramPacket) arg;
		 data = new String(dPacket.getData(), 0, dPacket.getLength());	
		System.out.println(data);
	}

	public void pintar() {
		// TODO Auto-generated method stu
		
		
		app.fill(10, color, 100);
		app.noStroke();
		app.ellipse(x, y, 20, 20);
		x += vel;
		
		if (data.equals("start")) {
			vel = (int) app.random(1,3);	
		}else if(data.equals("stop")){
			vel = 0;
		}
		
	}
	
	public void enviarM(){
//		com.enviar("start", ip, 5000);
	}
}
