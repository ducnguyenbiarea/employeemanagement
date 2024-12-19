package employee.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tfname, tfaddress, tfphone, tfcccd, tfemail, tfsalary, tfdesignation;
    JLabel lblempId;
    JButton update, back;
    JComboBox<String> cbeducation;
    JDateChooser dcdob;
    String empId;

    UpdateEmployee(String empId) {
        this.empId = empId;

        // Tiêu đề
        JLabel heading = new JLabel("Cập nhật thông tin nhân viên");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        // Giao diện cập nhật thông tin
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Họ và tên
        JLabel labelname = new JLabel("Họ và tên");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        // Điện thoại
        JLabel labelphone = new JLabel("Điện thoại");
        labelphone.setBounds(400, 150, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 150, 150, 30);
        add(tfphone);

        // Ngày sinh
        JLabel labeldob = new JLabel("Ngày sinh");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);

        // Lương
        JLabel labelsalary = new JLabel("Lương");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);

        // Địa chỉ
        JLabel labeladdress = new JLabel("Địa chỉ");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        // Email
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(400, 250, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(600, 250, 150, 30);
        add(tfemail);

        // Học vấn
        JLabel labeleducation = new JLabel("Học vấn");
        labeleducation.setBounds(50, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);

        String[] courses = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        cbeducation = new JComboBox<>(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(200, 300, 150, 30);
        add(cbeducation);

        // Chức vụ
        JLabel labeldesignation = new JLabel("Chức vụ");
        labeldesignation.setBounds(400, 300, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(600, 300, 150, 30);
        add(tfdesignation);

        // Số CCCD
        JLabel labelcccd = new JLabel("Số CCCD");
        labelcccd.setBounds(50, 350, 150, 30);
        labelcccd.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelcccd);

        tfcccd = new JTextField();
        tfcccd.setBounds(200, 350, 150, 30);
        add(tfcccd);

        // Mã nhân viên
        JLabel labelempId = new JLabel("Mã nhân viên");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);

        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);

        // Nút cập nhật
        update = new JButton("Cập nhật");
        update.setBounds(250, 550, 150, 40);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);

        // Nút quay lại
        back = new JButton("Quay lại");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        // Lấy thông tin nhân viên từ cơ sở dữ liệu
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM employee WHERE empid = '" + empId + "'";
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
                tfname.setText(rs.getString("name"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                cbeducation.setSelectedItem(rs.getString("education"));
                tfdesignation.setText(rs.getString("designation"));
                tfcccd.setText(rs.getString("cccd"));
                lblempId.setText(rs.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();

            try {
                Conn conn = new Conn();
                String query = "UPDATE employee SET salary = ?, address = ?, phone = ?, email = ?, education = ?, designation = ? WHERE empid = ?";
                PreparedStatement pstmt = conn.c.prepareStatement(query);
                pstmt.setString(1, salary);
                pstmt.setString(2, address);
                pstmt.setString(3, phone);
                pstmt.setString(4, email);
                pstmt.setString(5, education);
                pstmt.setString(6, designation);
                pstmt.setString(7, empId);

                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên");
                }
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
