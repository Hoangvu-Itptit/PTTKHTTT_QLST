package Model;

import java.util.HashMap;
import java.util.List;

public class PhieuLayHang399 {

    public String maPhieuLayHang;
    public String maDonHang;
    public List<String> danhSachMaMatHang;
    public HashMap<String, Integer> soLuongMatHang;

    public PhieuLayHang399(String maPhieuLayHang, String maDonHang, List<String> danhSachMaMatHang, HashMap<String, Integer> soluongMatHang) {
        this.maPhieuLayHang = maPhieuLayHang;
        this.maDonHang = maDonHang;
        this.danhSachMaMatHang = danhSachMaMatHang;
        this.soLuongMatHang = soluongMatHang;
    }

    public double getTongGiaTriCuaMatHangTrongPhieu(MatHang399 matHang) {
        var giaTri = 0f;
        for (var mh : danhSachMaMatHang) {
            if (mh.equals(matHang.maMatHang)) {
                giaTri += matHang.gia * soLuongMatHang.get(matHang.maMatHang);
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
