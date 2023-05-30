package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread extends Thread {

	private Socket client;
	private DataOutputStream out;
	private String userName;
	private String passWord;
	private DataInputStream in;
	private String tinNhanNhan;
	private String tinNhanGui;
	private String trangThai;
	private Scanner sc;

	public ClientThread(Socket socket, String userName, String passWord, String trangThai) {
		this.client = socket;
		this.userName = userName;
		this.passWord = passWord;
		this.trangThai = trangThai;
	}

	public void nhanTinNhan() {
		tinNhanNhan = "";
		Thread threadDocTinNhan = new Thread(new Runnable() {

			@Override
			public void run() {
				while (!tinNhanNhan.equals("exit")) {
					try {
						synchronized (in) {
							tinNhanNhan = in.readUTF();
						}

//						if(tinNhanNhan=="-----") {
//							tinNhanNhan = in.readUTF();
//							System.out.println(tinNhanNhan);
//							String LuaChon = sc.nextLine();
//							if(LuaChon.equals("yes")) {
//								
//							}
//							out.writeUTF(tinNhanGui);
//						}

						System.out.println(tinNhanNhan);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
		threadDocTinNhan.start();
	}

	public void GuiNhanTinNhan() {

		tinNhanGui = "";
		Thread threadGuiTinNhan = new Thread(new Runnable() {

			@Override
			public void run() {
				while (!tinNhanGui.equals("exit")) {

					tinNhanGui = sc.nextLine();
					try {
						out.writeUTF(tinNhanGui);
						System.out.println("Ban: " + tinNhanGui);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});

		threadGuiTinNhan.start();
	}

	@Override
	public void run() {

		try {
			in = new DataInputStream(client.getInputStream());
			out = new DataOutputStream(client.getOutputStream());
			//
			sc = new Scanner(System.in);

			// gui userName va pass cho server
			if (trangThai.equals("dangNhap")) {
				out.writeUTF(trangThai);
				out.writeUTF(userName);
				out.writeUTF(passWord);

				// tra ve trang thai dang nhap

				String trangThaiDangNhap = in.readUTF();
				System.out.println(trangThaiDangNhap.equals("thanhcong"));
				if (trangThaiDangNhap.equals("thanhcong")) {
					ClientGiaoDien clientGiaoDien = new ClientGiaoDien();
					clientGiaoDien.thongBaoDangNhapThanhCong(userName);

				} else {
					ClientGiaoDien clientGiaoDien = new ClientGiaoDien();
					clientGiaoDien.thongBaoDangNhapKhongThanhCong();
				}

			} else if (trangThai.equals("dangKi")) {
				out.writeUTF(trangThai);
				out.writeUTF(userName);
				out.writeUTF(passWord);
				// tra ve trang thai dang nhap

				String trangThaiDangNhap = in.readUTF();
				System.out.println(trangThaiDangNhap.equals("thanhcong"));
				if (trangThaiDangNhap.equals("thanhcong")) {
					ClientGiaoDien clientGiaoDien = new ClientGiaoDien();
					clientGiaoDien.thongBaoDangKiThanhCong();

				} else {
					ClientGiaoDien clientGiaoDien = new ClientGiaoDien();
					clientGiaoDien.thongBaoDangKiKhongThanhCong();
				}

			} else if (trangThai.equals("guiTinNhan")) {
			
				out.writeUTF(trangThai);
				out.writeUTF(userName);
	
				System.err.println("Nhap ten nguoi dung muon ket noi");
				String NguoiDungKetNoi = sc.nextLine();

				out.writeUTF(NguoiDungKetNoi);
				nhanTinNhan();
				GuiNhanTinNhan();

			}

			System.out.println("-----------------------");

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
