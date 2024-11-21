package Controller;

import DAO.*;
import Model.MatHang399;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/ThongKeMatHangTheoDoanhThu399")
public class ThongKeMatHangTheoDoanhThu399 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        getDanhSachMatHang(request, response);
    }

    private void getDanhSachMatHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var startDate = request.getParameter("startDate");
        var endDate = request.getParameter("endDate");
        System.out.println("Thong ke mat hang theo doanh thu: startDate: " + startDate);
        System.out.println("Thong ke mat hang theo doanh thu: endDate: " + endDate);
        var danhSachMatHangDoanhThu = getDanhSachMatHang(startDate, endDate);
        var jsonArray = new JSONArray();
        for (var matHangDoanhThu : danhSachMatHangDoanhThu) {
            var jsonObject = new JSONObject();
            var matHang = matHangDoanhThu.getKey();
            var doanhThu = matHangDoanhThu.getValue();
            jsonObject.put("id", matHang.maMatHang);
            jsonObject.put("name", matHang.ten);
            jsonObject.put("quantity", doanhThu.getKey());
            jsonObject.put("revenue", (int) (double) doanhThu.getValue());
            jsonArray.add(jsonObject);
        }
        response.setContentType("application/json");
        response.getWriter().write(jsonArray.toString());
        System.out.println();
    }

    private List<Map.Entry<MatHang399, Map.Entry<Integer, Double>>> getDanhSachMatHang(String startDate, String endDate) {
        var dsMHvaDoanhThu = new ArrayList<Map.Entry<MatHang399, Map.Entry<Integer, Double>>>();
        var donHangDAO = new DonHangDAO399();
        var phieuLayHangDAO = new PhieuLayHangDAO399();
        var listDonHang = donHangDAO.getDanhSachDonHang(startDate, endDate);
        for (var dh : listDonHang) {
            var plh = phieuLayHangDAO.getPhieuLayHang(dh.maDonHang);
            for (var maMatHang : plh.danhSachMaMatHang) {
                var soluong = plh.getSoLuongCuaMatHangTrongPhieu(maMatHang);
                var giaTri = plh.getTongGiaTriCuaMatHangTrongPhieu(maMatHang);
                if (dsMHvaDoanhThu.stream().noneMatch((entry) -> entry.getKey().maMatHang.equals(maMatHang))) {
                    dsMHvaDoanhThu.add(new AbstractMap.SimpleEntry<>(new MatHangDAO399().getMatHang(maMatHang), new AbstractMap.SimpleEntry<>(soluong, giaTri)));
                } else {
                    var entry = dsMHvaDoanhThu.stream().filter((e) -> e.getKey().maMatHang.equals(maMatHang)).findFirst().get();
                    var newEntry = Map.entry(
                            entry.getKey(),
                            Map.entry(entry.getValue().getKey() + soluong, entry.getValue().getValue() + giaTri)
                    );
                    dsMHvaDoanhThu.set(dsMHvaDoanhThu.indexOf(entry), newEntry);
                }
            }
        }

        dsMHvaDoanhThu.sort((entry1, entry2) -> entry2.getValue().getValue().compareTo(entry1.getValue().getValue()));

        return dsMHvaDoanhThu;
    }
}
