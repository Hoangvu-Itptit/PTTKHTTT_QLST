package DAO;

import Model.DonHang399;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonHangDAO399 extends DAO399 {

    public DonHangDAO399() {
        super();
    }

    public List<DonHang399> getDanhSachDonHang(String startDate, String endDate) {
        List<DonHang399> danhSachDonHangTrongNgay = new ArrayList<DonHang399>();

        // Câu truy vấn SQL với các tham số
        String query = "SELECT * FROM tblDonHang399 WHERE thoiGianMuaHang >= ? AND thoiGianMuaHang <= ?";

        // Sử dụng PreparedStatement để tránh SQL injection
        try {
            PreparedStatement stmt = conn.prepareStatement(query);

            // Gán giá trị cho tham số của câu truy vấn
            stmt.setString(1, startDate);
            stmt.setString(2, endDate);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    DonHang399 donHang = new DonHang399(
                            rs.getString("maDonHang"),
                            rs.getString("maThanhVien"),
                            rs.getString("thoiGianMuaHang"),
                            rs.getDouble("tongTien")
                    );
                    // Thêm đơn hàng vào danh sách
                    danhSachDonHangTrongNgay.add(donHang);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachDonHangTrongNgay;
    }
}