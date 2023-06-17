package Client;

import java.net.Socket;

public class Client {

	public Client() {
		
	}

	public void ClientStart(String host, int port) {
		
		try {
			
			Socket client = new Socket(host, port);
			ClientGiaoDien clientGiaoDien = new ClientGiaoDien();
			ClientThread clientThread = new ClientThread(client,clientGiaoDien);
			clientThread.start();
			clientGiaoDien.nhanThread(clientThread);
			clientGiaoDien.khoiDong();
						
			
		} catch (Exception e) {
			
		}

	}
	public void khoiDong() {
		
		try {
			
			ClientStart("localhost", 6665);
			
		} catch (Exception e) {

		}
	}
}
