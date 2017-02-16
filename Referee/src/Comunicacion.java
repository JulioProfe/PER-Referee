import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Observable;

public class Comunicacion extends Observable implements Runnable{
	
	private MulticastSocket socket;
	private final int PUERTO = 5000;
	private final String GRUPO_ADDRESS = "228.5.6.7";
	private InetAddress ip;

	public Comunicacion() {
		try {
			System.out.println("Starting socket at port " + PUERTO);
			socket = new MulticastSocket(PUERTO);
			System.out.println("Joining to gruop " + GRUPO_ADDRESS);
			ip = InetAddress.getByName(GRUPO_ADDRESS);
			socket.joinGroup(ip);
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {
		while (true) {
			if (socket != null) {
				byte[] buffer = new byte[1024];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				try {
					    socket.receive(packet);
						setChanged();
						notifyObservers(packet);
						clearChanged();
				
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

