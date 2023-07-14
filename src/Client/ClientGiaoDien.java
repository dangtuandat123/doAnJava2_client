package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileSystemView;

public class ClientGiaoDien extends JFrame {

	private JPanel jPanel_dangNhap;
	private JPanel jPanel_tieuDe;
	private JTextField jTextField_nhapTaiKhoan;
	private JPasswordField jTextField_nhapMatKhau;
	private JTextField jTextField_tenDangNhap;
	private JPasswordField jTextField_matKhau;
	private JPasswordField jTextField_nhapLaiMatKhau;
	private String userName;
	private String passWord;
	private String passWordAgain;
	private JPanel jPanel_thanhBen;
	private JPanel jPanel_jlistVaLable;
	private DefaultListModel<String> listModel;
	private DefaultListModel<String> listModel2;
	private DefaultListModel<String> listModel3;
	private ClientThread clientThread;
	private JTextField jTextField_nhapTinNhan;
	private JList<String> jList_danhSachNguoiDung;
	private JList<String> jList_danhSachNguoiDungDaKetNoi;
	private JList<String> jList_timNguoiDung;
	private String userNameNhanTinNhan;
	private JPanel jPanel_xemTinNhan;
	private JScrollPane scrollPane;
	private JPanel jPanel_listChat;
	private JPanel jPanel_jlistVaLable2;
	private Color mauDo;
	private Color mauXanh;
	private JLabel jLabel_nguoiDungDangChat;
	private JPanel jPanel_timNguoiDung;
	private JTextField jTextField_timNguoiDung;

	public ClientGiaoDien() {

	}

	public void nhanThread(ClientThread clientThread) {
		this.clientThread = clientThread;
	}

	public void khoiDong() {

		this.setTitle("Ứng dụng chat");
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		jPanel_dangNhap = new JPanel();
		this.add(jPanel_dangNhap);
		this.setVisible(true);
		dangNhap();

	}

	// form đăng nhập
	public void dangNhap() {

		ActionListener ac = new ClientControler(this);

		jPanel_dangNhap.removeAll();
		jPanel_dangNhap.repaint();
		Color mau1 = new Color(0, 151, 178);
		Color mau2 = new Color(88, 255, 155);
		jPanel_dangNhap.setLayout(new GridLayout(4, 2, 5, 5));
		jPanel_dangNhap.setBackground(mau1);

		Font font = new Font("Arial", Font.BOLD, 30);
		jPanel_tieuDe = new JPanel();
		this.add(jPanel_tieuDe, BorderLayout.NORTH);
		JLabel jLabel_tieude = new JLabel("ĐĂNG NHẬP", JLabel.CENTER);
		jPanel_tieuDe.add(jLabel_tieude);
		jPanel_tieuDe.setBackground(mau2);
		jLabel_tieude.setFont(font);

		// form tai khoan
		JLabel jLabel_dangNhap = new JLabel(" Tên đăng nhập");
		jLabel_dangNhap.setFont(font);
		jTextField_nhapTaiKhoan = new JTextField(5);
		jTextField_nhapTaiKhoan.setFont(font);
		jPanel_dangNhap.add(jLabel_dangNhap);
		jPanel_dangNhap.add(jTextField_nhapTaiKhoan);

		// form mat khau
		JLabel jLabel_matKhau = new JLabel(" Mật khẩu");
		jLabel_matKhau.setFont(font);
		jTextField_nhapMatKhau = new JPasswordField(5);
		jTextField_nhapMatKhau.setFont(font);
		jPanel_dangNhap.add(jLabel_matKhau);
		jPanel_dangNhap.add(jTextField_nhapMatKhau);

		// jpanel rong
		JPanel rong1 = new JPanel();
		jPanel_dangNhap.add(rong1);
		rong1.setBackground(mau1);
		JPanel rong2 = new JPanel();
		rong2.setBackground(mau1);
		jPanel_dangNhap.add(rong2);

		// button dang nhap
		JButton jButton_dangNhap = new JButton("ĐĂNG NHẬP");
		jButton_dangNhap.setBackground(Color.WHITE);
		jPanel_dangNhap.add(jButton_dangNhap);
		jButton_dangNhap.addActionListener(ac);

		JButton jButton_dangKi = new JButton("CHƯA CÓ TÀI KHOẢN");
		jButton_dangKi.setBackground(Color.WHITE);
		jPanel_dangNhap.add(jButton_dangKi);
		jButton_dangKi.addActionListener(ac);
		this.setVisible(true);

	}

