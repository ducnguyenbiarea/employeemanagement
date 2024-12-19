
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername, tfpassword;

     Login() {
         
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         JLabel lblusername = new JLabel("Username");
         lblusername.setBounds(40, 20, 100, 30);
         add(lblusername);
         
          tfusername = new JTextField();
         tfusername.setBounds(150, 20, 150, 30);
         add(tfusername);        
         
         JLabel lblpassword = new JLabel("Password");
         lblpassword.setBounds(40, 70, 100, 30);
         add(lblpassword);
         
          tfpassword = new JTextField();
         tfpassword.setBounds(150, 70, 150, 30);
         add(tfpassword);        
         
         JButton login = new JButton("LOGIN");
         login.setBounds(150, 140, 150, 30);
         login.setBackground(Color.BLACK);
         login.setBackground(Color.WHITE);
         login.addActionListener(this);
         add(login);
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
         Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(350, 0, 200, 200);
         add(image);
         
         setSize(600, 300);
         setLocation(450, 200);
         setVisible(true);
    }
     
    @Override
public void actionPerformed(ActionEvent ae) {
    try {
        String username = tfusername.getText().trim();
        String password = tfpassword.getText().trim();
        
        // Kiểm tra nếu username hoặc password bị để trống
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ Username và Password");
            return;
        }
        
        Conn c = new Conn(); // Tạo đối tượng Conn
        
        // Kiểm tra nếu kết nối cơ sở dữ liệu thất bại
        if (c.c == null) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối tới cơ sở dữ liệu");
            return;
        }

        // Sử dụng PreparedStatement
        String query = "SELECT * FROM login WHERE username = ? AND password = ?";
        PreparedStatement pst = c.c.prepareStatement(query);
        pst.setString(1, username.toLowerCase());
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            setVisible(false);
            new Home(); // Chuyển đến trang chính nếu đăng nhập thành công
        } else {
            JOptionPane.showMessageDialog(null, "Username hoặc password không hợp lệ");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi hệ thống. Vui lòng thử lại sau.");
    }
}


    public static void main(String[] args) {
        new Login();
    }
}
