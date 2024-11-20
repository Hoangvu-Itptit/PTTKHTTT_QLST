package DAO;

import Model.ThanhVien399;
import Model.ThongTin399;

import java.sql.*;

public class ThanhVienDAO399 extends DAO399 {
    public ThanhVienDAO399() {
        super();  // Kế thừa kết nối từ lớp cha DAO399
    }

    public ThanhVien399 getKhachHang(String maThanhVien) {
        ThanhVien399 thanhVien = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Truy vấn lấy thông tin thành viên từ maThanhVien
            String query = "SELECT * FROM tblKhachHang399 WHERE maThanhVien = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, maThanhVien);  // Thêm giá trị vào câu query

            // Thực thi truy vấn
            rs = stmt.executeQuery();

            // Kiểm tra kết quả và ánh xạ vào đối tượng ThanhVien
            if (rs.next()) {
                String maThanhVienResult = rs.getString("maThanhVien");
                String userName = rs.getString("tenDangNhap");
                String password = rs.getString("matKhau");
                String ten = rs.getString("ten");
                String diaChi = rs.getString("diaChi");
                String email = rs.getString("email");
                String dienThoai = rs.getString("dienThoai");

                // Tạo đối tượng ThanhVien399 và trả về
                thanhVien = new ThanhVien399(maThanhVienResult, userName, password, new ThongTin399(ten, diaChi, email, dienThoai));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng các tài nguyên
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return thanhVien;
    }
}