	// form đăng kí
	public void dangKi() {

		ActionListener ac = new ClientControler(this);

		jPanel_dangNhap.removeAll();
		jPanel_dangNhap.repaint();
		jPanel_tieuDe.removeAll();
		jPanel_tieuDe.repaint();
		Color mau1 = new Color(0, 151, 178);
		Font font = new Font("Arial", Font.BOLD, 30);
		Font font2 = new Font("Arial", Font.BOLD, 30);

		// lable dang ki
		JLabel jLabel_tieude = new JLabel("ĐĂNG KÍ", JLabel.CENTER);
		jPanel_tieuDe.add(jLabel_tieude);
		jLabel_tieude.setFont(font);
		jPanel_dangNhap.setLayout(new GridLayout(4, 2, 5, 5));
		jPanel_dangNhap.setBackground(mau1);

		// form ten dang nhap
		JLabel jLabel_tenDangNhap = new JLabel(" Tên đăng nhập");
		jTextField_tenDangNhap = new JTextField(5);
		jPanel_dangNhap.add(jLabel_tenDangNhap);
		jPanel_dangNhap.add(jTextField_tenDangNhap);
		jLabel_tenDangNhap.setFont(font2);
		jTextField_tenDangNhap.setFont(font2);

		// form mat khau
		JLabel jLabel_matKhau = new JLabel(" Mật khẩu");
		jTextField_matKhau = new JPasswordField(5);
		jPanel_dangNhap.add(jLabel_matKhau);
		jPanel_dangNhap.add(jTextField_matKhau);
		jLabel_matKhau.setFont(font2);
		jTextField_matKhau.setFont(font2);

		// form nhap lai mat khau
		JLabel jLabel_nhapLaiMatKhau = new JLabel(" Nhập mật khẩu");
		jTextField_nhapLaiMatKhau = new JPasswordField(5);
		jPanel_dangNhap.add(jLabel_nhapLaiMatKhau);
		jPanel_dangNhap.add(jTextField_nhapLaiMatKhau);
		jTextField_nhapLaiMatKhau.setFont(font2);
		jLabel_nhapLaiMatKhau.setFont(font2);

		// button dang nhap
		JButton jButton_dangNhap = new JButton("QUAY VỀ TRANG ĐĂNG NHẬP");
		jPanel_dangNhap.add(jButton_dangNhap);
		jButton_dangNhap.addActionListener(ac);
		jButton_dangNhap.setBackground(Color.WHITE);

		// button dang kí
		JButton jButton_dangKi = new JButton("ĐĂNG KÍ");
		jPanel_dangNhap.add(jButton_dangKi);
		jButton_dangKi.addActionListener(ac);
		jButton_dangKi.setBackground(Color.WHITE);

	}

	// form thông báo
	public void thongBao(String thongBao, Color mau) {

		JFrame jFrame_thongBao = new JFrame();
		jFrame_thongBao.setSize(300, 160);
		jFrame_thongBao.setTitle("Thông báo");
		jFrame_thongBao.setLocationRelativeTo(null);
		jFrame_thongBao.setLayout(new BorderLayout());

		JLabel jLabel_thongBao = new JLabel(thongBao, JLabel.CENTER);
		jLabel_thongBao.setForeground(mau);
		Font font = new Font("Arial", Font.BOLD, 15);
		jLabel_thongBao.setFont(font);
		jFrame_thongBao.add(jLabel_thongBao, BorderLayout.CENTER);
		jFrame_thongBao.setVisible(true);

	}

	// hàm xử lý đăng nhập
	public void xuLyDangNhap() {

		userName = jTextField_nhapTaiKhoan.getText();
		passWord = jTextField_nhapMatKhau.getText();
		clientThread.xuLyDangNhap(userName, passWord);

	}

	// hàm bật thông báo khi đăng nhập
	public void thongBaoDangNhapThanhCong() {

		this.dispose();
		Color mauXanh = new Color(90, 196, 70);
		thongBao("Đăng nhập thành công!", mauXanh);

	}

	public void thongBaoDangNhapKhongThanhCong() {

		Color mauDo = new Color(255, 0, 0);
		thongBao("Sai tài khoản hoặc mật khẩu!", mauDo);

	}

	// hàm xử lý đăng kí
	public void xuLyDangKi() {

		userName = jTextField_tenDangNhap.getText();
		passWord = jTextField_matKhau.getText();
		passWordAgain = jTextField_nhapLaiMatKhau.getText();

		if (passWord.equals(passWordAgain)) {
			clientThread.xuLyDangKy(userName, passWord);

		} else {

			Color mauDo = new Color(255, 0, 0);
			thongBao("Nhập lại mật khẩu sai!", mauDo);

		}

	}

	// hàm bật thông báo khi đăng kí
	public void thongBaoDangKiThanhCong() {

		mauXanh = new Color(90, 196, 70);
		thongBao("Đăng kí thành công!", mauXanh);

	}

