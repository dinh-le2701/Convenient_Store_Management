package convenient_store.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login_Gui extends JFrame implements ActionListener {
	private JPanel pc;
	private JTextField txtUsername, txtPwd;
	private JLabel lbUsername, lbPwd;
	private JButton login;

	public Login_Gui() {
		super("Convenient Store");

		pc = new JPanel();
		txtUsername = new JTextField(15);
		txtPwd = new JTextField(15);

		lbUsername = new JLabel("Username: ");
		lbPwd = new JLabel("Password: ");

		login = new JButton("Login");
		pc.add(lbUsername);
		pc.add(txtUsername);
		pc.add(lbPwd);
		pc.add(txtPwd);
		pc.add(login);
		login.addActionListener(this);

		// add component into jframe
		add(pc, BorderLayout.CENTER);

		setVisible(true);
		setLocation(650, 350);
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == login) {
			login();
		}
	}

	private void login() {
	    String username = txtUsername.getText();
	    String password = txtPwd.getText(); // Lấy mật khẩu từ JPasswordField
	    
	    if (username.equals("admin") && password.equals("admin")) {
	    	Home_Gui home = new Home_Gui();
	    	
	    }

	    // Kiểm tra nếu username hoặc password trống
//	    if (username.isEmpty() || password.isEmpty()) {
//	        JOptionPane.showMessageDialog(this, "Vui lòng nhập tên đăng nhập và mật khẩu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//	        return;
//	    }

//	    // Kết nối tới cơ sở dữ liệu và kiểm tra tài khoản
//	    try (Connection conn = DBConnect.getConnection()) {
//	        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
//	        PreparedStatement pstmt = conn.prepareStatement(query);
//	        pstmt.setString(1, username);
//	        pstmt.setString(2, password);
//
//	        ResultSet rs = pstmt.executeQuery();
//	        if (rs.next()) {
//	            JOptionPane.showMessageDialog(this, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//	            // Chuyển đến màn hình tiếp theo hoặc thực hiện hành động khác
//	        } else {
//	            JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//	            txtPwd.setText("");
//	        }
//	    } catch (SQLException ex) {
//	        ex.printStackTrace();
//	        JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi kết nối cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//	    }
	}


}
