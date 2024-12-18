package employee.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JTextField tfname, tfeducation, tfaddress, tfphone, tfcccd, tfemail, tfsalary, tfdesignation;
    JLabel lblempId;
    JButton detail, back;
    String empId;
    JComboBox cbeducation;
    JDateChooser dcdob;
    
    UpdateEmployee(String empId) {
        
        JLabel heading = new JLabel("Cập nhật thông tin nhân viên");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading); 
        
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel labelname = new JLabel("Họ và tên");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel labelphone = new JLabel("Điện thoại");
        labelphone.setBounds(400, 150, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 150, 150, 30);
        add(tfphone);
        
        JLabel labeldob = new JLabel("Ngày sinh");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        
        
        JLabel labelsalary = new JLabel("Lương");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);
        
        JLabel labeladdress = new JLabel("Địa chỉ");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(400, 250, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(600, 250, 150, 30);
        add(tfemail);
        
        JLabel labeleducation = new JLabel("Học vấn");
        labeleducation.setBounds(50, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        String courses[] = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(200, 300, 150, 30);
        add(cbeducation);
        
        JLabel labeldesignation = new JLabel("Chức vụ");
        labeldesignation.setBounds(400, 300, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(600, 300, 150, 30);
        add(tfdesignation);
        
        JLabel labelcccd = new JLabel("Số CCCD");
        labelcccd.setBounds(50, 350, 150, 30);
        labelcccd.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelcccd);
        
        tfcccd = new JTextField();
        tfcccd.setBounds(200, 350, 150, 30);
        add(tfcccd);
        
        JLabel labelempId = new JLabel("Mã nhân viên");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        detail = new JButton("Thêm");
        detail.setBounds(250, 550, 150, 40);
        detail.addActionListener(this);
        detail.setBackground(Color.WHITE);
        detail.setForeground(Color.BLACK);
        add(detail);
        
        back = new JButton("Quay lại");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        add(back);
        
        
        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                tfname.setText(rs.getString("name"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tfcccd.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
                tfdesignation.setText(rs.getString("designation"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        detail = new JButton("Thay đổi chi tiết");
        detail.setBounds(250, 550, 150, 40);
        detail.addActionListener(this);
        detail.setBackground(Color.BLACK);
        detail.setForeground(Color.WHITE);
        add(detail);
        
        back = new JButton("Quay lại");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == detail) {
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
            
            try {
                Conn conn = new Conn();
                String query = "update employee set salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
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