	public void thongBaoDangKiKhongThanhCong() {

		Color mauDo = new Color(255, 0, 0);
		thongBao("Tên người dùng đã tồn tại!", mauDo);

	}

	// hiển thị list người dùng đang online
	public void hienThiDanhSachNguoiDung() {

		JLabel jLabel_danhSachNguoiDung = new JLabel("NGƯỜI DÙNG ONLINE");
		Font font = new Font("Arial", Font.BOLD, 18);
		jLabel_danhSachNguoiDung.setFont(font);

		listModel = new DefaultListModel<>();
		jList_danhSachNguoiDung = new JList<>(listModel);
		JScrollPane jc = new JScrollPane(jList_danhSachNguoiDung);

		jList_danhSachNguoiDung.setFont(font);
		jPanel_jlistVaLable.setBackground(new Color(88, 255, 155));
		jPanel_jlistVaLable.add(jLabel_danhSachNguoiDung, BorderLayout.NORTH);
		jPanel_jlistVaLable.add(jc, BorderLayout.CENTER);
		jPanel_listChat.add(jPanel_jlistVaLable);
		jList_danhSachNguoiDung.repaint();

	}

	// hiển thị list đoạn chat đang chat
	public void hienThiDanhSachNguoiDungDaKetNoi() {

		JLabel jLabel_danhSachNguoiDung = new JLabel("ĐOẠN CHAT");
		mauDo = new Color(255, 0, 0);
		Font font = new Font("Arial", Font.BOLD, 18);
		jLabel_danhSachNguoiDung.setFont(font);

		listModel2 = new DefaultListModel<>();
		jList_danhSachNguoiDungDaKetNoi = new JList<>(listModel2);
		JScrollPane jc = new JScrollPane(jList_danhSachNguoiDungDaKetNoi);
		jList_danhSachNguoiDungDaKetNoi.setFont(font);

		jPanel_jlistVaLable2.setBackground(new Color(88, 255, 155));
		jPanel_jlistVaLable2.add(jLabel_danhSachNguoiDung, BorderLayout.NORTH);
		jPanel_jlistVaLable2.add(jc, BorderLayout.CENTER);
		jPanel_listChat.add(jPanel_jlistVaLable2);

	}

	public void addListNguoiDungOnline(String user) {

		if (user.equals(userName)) {
			return;
		}

		if (!listModel.contains(user)) {

			listModel.addElement(user);

		} else {

		}

	}

	public void addListNguoiDungDaNhanTin(String user) {

		if (user.equals(userName)) {

			return;
		}

		if (!listModel2.contains(user)) {

			System.out.println(user);
			listModel2.addElement(user);

		} else {

		}
		jList_danhSachNguoiDungDaKetNoi.revalidate();
		jList_danhSachNguoiDungDaKetNoi.repaint();

	}

	public void removeList(String user) {
		listModel.removeElement(user);
	}

	// tìm user
	public void timUser() {

		jPanel_timNguoiDung = new JPanel();
		jPanel_timNguoiDung.setLayout(new BorderLayout());
		jPanel_listChat.add(jPanel_timNguoiDung);
		JLabel jLabel_timNguoiDung = new JLabel("TÌM NGƯỜI DÙNG");
		jPanel_timNguoiDung.setBackground(new Color(88, 255, 155));
		Font font = new Font("Arial", Font.BOLD, 18);
		jLabel_timNguoiDung.setFont(font);
		jPanel_timNguoiDung.add(jLabel_timNguoiDung, BorderLayout.NORTH);
		//
		listModel3 = new DefaultListModel<>();

		jList_timNguoiDung = new JList<>(listModel3);
		JScrollPane jc = new JScrollPane(jList_timNguoiDung);
		JPanel jPanel_jlist = new JPanel();
		jPanel_jlist.setLayout(new BorderLayout());
		//
		jTextField_timNguoiDung = new JTextField();
		clientThread.timNguoiDung("");
		jPanel_jlist.add(jTextField_timNguoiDung, BorderLayout.NORTH);
		jTextField_timNguoiDung.setFont(font);
		jTextField_timNguoiDung.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

				clientThread.timNguoiDung(jTextField_timNguoiDung.getText());

			}

