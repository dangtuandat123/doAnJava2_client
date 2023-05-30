package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class ClientGiaoDien extends JFrame {

	private JPanel jPanel_dangNhap;
	private JPanel jPanel_tieuDe;
	private JTextField jTextField_nhapTaiKhoan;
	private JTextField jTextField_nhapMatKhau;
	private JTextField jTextField_tenDangNhap;
	private JTextField jTextField_matKhau;
	private JTextField jTextField_nhapLaiMatKhau;
	private JPanel jPanel_nutDangKiVaDangNhap;
	private String userName;
	private String passWord;
	private String trangThai;
	private String passWordAgain;
	private JPanel jPanel_thanhBen;
	private JPanel jPanel_jlistVaLable;


	public void khoiDong() {

		this.setTitle("Phần mềm chat");
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		jPanel_dangNhap = new JPanel();
		this.add(jPanel_dangNhap);
		this.setVisible(true);
		dangNhap();
	}

	public void dangNhap() {
		ActionListener ac = new ClientControler(this);

		jPanel_dangNhap.removeAll();
		jPanel_dangNhap.repaint();

		Color mau1 = new Color(0, 151, 178);
		Color mau2 = new Color(88, 255, 155);
		jPanel_dangNhap.setLayout(new GridLayout(4, 2, 20, 20));
		jPanel_dangNhap.setBackground(mau1);
		//
		Font font = new Font("Arial", Font.BOLD, 30);
		//
		jPanel_tieuDe = new JPanel();
		this.add(jPanel_tieuDe, BorderLayout.NORTH);
		JLabel jLabel_tieude = new JLabel("ĐĂNG NHẬP", JLabel.CENTER);
		jPanel_tieuDe.add(jLabel_tieude);
		jPanel_tieuDe.setBackground(mau2);
		
		jLabel_tieude.setFont(font);
		
		// taikhoan
		
		

		JLabel jLabel_dangNhap = new JLabel("Username");
		
		jLabel_dangNhap.setFont(font);
		jTextField_nhapTaiKhoan = new JTextField(5);
		jTextField_nhapTaiKhoan.setFont(font);
		jPanel_dangNhap.add(jLabel_dangNhap);
		jPanel_dangNhap.add(jTextField_nhapTaiKhoan);

		// matkhau

		JLabel jLabel_matKhau = new JLabel("Password");
		jLabel_matKhau.setFont(font);
		jTextField_nhapMatKhau = new JTextField(5);
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

		// dang nhap

		JButton jButton_dangNhap = new JButton("ĐĂNG NHẬP");
		jButton_dangNhap.setBackground(Color.WHITE);
		jPanel_dangNhap.add(jButton_dangNhap);
		jButton_dangNhap.addActionListener(ac);
		//
		JButton jButton_dangKi = new JButton("CHƯA CÓ TÀI KHOẢN");
		jButton_dangKi.setBackground(Color.WHITE);
		
		jPanel_dangNhap.add(jButton_dangKi);
		jButton_dangKi.addActionListener(ac);
		this.setVisible(true);

	}

	public void dangKi() {
		
		ActionListener ac = new ClientControler(this);

		jPanel_dangNhap.removeAll();
		jPanel_dangNhap.repaint();
		Color mau1 = new Color(0, 151, 178);
		Color mau2 = new Color(88, 255, 155);
		Font font = new Font("Arial", Font.BOLD, 30);
		Font font2 = new Font("Arial", Font.BOLD, 20);

		JLabel jLabel_tieude = new JLabel("ĐĂNG KÍ", JLabel.CENTER);
		jPanel_tieuDe.add(jLabel_tieude);
		jLabel_tieude.setFont(font);
		jPanel_dangNhap.setLayout(new GridLayout(4, 2, 20, 20));
		jPanel_dangNhap.setBackground(mau1);

		// form ten dang nhap
		JLabel jLabel_tenDangNhap = new JLabel("TEN DANG NHAP");
		jTextField_tenDangNhap = new JTextField(5);
		jPanel_dangNhap.add(jLabel_tenDangNhap);
		jPanel_dangNhap.add(jTextField_tenDangNhap);
		jLabel_tenDangNhap.setFont(font2);
		jTextField_tenDangNhap.setFont(font2);

		// form mat khau
		JLabel jLabel_matKhau = new JLabel("MAT KHAU");
		jTextField_matKhau = new JTextField(5);
		jPanel_dangNhap.add(jLabel_matKhau);
		jPanel_dangNhap.add(jTextField_matKhau);
		jLabel_matKhau.setFont(font2);
		jTextField_matKhau.setFont(font2);

		// form nhap lai mat khau
		JLabel jLabel_nhapLaiMatKhau = new JLabel("NHAP LAI MAT KHAU");
		jTextField_nhapLaiMatKhau = new JTextField(5);
		jPanel_dangNhap.add(jLabel_nhapLaiMatKhau);
		jPanel_dangNhap.add(jTextField_nhapLaiMatKhau);
		jTextField_nhapLaiMatKhau.setFont(font2);
		jLabel_nhapLaiMatKhau.setFont(font2);

		//

		// dang nhap
		JButton jButton_dangNhap = new JButton("QUAY VỀ TRANG ĐĂNG NHẬP");
		jPanel_dangNhap.add(jButton_dangNhap);
		jButton_dangNhap.addActionListener(ac);
		jButton_dangNhap.setBackground(Color.WHITE);
		//
		JButton jButton_dangKi = new JButton("ĐĂNG KÍ");
		jPanel_dangNhap.add(jButton_dangKi);
		jButton_dangKi.addActionListener(ac);
		jButton_dangKi.setBackground(Color.WHITE);
		//

	}

	// thong bao
	public void thongBao(String thongBao, Color mau) {
		JFrame jFrame_thongBao = new JFrame();
		jFrame_thongBao.setSize(300, 160);
		jFrame_thongBao.setTitle("Thông báo");
		jFrame_thongBao.setLocationRelativeTo(null);
		jFrame_thongBao.setLayout(new BorderLayout());
		//
		JLabel jLabel_thongBao = new JLabel(thongBao, JLabel.CENTER);
		jLabel_thongBao.setForeground(mau);
		Font font = new Font("Arial", Font.BOLD, 15);
		jLabel_thongBao.setFont(font);
		jFrame_thongBao.add(jLabel_thongBao, BorderLayout.CENTER);
		jFrame_thongBao.setVisible(true);

	}

// phan xu ly dang nhap
	public void xuLyDangNhap() {
		userName = jTextField_nhapTaiKhoan.getText();
		
		
		passWord = jTextField_nhapMatKhau.getText();
		String trangThai = "dangNhap";
		Client client = new Client(userName, passWord, trangThai);
		client.khoiDong();
		this.dispose();

	}

	public void thongBaoDangNhapThanhCong(String tenNguoiDung) {
		
		trangNguoiDung(tenNguoiDung);

		Color mauXanh = new Color(90, 196, 70);
		thongBao("Dang nhap thanh cong!", mauXanh);

	}

	public void thongBaoDangNhapKhongThanhCong() {
		khoiDong();
		Color mauDo = new Color(255, 0, 0);
		thongBao("Sai tai khoan hoac mat khau !", mauDo);

	}

	// phan xu ly dang ki
	public void xuLyDangKi() {
		userName = jTextField_tenDangNhap.getText();
		passWord = jTextField_matKhau.getText();
		passWordAgain = jTextField_nhapLaiMatKhau.getText();
		if (passWord.equals(passWordAgain)) {
			String trangThai = "dangKi";
			Client client = new Client(userName, passWord, trangThai);
			client.khoiDong();

		} else {
			Color mauDo = new Color(255, 0, 0);
			thongBao("Nhap lai mat khau sai !", mauDo);
		}

	}

	public void thongBaoDangKiThanhCong() {
		Color mauXanh = new Color(90, 196, 70);
		thongBao("Dang ki thanh cong!", mauXanh);

	}

	public void thongBaoDangKiKhongThanhCong() {
		Color mauDo = new Color(255, 0, 0);
		thongBao("username da ton tai !", mauDo);

	}

//	public void xuLyDangNhap() {
//		String user = jTextField_nhapTaiKhoan.getText();
//		String pass = jTextField_nhapMatKhau.getText();
//
//		try {
//
//			//
//			Connection con = JDBCUtil.getConnection();
//
//			//
//			Statement st = con.createStatement();
//
//			//
//
//			String sql = "SELECT * from user WHERE  userName=" + '"' + user + '"' + " AND passWord=" + '"' + pass + '"'
//					+ ";";
//			System.out.println(sql);
//			ResultSet rs = st.executeQuery(sql);
//			//
//
//			//
//
//			while (rs.next()) {
//				userName = rs.getString("userName");
//				passWord = rs.getString("password");
//
//			}
//			try {
//
//				if (userName.equals(user) && passWord.equals(pass)) {
//					trangNguoiDung();
//					Color mauXanh = new Color(90, 196, 70);
//					thongBao("Dang nhap thanh cong!", mauXanh);
//					this.dispose();
//				}
//
//			} catch (Exception e) {
//				Color mauDo = new Color(255, 0, 0);
//				thongBao("Sai tai khoan hoac mat khau !", mauDo);
//
//			}
//
//			//
//			JDBCUtil.closeConnection(con);
//		} catch (SQLException e) {
//
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}
//
//	}
//
//	// xu ly dang ki
//	public void xuLyDangKi() {
//		String user = jTextField_tenDangNhap.getText();
//		String matKhau = jTextField_matKhau.getText();
//		String matKhauNhapLai = jTextField_nhapLaiMatKhau.getText();
//		if (matKhau.equals(matKhauNhapLai)) {
//			try {
//
//				//
//				Connection con = JDBCUtil.getConnection();
//
//				//
//				Statement st = con.createStatement();
//
//				//
//
//				String sql = "INSERT INTO user (`userName`, `passWord`) VALUES (" + "'" + user + "'" + "," + "'"
//						+ matKhau + "'" + ");";
//
//				System.out.println(sql);
//				int rs = st.executeUpdate(sql);
//				//
//				dangNhap();
//				Color mauXanh = new Color(90, 196, 70);
//				thongBao("Dang ki thanh cong!", mauXanh);
//
//				//
//				JDBCUtil.closeConnection(con);
//			} catch (SQLException e) {
//				Color mauDo = new Color(255, 0, 0);
//				thongBao("Ten nguoi dung da ton tai!", mauDo);
//
//				e.printStackTrace();
//
//			}
//		} else {
//			Color mauDo = new Color(255, 0, 0);
//			thongBao("Mat khau nhap lai khong dung!", mauDo);
//		}
//
//	}

	// giao dien nguoi dung
	
	public void hienThiDanhSachNguoiDung() {
		JLabel jLabel_danhSachNguoiDung = new JLabel("Nguoi dung Online");
		Color mauDo = new Color(255, 0, 0);
		Font font = new Font("Arial", Font.BOLD, 20);
		jLabel_danhSachNguoiDung.setFont(font);
		jLabel_danhSachNguoiDung.setForeground(mauDo);
		//
		//aray list jlist
		ArrayList<String> nguoiDung = new ArrayList<>();
		nguoiDung.add("Apple");
		nguoiDung.add("Banana");
		nguoiDung.add("Orange");
		// Tạo một DefaultListModel và thêm dữ liệu từ ArrayList vào nó
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (String fruit : nguoiDung) {
			listModel.addElement(fruit);
		}

		// Tạo một JList và đặt DefaultListModel làm mô hình cho nó
		JList<String> jList_danhSachNguoiDung = new JList<>(listModel);

		jList_danhSachNguoiDung.setFont(font);

		jPanel_jlistVaLable.add(jLabel_danhSachNguoiDung, BorderLayout.NORTH);
		jPanel_jlistVaLable.add(jList_danhSachNguoiDung, BorderLayout.CENTER);
		jPanel_thanhBen.add(jPanel_jlistVaLable, BorderLayout.NORTH);
		
		jPanel_jlistVaLable.removeAll();
		jPanel_jlistVaLable.repaint();
	}
	
	
	public void trangNguoiDung(String tenNguoiDung) {
		System.out.println(tenNguoiDung);
		String trangThai = "guiTinNhan";
		Client client = new Client(tenNguoiDung, passWord, trangThai);
		client.khoiDong();
		
		ChatAppUI Ui = new ChatAppUI();
		Ui.khoiDong();
//		JFrame jFrame_trangNguoiDung = new JFrame();
//		jFrame_trangNguoiDung.setSize(1280, 720);
//		jFrame_trangNguoiDung.setTitle("Trang nguoi dung");
//		jFrame_trangNguoiDung.setLocationRelativeTo(null);
//		jFrame_trangNguoiDung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jFrame_trangNguoiDung.setLayout(new BorderLayout());
//		jFrame_trangNguoiDung.setVisible(true);
//		// jFrame_trangNguoiDung.setResizable(false);
//
//		// khoiDongClient
//
//		// thanhphan
//
//		// panel trang chinh
//		JPanel jPanel_trangChinh = new JPanel();
//		jFrame_trangNguoiDung.add(jPanel_trangChinh, BorderLayout.CENTER);
//		jPanel_trangChinh.setBackground(Color.pink);
//		jPanel_trangChinh.setLayout(new BorderLayout());
//
//		// jpanel thanh ben (hien thi danh sach nguoi dung online)
//		jPanel_thanhBen = new JPanel();
//		jFrame_trangNguoiDung.add(jPanel_thanhBen, BorderLayout.EAST);
//		jPanel_thanhBen.setBackground(Color.white);
//		jPanel_thanhBen.setPreferredSize(new Dimension(200, 720));
//		jPanel_thanhBen.setLayout(new BorderLayout());
//
//		// button chon nguoi de chat
//		JButton jButton_nutChonNguoi = new JButton("Chon");
//		jPanel_thanhBen.add(jButton_nutChonNguoi, BorderLayout.SOUTH);
//		jButton_nutChonNguoi.setPreferredSize(new Dimension(200, 100));
//
//		// jlist
//		jPanel_jlistVaLable = new JPanel();
//		jPanel_jlistVaLable.setLayout(new BorderLayout());
//		// jlable
//		hienThiDanhSachNguoiDung();
//		//
//
//		// cac jpanel thanh phan trong trang chinh
//
//		// jpanel nut thao tac
//		JPanel jPanel_thaoTacChat = new JPanel();
//		jPanel_trangChinh.add(jPanel_thaoTacChat, BorderLayout.SOUTH);
//		jPanel_thaoTacChat.setBackground(Color.green);
//		jPanel_thaoTacChat.setPreferredSize(new Dimension(1080, 100));
//
//		// jpanel xem tin nhan
//		JPanel jPanel_xemTinNhan = new JPanel();
//		jPanel_trangChinh.add(jPanel_xemTinNhan, BorderLayout.WEST);
//		jPanel_xemTinNhan.setBackground(Color.yellow);
//		jPanel_xemTinNhan.setPreferredSize(new Dimension(1080, 620));
//
//		jFrame_trangNguoiDung.setVisible(true);
		

	}

}
