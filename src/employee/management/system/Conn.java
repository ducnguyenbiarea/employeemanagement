package employee.management.system;

import java.sql.*;

public class Conn {

    public Connection c; // Đổi thành public để truy cập bên ngoài nếu cần
    public Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "30092004");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Phương thức thêm mới Employee an toàn
    public void insertEmployee(Employee employee) {
        String query = "INSERT INTO Employee (name, dob, salary, address, phone, email, education, designation, cccd, empId) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = c.prepareStatement(query)) {
            pstmt.setString(1, employee.getTfname());
            pstmt.setString(2, employee.getDcdob());
            pstmt.setDouble(3, employee.getTfsalary());
            pstmt.setString(4, employee.getTfaddress());
            pstmt.setString(5, employee.getTfphone());
            pstmt.setString(6, employee.getTfemail());
            pstmt.setString(7, employee.getCbeducation());
            pstmt.setString(8, employee.getDesignation());
            pstmt.setString(9, employee.getTfcccd());
            pstmt.setString(10, employee.getLblempId());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee added successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Đóng kết nối (khuyến nghị sử dụng khi xong việc)
    public void close() {
        try {
            if (c != null) c.close();
            if (s != null) s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
