package Model;

import java.util.HashMap;
import java.util.List;

public class PhieuLayHang399 {

    public String maPhieuLayHang;
    public String maDonHang;
    public List<String> danhSachMaMatHang;
    public HashMap<String, Integer> soLuongMatHang;
    public HashMap<String, Double> donGiaMatHang;

    public PhieuLayHang399(String maPhieuLayHang, String maDonHang, List<String> danhSachMaMatHang, HashMap<String, Integer> soluongMatHang, HashMap<String, Double> donGiaMatHang) {
        this.maPhieuLayHang = maPhieuLayHang;
        this.maDonHang = maDonHang;
        this.danhSachMaMatHang = danhSachMaMatHang;
        this.soLuongMatHang = soluongMatHang;
        this.donGiaMatHang = donGiaMatHang;
    }

    public double getTongGiaTriCuaMatHangTrongPhieu(String maMatHang) {
        var giaTri = 0f;
        for (var mh : danhSachMaMatHang) {
            if (mh.equals(maMatHang)) {
                giaTri += (float) (donGiaMatHang.get(maMatHang) * soLuongMatHang.get(maMatHang));
            }
        }

        return giaTri;
    }

    public int getSoLuongCuaMatHangTrongPhieu(String maMatHang) {
        var soluong = 0;
        for (var mh : danhSachMaMatHang) {
            if (mh.equals(maMatHang)) {
                soluong += soLuongMatHang.get(maMatHang);
            }
        }

        return soluong;
    }
    
    public boolean tonTaiMatHangTrongPhieu(String maMatHang){
        for (var mh : danhSachMaMatHang) {
            if(mh.equals(maMatHang)) return true;
        }
        
        return false;
    }
}
