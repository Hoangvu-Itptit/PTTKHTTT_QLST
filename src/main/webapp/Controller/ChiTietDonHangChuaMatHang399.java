package Controller;

import DAO.*;
import Model.DonHang399;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet(urlPatterns = {"/ChiTietDonHangChuaMatHang399"})
public class ChiTietDonHangChuaMatHang399 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getDanhSachDonHang(request, response);
    }

    protected void getDanhSachDonHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var startDate = request.getParameter("startDate");
        var endDate = request.getParameter("endDate");
        var maMatHang = request.getParameter("itemID");
        System.out.println("Chi tiet don hang chua mat hang: startDate: " + startDate);
        System.out.println("Chi tiet don hang chua mat hang: endDate: " + endDate);
        var danhSachDonHangChuaMatHangTrongNgayDaChon = getDanhSachDonHangChuaMatHangTrongNgayDaChon(maMatHang, startDate, endDate);
        var jsonArray = new JSONArray();
        var index = 1;
        var giaTriMatHangTrongNgayDaChon = 0f;
        for (var giaTriDonHang : danhSachDonHangChuaMatHangTrongNgayDaChon) {
            var donHang = giaTriDonHang.getKey();
            var giaTri = giaTriDonHang.getValue();
            var jsonObject = new JSONObject();
            jsonObject.put("stt", index++);
            jsonObject.put("maDonHang", donHang.maDonHang);
            jsonObject.put("tenKhachHang", new ThanhVienDAO399().getKhachHang(donHang.maKhachHang).thongTin.ten);
            jsonObject.put("ngayMua", donHang.thoiGianMuaHang);
            jsonObject.put("soLuongSanPham", giaTri.getKey());
            jsonObject.put("giaTri", giaTri.getValue());
            jsonArray.add(jsonObject);

            giaTriMatHangTrongNgayDaChon += giaTri.getValue();
        }
        request.setAttribute("ordersJson", jsonArray.toString());
        request.setAttribute("tenSanPham", new MatHangDAO399().getMatHang(maMatHang).ten);
        request.setAttribute("giaTri", (int) giaTriMatHangTrongNgayDaChon);
        request.setAttribute("ngayBatDau", startDate);
        request.setAttribute("ngayKetThuc", endDate);
        request.getRequestDispatcher("GDChiTietMatHang399.jsp").forward(request, response);
    }

    private List<Map.Entry<DonHang399, Map.Entry<Integer, Double>>> getDanhSachDonHangChuaMatHangTrongNgayDaChon(String maMatHang, String startDate, String endDate) {
        var danhSachDonHangChuaMatHang = new ArrayList<Map.Entry<DonHang399, Map.Entry<Integer, Double>>>();
        var donHangDAO = new DonHangDAO399();
        var phieuLayHangDAO = new PhieuLayHangDAO399();
        var danhSachDonHang = donHangDAO.getDanhSachDonHang(startDate, endDate);

        System.out.println(danhSachDonHang.size());

        for (var donHang : danhSachDonHang) {
            var phieuLayHang = phieuLayHangDAO.getPhieuLayHang(donHang.maDonHang);
            if (phieuLayHang.tonTaiMatHangTrongPhieu(maMatHang)) {
                danhSachDonHangChuaMatHang.add(
                        new java.util.AbstractMap.SimpleEntry<>(
                                donHang,
                                new java.util.AbstractMap.SimpleEntry<>(
                                        phieuLayHang.getSoLuongCuaMatHangTrongPhieu(maMatHang),
                                        phieuLayHang.getTongGiaTriCuaMatHangTrongPhieu(maMatHang)
                                )
                        )
                );
            }
        }

        System.out.println(danhSachDonHangChuaMatHang.size());

        return danhSachDonHangChuaMatHang;
    }
}
