package DAO;

import Model.MatHang399;
import java.sql.*;

public class MatHangDAO399 extends DAO399 {

    public MatHangDAO399() {
        super();
    }

    public MatHang399 getMatHang(String maMatHang) {
        MatHang399 matHang = null;

        // Câu truy vấn SQL để lấy thông tin mặt hàng
        String sql = "SELECT * FROM tblMatHang399 WHERE maMatHang = ?";

        try {
            // Sử dụng preparedStatement để tránh SQL Injection
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maMatHang); // Set giá trị cho tham số maMatHang

            // Thực thi truy vấn và lấy kết quả
            ResultSet rs = ps.executeQuery();

            // Kiểm tra nếu có kết quả
            if (rs.next()) {
                // Khởi tạo đối tượng MatHang399 từ kết quả truy vấn
                matHang = new MatHang399(
                        rs.getString("maMatHang"),
                        rs.getString("maNhaCungCap"),
                        rs.getString("ten"),
                        rs.getDouble("gia"),
                        rs.getString("moTa")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matHang;
    }
}
