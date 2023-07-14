package Client;

import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
	private String tenFile;
	private String duongDanLuu;

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
			out.writeUTF(time);
			out.writeUTF(userGui);
			out.writeUTF(userNhan);

			System.out.println(time);

		} catch (Exception e) {

		}

	}

	public void guiFile(String duongDan, String userGui, String userNhan) { 

		if (time.equals("")) {
			time = "0";
		}
		File filea = new File(duongDan);
		String tenFile = filea.getName();
		try {

			out.writeUTF("guiFile");
			out.writeUTF(tenFile);
			out.writeUTF(time);
			out.writeUTF(userGui);
			out.writeUTF(userNhan);

		} catch (Exception e) {

		}
		try {

			File file = new File(duongDan);

			long fileSize = file.length();
			System.out.println(fileSize);
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			dos.writeLong(fileSize);

			// Gửi nội dung của file
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			byte[] buffer = new byte[8192];
			int bytesRead;
			while ((bytesRead = bis.read(buffer)) != -1) {
				dos.write(buffer, 0, bytesRead);
				System.out.println(bytesRead);
			}
			dos.flush();
			fis.close();

			// Đóng kết nối

			System.out.println("File sent successfully.");
		} catch (Exception e) {
			System.out.println("Ban da nhap sai.");
		}

	}

	public void nhanThongTinFile(String duongDan, String duongDanLuu, String tenFile) {
		this.duongDanLuu = duongDanLuu;
		this.tenFile = tenFile;
		synchronized (ClientThread.class) {
			try {

				out.writeUTF("nhanFile");
				out.writeUTF(duongDan);

			} catch (Exception e) {
			}

		}

	}

	public void nhanFile() {
		synchronized (in) {
			try {

				DataInputStream dis = new DataInputStream(client.getInputStream());
				long fileSize = in.readLong();
				System.out.println(fileSize);

				// Nhận nội dung của file
				try {
					File file = new File(duongDanLuu + "//" + tenFile);
					file.createNewFile();
				} catch (Exception e) {

				}
				FileOutputStream fos = new FileOutputStream(duongDanLuu + "//" + tenFile);

				byte[] buffer = new byte[8192];
				int bytesRead;
				while (fileSize > 0
						&& (bytesRead = dis.read(buffer, 0, (int) Math.min(buffer.length, fileSize))) != -1) {
					fos.write(buffer, 0, bytesRead);
					fileSize -= bytesRead;
					System.out.println(bytesRead);
					if (bytesRead != 8192) {
						break;

					}
				}
				fos.flush();
				fos.close();
				Color mau1 = new Color(0, 151, 178);
				clientGiaoDien.thongBao("Tải File thành công!",mau1);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

			private String duongDanFile;

			@Override
			public void run() {
				while (!tinNhanNhan.equals("exit")) {

					try {
						synchronized (in) {
							tinNhanNhan = in.readUTF();
							System.out.println(tinNhanNhan);

						}

						try {

							locTin = tinNhanNhan.substring(0, 20);
							locTin1 = tinNhanNhan.substring(0, 4);

						} catch (Exception e) {

						}if (locTin.equals("themNguoiDungVaoList")) {
							tinNhanNhan = tinNhanNhan.replace("themNguoiDungVaoList ", "");
							clientGiaoDien.addListNguoiDungOnline(tinNhanNhan);

						}else if (locTin.equals("xoaNguoiDungKhoiList")) {
							tinNhanNhan = tinNhanNhan.replace("xoaNguoiDungKhoiList ", "");
							clientGiaoDien.removeList(tinNhanNhan);

						} else if (locTin.equals("themNguoiDungcu List")) {
							tinNhanNhan = tinNhanNhan.replace("themNguoiDungcu List ", "");
							clientGiaoDien.addListNguoiDungDaNhanTin(tinNhanNhan);

						}else if (locTin.equals("guiVeNguoiDungCanTim")) {
							tinNhanNhan = tinNhanNhan.replace("guiVeNguoiDungCanTim ", "");
							clientGiaoDien.addListTimNguoiDung(tinNhanNhan);

						}else if (locTin.equals("removeListTimNguoiDu")) {
							clientGiaoDien.removeListTimNguoiDung();

						}else if (locTin.equals("nhanFile000000000000")) {
							nhanFile();

						}
						if (locTin1.equals("Time")) {

							try {

								time = tinNhanNhan.split("\\[")[1].split("]")[0];
								tinNhan = tinNhanNhan.split("TinNhan\\[")[1].split("]")[0];
								user1 = tinNhanNhan.split("user1\\[")[1].split("]")[0];
								user2 = tinNhanNhan.split("user2\\[")[1].split("]")[0];
								duongDanFile = tinNhanNhan.split("duongDanFile\\[")[1].split("]")[0];

								System.out.println(duongDanFile);

							} catch (Exception e) {

							}

							String output = insertCharacter(tinNhan, "<br>", 42);
							clientGiaoDien.addTinNhan(output, user1, user2, time, duongDanFile);

						}if (tinNhanNhan.equals("resetMess00000000000")) {
							clientGiaoDien.resetPanelXemTinNhan();

						
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