			@Override
			public void removeUpdate(DocumentEvent e) {

				clientThread.timNguoiDung(jTextField_timNguoiDung.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}

		});

		jPanel_jlist.add(jc, BorderLayout.CENTER);
		jList_timNguoiDung.setFont(font);
		jPanel_timNguoiDung.add(jPanel_jlist, BorderLayout.CENTER);

	}

	public void addListTimNguoiDung(String user) {

		if (!user.equals(userName)) {

			listModel3.addElement(user);

		}

		this.repaint();
		this.revalidate();

	}

	public void removeListTimNguoiDung() {

		listModel3.removeAllElements();
		this.repaint();
		this.revalidate();

	}

	// hàm gửi tin nhắn
	public void guiTinNhan() {

		String tinNhan = jTextField_nhapTinNhan.getText();

		if (!tinNhan.equals("")) {
			jTextField_nhapTinNhan.setText("");
			if (userNameNhanTinNhan != null) {
				clientThread.guiNhanTinNhan(tinNhan, userName, userNameNhanTinNhan);
			} else {
				thongBao("Vui lòng chọn người chat!", Color.RED);
			}

		} else {
			thongBao("Vui lòng nhập tin nhắn!", mauDo);
		}

	}

	// hàm nhận tin từ csdl
	public void layTinNhanTuCsdl() {
		resetPanelXemTinNhan();
		if (jList_danhSachNguoiDung.getSelectedValue() == null
				&& jList_danhSachNguoiDungDaKetNoi.getSelectedValue() == null
				&& jList_timNguoiDung.getSelectedValue() == null) {
			thongBao("Vui lòng chọn người chat!", mauDo);
		}
		if (jList_danhSachNguoiDungDaKetNoi.getSelectedValue() != null) {

			userNameNhanTinNhan = jList_danhSachNguoiDungDaKetNoi.getSelectedValue();
			jLabel_nguoiDungDangChat
					.setText("BẠN ĐANG CHAT VỚI: " + jList_danhSachNguoiDungDaKetNoi.getSelectedValue());
			clientThread.layTinNhanTuServer(userName, userNameNhanTinNhan);

		}
		if (jList_danhSachNguoiDung.getSelectedValue() != null) {

			userNameNhanTinNhan = jList_danhSachNguoiDung.getSelectedValue();
			jLabel_nguoiDungDangChat.setText("BẠN ĐANG CHAT VỚI: " + jList_danhSachNguoiDung.getSelectedValue());
			clientThread.layTinNhanTuServer(userName, userNameNhanTinNhan);

		}
		if (jList_timNguoiDung.getSelectedValue() != null) {

			userNameNhanTinNhan = jList_timNguoiDung.getSelectedValue();
			jLabel_nguoiDungDangChat.setText("BẠN ĐANG CHAT VỚI: " + jList_timNguoiDung.getSelectedValue());
			clientThread.layTinNhanTuServer(userName, userNameNhanTinNhan);

		}

		jList_danhSachNguoiDungDaKetNoi.clearSelection();
		jList_danhSachNguoiDung.clearSelection();
		jList_timNguoiDung.clearSelection();

	}

	// reset panel hiển thị tin nhắn
	public void resetPanelXemTinNhan() {
		jPanel_xemTinNhan.removeAll();
	}

	public void resetXemTinNhan() {
		jPanel_xemTinNhan.repaint();
	}

	// thêm tin nhắn vào panel
	public void addTinNhan(String tinNhan, String user1, String user2, String time, String duongDanFile) {

		if (user2.equals(userNameNhanTinNhan) || user1.equals(userNameNhanTinNhan)) {
			if (user1.equals(userName)) {
				if (!duongDanFile.equals("null")) {

					String filePath = duongDanFile;
					File file = new File(filePath);
					String output = file.getName();
					String fileName = insertCharacter(output, "<br>", 35);

					JPanel jPanel_tinNhan = new JPanel();
					JLabel jLabel_tinNhan = new JLabel(
							"<html><body style='width: 325px;margin: 5px;background: #ededed; font-size: 15px;'><p style='color: blue'>"
									+ fileName + "</p><div style='font-size: 10px;color: #757373;'>" + time
									+ "</div></body></html>");
					ImageIcon icon = new ImageIcon("img/file.png");
					Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
					ImageIcon scaledIcon = new ImageIcon(image);

					jLabel_tinNhan.setIcon(scaledIcon);

					jLabel_tinNhan.addMouseListener(new MouseListener() {

						@Override
						public void mouseClicked(MouseEvent e) {

							String Time = time;
							Time = Time.replace("-", " ");
							Time = Time.replace(".", " ");
							Time = Time.replace(":", " ");

							String duongDan = "File\\" + user1 + "\\" + Time + "\\" + output;
							System.out.println(duongDan);

							JFileChooser fileChooser = new JFileChooser(
									FileSystemView.getFileSystemView().getHomeDirectory());
							fileChooser.setDialogTitle("Chọn thư mục lưu");
							fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

							// Hiển thị hộp thoại chọn thư mục
							int returnValue = fileChooser.showOpenDialog(null);
							if (returnValue == JFileChooser.APPROVE_OPTION) {
								// Lấy đường dẫn đến thư mục đã chọn
								String selectedFolderPath = fileChooser.getSelectedFile().getAbsolutePath();
								selectedFolderPath.replace("\\", "/");
								System.out.println("Thư mục đã chọn: " + selectedFolderPath);

								clientThread.nhanThongTinFile(duongDan, selectedFolderPath, output);
							} else {
								System.out.println("Không có thư mục nào được chọn.");
							}

						}

						@Override
						public void mousePressed(MouseEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub

						}
					});

					Color mau1 = new Color(0, 151, 178);
					jPanel_tinNhan.setBackground(mau1);
					jPanel_tinNhan.setLayout(new GridLayout(1, 2));

					JPanel jPanel_tam = new JPanel();

					jPanel_tinNhan.add(jPanel_tam);
					jPanel_tam.setBackground(mau1);
					JPanel jPanel_tam2 = new JPanel();
					jPanel_tam2.setBackground(mau1);

					jPanel_tam2.add(jLabel_tinNhan);

					jPanel_tinNhan.add(jPanel_tam2);

					jPanel_xemTinNhan.add(jPanel_tinNhan);

					jPanel_tinNhan.setBackground(Color.WHITE);
					// luot jscrollpane xuong duoi cung
					int height = (int) jPanel_xemTinNhan.getPreferredSize().getHeight();
					Rectangle rect = new Rectangle(0, height, 10, 10);
					jPanel_xemTinNhan.scrollRectToVisible(rect);

				} else {
					JPanel jPanel_tinNhan = new JPanel();

					String checkTn = tinNhan.substring(1, Math.min(tinNhan.length(), 5));
					if (checkTn.equals(".png")) {
						JLabel jLabel_icon1 = new JLabel(
								"<html><body style='width: 330px;margin:5px;padding: 0;background: #ededed; font-size: 15px;'><p></p><div style='font-size: 10px;color: #757373;'>"
										+ time + "</div></body></html>");
						jLabel_icon1.setBackground(Color.WHITE);
						ImageIcon icon1 = new ImageIcon("img/icon/" + tinNhan);
						jLabel_icon1.setIcon(icon1);

						Color mau1 = new Color(0, 151, 178);
						jPanel_tinNhan.setBackground(mau1);
						jPanel_tinNhan.setLayout(new GridLayout(1, 2));

						JPanel jPanel_tam = new JPanel();

						jPanel_tinNhan.add(jPanel_tam);
						jPanel_tam.setBackground(mau1);
						JPanel jPanel_tam2 = new JPanel();
						jPanel_tam2.setBackground(mau1);

						jPanel_tam2.add(jLabel_icon1);

						jPanel_tinNhan.add(jPanel_tam2);

						jPanel_xemTinNhan.add(jPanel_tinNhan);

						jPanel_tinNhan.setBackground(Color.WHITE);
						// luot jscrollpane xuong duoi cung
						int height = (int) jPanel_xemTinNhan.getPreferredSize().getHeight();
						Rectangle rect = new Rectangle(0, height, 10, 10);
						jPanel_xemTinNhan.scrollRectToVisible(rect);

					} else {
						JLabel jLabel_tinNhan = new JLabel(
								"<html><body style='width: 375px;margin: 5px;background: #ededed; font-size: 15px;'><p>"
										+ tinNhan + "</p><div style='font-size: 10px;color: #757373;'>" + time
										+ "</div></body></html>");
						Color mau1 = new Color(0, 151, 178);
						jPanel_tinNhan.setBackground(mau1);
						jPanel_tinNhan.setLayout(new GridLayout(1, 2));

						JPanel jPanel_tam = new JPanel();

						jPanel_tinNhan.add(jPanel_tam);
						jPanel_tam.setBackground(mau1);
						JPanel jPanel_tam2 = new JPanel();
						jPanel_tam2.setBackground(mau1);

						jPanel_tam2.add(jLabel_tinNhan);

						jPanel_tinNhan.add(jPanel_tam2);

						jPanel_xemTinNhan.add(jPanel_tinNhan);

						jPanel_tinNhan.setBackground(Color.WHITE);
						// luot jscrollpane xuong duoi cung
						int height = (int) jPanel_xemTinNhan.getPreferredSize().getHeight();
						Rectangle rect = new Rectangle(0, height, 10, 10);
						jPanel_xemTinNhan.scrollRectToVisible(rect);
					}

				}

			} else {

				if (!duongDanFile.equals("null")) {

					String filePath = duongDanFile;
					File file = new File(filePath);
					String output = file.getName();
					String fileName = insertCharacter(output, "<br>", 35);

					JPanel jPanel_tinNhan = new JPanel();
					JLabel jLabel_tinNhan = new JLabel(
							"<html><body style='width: 325px;margin: 5px;background: #7ee0db; font-size: 15px;'><p style='color: blue'>"
									+ fileName + "</p><div style='font-size: 10px;color: #757373;'>" + time
									+ "</div></body></html>");
					ImageIcon icon = new ImageIcon("img/file.png");
					Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
					ImageIcon scaledIcon = new ImageIcon(image);
					jLabel_tinNhan.setIcon(scaledIcon);
					jLabel_tinNhan.addMouseListener(new MouseListener() {

						@Override
						public void mouseClicked(MouseEvent e) {

							String Time = time;
							Time = Time.replace("-", " ");
							Time = Time.replace(".", " ");
							Time = Time.replace(":", " ");

							String duongDan = "File\\" + user1 + "\\" + Time + "\\" + output;
							System.out.println(duongDan);

							JFileChooser fileChooser = new JFileChooser(
									FileSystemView.getFileSystemView().getHomeDirectory());
							fileChooser.setDialogTitle("Chọn thư mục lưu");
							fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

							// Hiển thị hộp thoại chọn thư mục
							int returnValue = fileChooser.showOpenDialog(null);
							if (returnValue == JFileChooser.APPROVE_OPTION) {
								// Lấy đường dẫn đến thư mục đã chọn
								String selectedFolderPath = fileChooser.getSelectedFile().getAbsolutePath();
								selectedFolderPath.replace("\\", "/");
								System.out.println("Thư mục đã chọn: " + selectedFolderPath);

								clientThread.nhanThongTinFile(duongDan, selectedFolderPath, output);
							} else {
								System.out.println("Không có thư mục nào được chọn.");
							}

						}

						@Override
						public void mousePressed(MouseEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub

						}
					});

					Color mau1 = new Color(0, 151, 178);

					jPanel_tinNhan.setLayout(new GridLayout(1, 2));
					JPanel jPanel_tam = new JPanel();
					jPanel_tam.setBackground(mau1);
					JPanel jPanel_tam2 = new JPanel();
					jPanel_tam2.setBackground(mau1);

					jPanel_tam2.add(jLabel_tinNhan);
					jPanel_tinNhan.add(jPanel_tam2);
					jPanel_tinNhan.add(jPanel_tam);

					jPanel_xemTinNhan.add(jPanel_tinNhan);

					jPanel_tinNhan.setBackground(Color.gray);
					// luot jscrollpane xuong duoi cung
					int height = (int) jPanel_xemTinNhan.getPreferredSize().getHeight();
					Rectangle rect = new Rectangle(0, height, 10, 10);
					jPanel_xemTinNhan.scrollRectToVisible(rect);

				} else {
					JPanel jPanel_tinNhan = new JPanel(); 

					String checkTn = tinNhan.substring(1, Math.min(tinNhan.length(), 5));
					if (checkTn.equals(".png")) {
						JLabel jLabel_icon1 = new JLabel(
								"<html><body style='width: 330px;margin:5px;padding: 0;background: #7ee0db; font-size: 15px;'><p></p><div style='font-size: 10px;color: #757373;'>"
										+ time + "</div></body></html>");
						Color mau1 = new Color(0, 151, 178);
						ImageIcon icon1 = new ImageIcon("img/icon/" + tinNhan);
						jLabel_icon1.setIcon(icon1);

						jPanel_tinNhan.setLayout(new GridLayout(1, 2));
						JPanel jPanel_tam = new JPanel();
						jPanel_tam.setBackground(mau1);
						JPanel jPanel_tam2 = new JPanel();
						jPanel_tam2.setBackground(mau1);

						jPanel_tam2.add(jLabel_icon1);
						jPanel_tinNhan.add(jPanel_tam2);
						jPanel_tinNhan.add(jPanel_tam);

						jPanel_xemTinNhan.add(jPanel_tinNhan);

						jPanel_tinNhan.setBackground(Color.gray);
						// luot jscrollpane xuong duoi cung
						int height = (int) jPanel_xemTinNhan.getPreferredSize().getHeight();
						Rectangle rect = new Rectangle(0, height, 10, 10);
						jPanel_xemTinNhan.scrollRectToVisible(rect);

					} else {
						
						JLabel jLabel_tinNhan = new JLabel(
								"<html><body style='width: 375px;margin: 5px;background: #7ee0db; font-size: 15px;'><p>"
										+ tinNhan + "</p><div style='font-size: 10px;color: #757373;'>" + time
										+ "</div></body></html>");

						Color mau1 = new Color(0, 151, 178);

						jPanel_tinNhan.setLayout(new GridLayout(1, 2));
						JPanel jPanel_tam = new JPanel();
						jPanel_tam.setBackground(mau1);
						JPanel jPanel_tam2 = new JPanel();
						jPanel_tam2.setBackground(mau1);

						jPanel_tam2.add(jLabel_tinNhan);
						jPanel_tinNhan.add(jPanel_tam2);
						jPanel_tinNhan.add(jPanel_tam);

						jPanel_xemTinNhan.add(jPanel_tinNhan);

						jPanel_tinNhan.setBackground(Color.gray);
						// luot jscrollpane xuong duoi cung
						int height = (int) jPanel_xemTinNhan.getPreferredSize().getHeight();
						Rectangle rect = new Rectangle(0, height, 10, 10);
						jPanel_xemTinNhan.scrollRectToVisible(rect);
					}
				}

			}

		}

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

	// form giao diện người dùng
	public void trangNguoiDung() {

		Color mau1 = new Color(0, 151, 178);

		ActionListener ac = new ClientControler(this);
		JFrame jFrame_trangNguoiDung = new JFrame();
		jFrame_trangNguoiDung.setSize(1296, 720);
		jFrame_trangNguoiDung.setResizable(false);
		jFrame_trangNguoiDung.setTitle("CHAT APP USER : " + userName);
		jFrame_trangNguoiDung.setLocationRelativeTo(null);
		jFrame_trangNguoiDung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame_trangNguoiDung.setLayout(new BorderLayout());
		jFrame_trangNguoiDung.setVisible(true);

		// panel trang chinh
		JPanel jPanel_trangChinh = new JPanel();
		jFrame_trangNguoiDung.add(jPanel_trangChinh, BorderLayout.CENTER);
		jPanel_trangChinh.setBackground(Color.pink);
		jPanel_trangChinh.setLayout(new BorderLayout());

		// jpanel thanh ben (hien thi danh sach nguoi dung online)
		jPanel_thanhBen = new JPanel();
		jFrame_trangNguoiDung.add(jPanel_thanhBen, BorderLayout.EAST);
		jPanel_thanhBen.setBackground(Color.white);
		jPanel_thanhBen.setPreferredSize(new Dimension(200, 720));
		jPanel_thanhBen.setLayout(new BorderLayout());
		jPanel_listChat = new JPanel();
		jPanel_thanhBen.add(jPanel_listChat, BorderLayout.CENTER);
		jPanel_listChat.setLayout(new GridLayout(3, 1));

		// button chon nguoi de chat
		JButton jButton_nutChonNguoi = new JButton("CHỌN");
		jButton_nutChonNguoi.setBackground(new Color(88, 255, 155));
		jButton_nutChonNguoi.addActionListener(ac);
		jPanel_thanhBen.add(jButton_nutChonNguoi, BorderLayout.SOUTH);
		jButton_nutChonNguoi.setPreferredSize(new Dimension(200, 100));

		// jlist
		jPanel_jlistVaLable = new JPanel();
		jPanel_jlistVaLable.setLayout(new BorderLayout());

		jPanel_jlistVaLable2 = new JPanel();
		jPanel_jlistVaLable2.setLayout(new BorderLayout());
		// jlable

		hienThiDanhSachNguoiDung();
		hienThiDanhSachNguoiDungDaKetNoi();
		timUser();
		// jpanel nut thao tac
		JPanel jPanel_chat = new JPanel();
		jPanel_chat.setLayout(new BorderLayout());
		jPanel_trangChinh.add(jPanel_chat, BorderLayout.SOUTH);

		JPanel jPanel_thaoTacChat = new JPanel();
		jPanel_thaoTacChat.setLayout(new BorderLayout());
		jPanel_chat.add(jPanel_thaoTacChat, BorderLayout.WEST);
		jPanel_thaoTacChat.setBackground(Color.green);
		jPanel_thaoTacChat.setPreferredSize(new Dimension(880, 100));
		jTextField_nhapTinNhan = new JTextField();
		jTextField_nhapTinNhan.setFont(new Font("Arial", 30, 50));
		jPanel_thaoTacChat.setLayout(new GridLayout(1, 1));
		jPanel_thaoTacChat.add(jTextField_nhapTinNhan, BorderLayout.CENTER);
		// nut gui tin
		JButton jButton_guiTinNhan = new JButton("GỬI");
		jButton_guiTinNhan.setBackground(new Color(88, 255, 155));
		jPanel_chat.add(jButton_guiTinNhan, BorderLayout.EAST);
		jButton_guiTinNhan.setPreferredSize(new Dimension(100, 100));
		jButton_guiTinNhan.addActionListener(ac);
		// nut chon file

		ImageIcon icon = new ImageIcon("img/paper-clip.png");
		Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(image);
		JButton jButton_chonFile = new JButton();
		JLabel jLabel_chonFile = new JLabel();
		jButton_chonFile.setIcon(scaledIcon);
		jButton_chonFile.setBackground(new Color(88, 255, 155));
		jPanel_chat.add(jButton_chonFile, BorderLayout.CENTER);
		jButton_chonFile.setPreferredSize(new Dimension(100, 100));

		jButton_chonFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Chọn file");
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					String filePath = selectedFile.getAbsolutePath().replace("\\", "\\\\");
					clientThread.guiFile(filePath, userName, userNameNhanTinNhan);
					System.out.println(filePath);

				}

			}
		});
		// jpan chon icon
		JPanel jPanel_chonIcon = new JPanel();
		jPanel_chonIcon.setPreferredSize(new Dimension(880, 60));
		jPanel_chonIcon.setLayout(new GridLayout(1, 6));
		// icon1
		JLabel jLabel_icon1 = new JLabel();
		jLabel_icon1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (userNameNhanTinNhan != null) {
					clientThread.guiNhanTinNhan("1.png", userName, userNameNhanTinNhan);
				} else {
					thongBao("Vui lòng chọn người chat!", Color.RED);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		ImageIcon icon1 = new ImageIcon("img/icon/1.png");
		jLabel_icon1.setIcon(icon1);
		jPanel_chonIcon.add(jLabel_icon1);
		// icon2
		JLabel jLabel_icon2 = new JLabel();
		jLabel_icon2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (userNameNhanTinNhan != null) {
					clientThread.guiNhanTinNhan("2.png", userName, userNameNhanTinNhan);
				} else {
					thongBao("Vui lòng chọn người chat!", Color.RED);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		ImageIcon icon2 = new ImageIcon("img/icon/2.png");
		jLabel_icon2.setIcon(icon2);
		jPanel_chonIcon.add(jLabel_icon2);
		// icon3
		JLabel jLabel_icon3 = new JLabel();
		jLabel_icon3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (userNameNhanTinNhan != null) {
					clientThread.guiNhanTinNhan("3.png", userName, userNameNhanTinNhan);
				} else {
					thongBao("Vui lòng chọn người chat!", Color.RED);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		ImageIcon icon3 = new ImageIcon("img/icon/3.png");
		jLabel_icon3.setIcon(icon3);
		jPanel_chonIcon.add(jLabel_icon3);
		// icon4
		JLabel jLabel_icon4 = new JLabel();
		jLabel_icon4.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (userNameNhanTinNhan != null) {
					clientThread.guiNhanTinNhan("4.png", userName, userNameNhanTinNhan);
				} else {
					thongBao("Vui lòng chọn người chat!", Color.RED);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		ImageIcon icon4 = new ImageIcon("img/icon/4.png");
		jLabel_icon4.setIcon(icon4);
		jPanel_chonIcon.add(jLabel_icon4);
		// icon5
		JLabel jLabel_icon5 = new JLabel();
		jLabel_icon5.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (userNameNhanTinNhan != null) {
					clientThread.guiNhanTinNhan("5.png", userName, userNameNhanTinNhan);
				} else {
					thongBao("Vui lòng chọn người chat!", Color.RED);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		ImageIcon icon5 = new ImageIcon("img/icon/5.png");
		jLabel_icon5.setIcon(icon5);
		jPanel_chonIcon.add(jLabel_icon5);
		// icon6
		JLabel jLabel_icon6 = new JLabel();
		jLabel_icon6.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (userNameNhanTinNhan != null) {
					clientThread.guiNhanTinNhan("6.png", userName, userNameNhanTinNhan);
				} else {
					thongBao("Vui lòng chọn người chat!", Color.RED);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		ImageIcon icon6 = new ImageIcon("img/icon/6.png");
		jLabel_icon6.setIcon(icon6);
		jPanel_chonIcon.add(jLabel_icon6);

		jPanel_chat.add(jPanel_chonIcon, BorderLayout.NORTH);
		// jpanel xem tin nhan

		jPanel_xemTinNhan = new JPanel();
		scrollPane = new JScrollPane(jPanel_xemTinNhan);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		jPanel_trangChinh.add(scrollPane, BorderLayout.CENTER);
		jPanel_xemTinNhan.setLayout(new BoxLayout(jPanel_xemTinNhan, BoxLayout.Y_AXIS));
		jPanel_xemTinNhan.setBackground(mau1);

		// panel hien thi nguoi dung dang chat
		JPanel jPanel_nguoiDungDangChat = new JPanel();
		jPanel_trangChinh.add(jPanel_nguoiDungDangChat, BorderLayout.NORTH);
		jPanel_nguoiDungDangChat.setLayout(new BorderLayout());
		jPanel_nguoiDungDangChat.setBackground(new Color(88, 255, 155));
		jLabel_nguoiDungDangChat = new JLabel("BẠN ĐANG CHAT VỚI: ");
		Font font = new Font("Arial", Font.BOLD, 18);
		jLabel_nguoiDungDangChat.setFont(font);
		jPanel_nguoiDungDangChat.add(jLabel_nguoiDungDangChat, BorderLayout.WEST);
		jFrame_trangNguoiDung.setVisible(true);

	}

}
