package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientThread extends Thread {

	private Socket client;
	private DataOutputStream out;
	private String userName;
	private DataInputStream in;
	private String tinNhanNhan;
	private ClientGiaoDien clientGiaoDien;
	private String locTin;
	private String locTin1;
	private String time;
	private String tinNhan;
	private String user1;
	private String user2;

	public ClientThread(Socket socket, ClientGiaoDien clientGiaoDien) {

		this.client = socket;
		this.clientGiaoDien = clientGiaoDien;

	}

	public void xuLyDangNhap(String userName, String passWord) {

		this.userName = userName;
		
		try {
			
			out.writeUTF("dangNhap");
			out.writeUTF(userName);
			out.writeUTF(passWord);
			String trangThaiDangNhap = in.readUTF();
			System.out.println(trangThaiDangNhap.equals("thanhcong"));
			
			if (trangThaiDangNhap.equals("thanhcong")) {
				
				clientGiaoDien.trangNguoiDung();
				clientGiaoDien.thongBaoDangNhapThanhCong();
				xuLyServer();

			} else {

				clientGiaoDien.thongBaoDangNhapKhongThanhCong();
			}
		} catch (IOException e) {
			
		}

	}

	public void xuLyDangKy(String userName, String passWord) {
		try {
			
			out.writeUTF("dangKi");
			out.writeUTF(userName);
			out.writeUTF(passWord);
			
			// tra ve trang thai dang nhap
			String trangThaiDangNhap = in.readUTF();
			System.out.println(trangThaiDangNhap.equals("thanhcong"));
			if (trangThaiDangNhap.equals("thanhcong")) {

				clientGiaoDien.thongBaoDangKiThanhCong();

			} else {

				clientGiaoDien.thongBaoDangKiKhongThanhCong();
				
			}
		} catch (Exception e) {

		}

	}

	public void xuLyServer() {
		
		try {
			
			System.out.println(userName);
			out.writeUTF("nhanThongTin");
			out.writeUTF(userName);
			nhanTinNhan();

		} catch (Exception e) {
			
		}

	}

	public void guiNhanTinNhan(String tinNhan, String userGui, String userNhan) {
		
		try {
			
			out.writeUTF("guiTinNhan");
			out.writeUTF(tinNhan);
			out.writeUTF(userGui);
			out.writeUTF(userNhan);

		} catch (Exception e) {

		}

	}

	public void layTinNhanTuServer(String userGui, String userNhan) {

		try {
			out.writeUTF("layTinNhanTuCSDL");
			out.writeUTF(userGui);
			out.writeUTF(userNhan);

		} catch (Exception e) {

		}

	}

	public void timNguoiDung(String str) {

		try {
			out.writeUTF("timNguoiDung");
			out.writeUTF(str);

		} catch (Exception e) {

		}

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

							try {
								
								locTin = tinNhanNhan.substring(0, 20);
								locTin1 = tinNhanNhan.substring(0, 4);
								
							} catch (Exception e) {

							}

							if (locTin.equals("themNguoiDungVaoList")) {
								tinNhanNhan = tinNhanNhan.replace("themNguoiDungVaoList ", "");
								clientGiaoDien.addListNguoiDungOnline(tinNhanNhan);

							} else if (locTin.equals("xoaNguoiDungKhoiList")) {
								tinNhanNhan = tinNhanNhan.replace("xoaNguoiDungKhoiList ", "");
								clientGiaoDien.removeList(tinNhanNhan);

							} else if (locTin1.equals("Time")) {
								
								try {
									
									time = tinNhanNhan.split("\\[")[1].split("]")[0];
									tinNhan = tinNhanNhan.split("TinNhan\\[")[1].split("]")[0];
									user1 = tinNhanNhan.split("user1\\[")[1].split("]")[0];
									user2 = tinNhanNhan.split("user2\\[")[1].split("]")[0];
									
								} catch (Exception e) {

								}
								
								String output = insertCharacter(tinNhan, "<br>", 42);
								clientGiaoDien.addTinNhan(output, user1, user2, time);

							} else if (tinNhanNhan.equals("resetMess00000000000")) {
								clientGiaoDien.resetPanelXemTinNhan();

							} else if (locTin.equals("themNguoiDungcu List")) {
								tinNhanNhan = tinNhanNhan.replace("themNguoiDungcu List ", "");
								clientGiaoDien.addListNguoiDungDaNhanTin(tinNhanNhan);
								
							} else if (locTin.equals("guiVeNguoiDungCanTim")) {
								tinNhanNhan = tinNhanNhan.replace("guiVeNguoiDungCanTim ", "");
								clientGiaoDien.addListTimNguoiDung(tinNhanNhan);
								
							} else if (locTin.equals("removeListTimNguoiDu")) {
								clientGiaoDien.removeListTimNguoiDung();
								
							}

						}

					} catch (IOException e) {

						e.printStackTrace();
					}
				}

			}
		});
		
		threadDocTinNhan.start();
		
	}

	// them ki tu <br> de tin nhan xuong hang
	public static String insertCharacter(String input, String character, int interval) {
		
		StringBuilder sb = new StringBuilder();
		int count = 0;

		for (int i = 0; i < input.length(); i++) {
			
			sb.append(input.charAt(i));
			count++;

			if (count == interval) {
				sb.append(character);
				count = 0;
			}
		}

		return sb.toString();
	}

	@Override
	public void run() {

		try {
			in = new DataInputStream(client.getInputStream());
			out = new DataOutputStream(client.getOutputStream());

		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}

}
