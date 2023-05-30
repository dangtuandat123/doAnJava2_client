package Client;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.util.ArrayList;

public class ChatAppUI extends JFrame {
    public ChatAppUI() {
        this.setLocationRelativeTo(null);
        setTitle("ỨNG DỤNG CHAT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

       
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.decode("#58ff9b"));
        JLabel titleLabel = new JLabel("ỨNG DỤNG CHAT");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(titleLabel);

        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.decode("#0097b2"));
        
             
        JPanel chatbox = new JPanel();
        mainPanel.add(chatbox);
        chatbox.setBounds(20, 20, 500, 300);
        chatbox.setLayout(new BorderLayout());
        JPanel chatHeader = new JPanel();
        chatHeader.setBackground(headerPanel.getBackground());
        chatHeader.add(new JLabel("TIN NHẮN"));
        chatbox.add(chatHeader, BorderLayout.NORTH);
        
        //chat input
        JTextField input = new JTextField();
        mainPanel.add(input);
        input.setBounds(20, 350, 430, 40);
        
        //Chat button
        JButton chatBtn = new JButton("GỬI");
        mainPanel.add(chatBtn);
        chatBtn.setBackground(headerPanel.getBackground());
        chatBtn.setBounds(460, 350, 60, 40);
        Border whiteBorder = BorderFactory.createLineBorder(Color.white, 4);
        chatBtn.setBorder(whiteBorder);
        
        //chatlist
        JPanel chatList = new JPanel();
        chatList.setLayout(new BorderLayout());
        mainPanel.add(chatList);
        chatList.setBounds(558, 20, 300, 300);
        JPanel listHeader = new JPanel();
            
        listHeader.setBackground(headerPanel.getBackground());
        chatList.add(listHeader, BorderLayout.NORTH);
        listHeader.add(new JLabel("Danh Sách Online"));
        
        
        
        
        ArrayList<String> nguoiDung = new ArrayList<>();
		nguoiDung.add("User1");
		nguoiDung.add("User2");
		nguoiDung.add("User3");
		nguoiDung.add("User4");
		nguoiDung.add("User5");
		nguoiDung.add("User6");
		
		// Tạo một DefaultListModel và thêm dữ liệu từ ArrayList vào nó
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (String fruit : nguoiDung) {
			listModel.addElement(fruit);
		}

		// Tạo một JList và đặt DefaultListModel làm mô hình cho nó
		JList<String> jList_danhSachNguoiDung = new JList<>(listModel);
		chatList.add(jList_danhSachNguoiDung, BorderLayout.CENTER);
        
        //select btn
        JButton selectBtn = new JButton("Chọn");
        selectBtn.setBackground(headerPanel.getBackground());
        selectBtn.setPreferredSize(new Dimension(0, 40));
        Border blueBorder = BorderFactory.createLineBorder(Color.decode("#5ce1e6"), 4);
        selectBtn.setBorder(blueBorder);
        chatList.add(selectBtn, BorderLayout.SOUTH);
       
        
      
        setLayout(new BorderLayout());
        add(headerPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

      
        Dimension size = new Dimension(900, 550);
        setPreferredSize(size);
        pack();
    }

    public void khoiDong() {
        SwingUtilities.invokeLater(() -> {
            ChatAppUI frame = new ChatAppUI();
            frame.setVisible(true);
        });
    }
}
