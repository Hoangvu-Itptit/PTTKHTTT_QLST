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

    public boolean kiemTraThongTinKhachHang(ThanhVien399 thanhVien) {
        PreparedStatement stmt = null;
        try {
            // Truy vấn kiểm tra thông tin thành viên
            String query = "INSERT INTO tblKhachHang399(tenDangNhap, matKhau, ten, diaChi, dienThoai, email) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, thanhVien.tenDangNhap);
            stmt.setString(2, thanhVien.matKhau);
            stmt.setString(3, thanhVien.thongTin.ten);
            stmt.setString(4, thanhVien.thongTin.diaChi);
            stmt.setString(5, thanhVien.thongTin.sdt);
            stmt.setString(6, thanhVien.thongTin.email);

            // Thực thi truy vấn
            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng các tài nguyên
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void luuThongTinKhachHang(ThanhVien399 thanhVien) {
        PreparedStatement stmt = null;
        try {
            // Truy vấn lưu thông tin thành viên
            String query = "INSERT INTO tblKhachHang399(maThanhVien, tenDangNhap, matKhau, ten, diaChi, dienThoai, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, thanhVien.maThanhVien);
            stmt.setString(2, thanhVien.tenDangNhap);
            stmt.setString(3, thanhVien.matKhau);
            stmt.setString(4, thanhVien.thongTin.ten);
            stmt.setString(5, thanhVien.thongTin.diaChi);
            stmt.setString(6, thanhVien.thongTin.sdt);
            stmt.setString(7, thanhVien.thongTin.email);

            // Thực thi truy vấn
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng các tài nguyên
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int soLuongKhachHang() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Truy vấn lấy số lượng thành viên
            String query = "SELECT COUNT(*) AS soLuong FROM tblKhachHang399";
            stmt = conn.prepareStatement(query);

            // Thực thi truy vấn
            rs = stmt.executeQuery();

            // Kiểm tra kết quả và trả về số lượng thành viên
            if (rs.next()) {
                return rs.getInt("soLuong");
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
        return 0;
    }
}
