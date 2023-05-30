package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;



public class Client {


	private String userName;
	private String passWord;
	private String trangThai;
	
	public Client(String userName,String passWord, String trangThai) {
		this.userName = userName;
		this.passWord = passWord;
		this.trangThai = trangThai;
	}

	public void ClientStart(String host, int port) {
		try {
			Socket client = new Socket(host, port);
			
				Thread th = new Thread(new ClientThread(client, userName, passWord, trangThai));
				th.start();
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void khoiDong() {
		try {
			ClientStart("localhost", 9999);
		} catch (Exception e) {

		}
	}
}
