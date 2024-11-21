package DAO;

import Model.PhieuLayHang399;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhieuLayHangDAO399 extends DAO399 {
    public PhieuLayHangDAO399() {
        super();  // Kế thừa kết nối từ lớp cha DAO399
    }

    public PhieuLayHang399 getPhieuLayHang(String maDonHang) {
        PhieuLayHang399 phieuLayHang = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Truy vấn lấy thông tin phiếu lấy hàng từ maDonHang
            String query = "SELECT * FROM tblPhieuLayHang399 WHERE maDonHang = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, maDonHang);  // Thêm giá trị vào câu query

            // Thực thi truy vấn
            rs = stmt.executeQuery();

            // Kiểm tra kết quả và ánh xạ vào đối tượng PhieuLayHang
            if (rs.next()) {
                String maPhieuLayHang = rs.getString("MaPhieuLayHang");
                String maDonHangResult = rs.getString("MaDonHang");

                // Truy vấn lấy danh sách mặt hàng trong phiếu
                String queryMatHangTrongPhieu = "SELECT * FROM tblMatHangTrongPhieu399 WHERE maPhieuLayHang = ?";
                PreparedStatement stmtMatHangTrongPhieu = conn.prepareStatement(queryMatHangTrongPhieu);
                stmtMatHangTrongPhieu.setString(1, maPhieuLayHang);
                ResultSet rsMatHangTrongPhieu = stmtMatHangTrongPhieu.executeQuery();

                // Khởi tạo danh sách mặt hàng và số lượng mặt hàng
                List<String> danhSachMaMatHang = new ArrayList<>();
                HashMap<String, Integer> soLuongMatHang = new HashMap<>();
                HashMap<String, Double> donGiaMatHang = new HashMap<>();

                // Lấy dữ liệu mặt hàng trong phiếu
                while (rsMatHangTrongPhieu.next()) {
                    String maMatHang = rsMatHangTrongPhieu.getString("maMatHang");
                    int soLuong = rsMatHangTrongPhieu.getInt("soLuongMatHang");
                    double donGia = rsMatHangTrongPhieu.getDouble("donGiaMatHang");
                    danhSachMaMatHang.add(maMatHang);
                    soLuongMatHang.put(maMatHang, soLuong);
                    donGiaMatHang.put(maMatHang, donGia);
                }

                // Tạo đối tượng PhieuLayHang399 và trả về
                phieuLayHang = new PhieuLayHang399(maPhieuLayHang, maDonHangResult, danhSachMaMatHang, soLuongMatHang, donGiaMatHang);
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
        return phieuLayHang;
    }
}
