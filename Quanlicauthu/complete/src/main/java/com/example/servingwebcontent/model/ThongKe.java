package model;

import java.util.*;

public class ThongKe {

    public static int tongSoCauThu(List<CauThu> danhSach) {
        return danhSach.size();
    }

    public static double tuoiTrungBinh(List<CauThu> danhSach) {
        if (danhSach.isEmpty()) return 0;
        int tong = 0;
        for (CauThu ct : danhSach) {
            tong += ct.getTuoi();
        }
        return (double) tong / danhSach.size();
    }

    public static int tongSoBanThang(List<CauThu> danhSach) {
        int tong = 0;
        for (CauThu ct : danhSach) {
            tong += ct.getSoBanThang();
        }
        return tong;
    }

    public static int tongTheVang(List<CauThu> danhSach) {
        int tong = 0;
        for (CauThu ct : danhSach) {
            tong += ct.getTheVang();
        }
        return tong;
    }

    public static int tongTheDo(List<CauThu> danhSach) {
        int tong = 0;
        for (CauThu ct : danhSach) {
            tong += ct.getTheDo();
        }
        return tong;
    }

    public static CauThu cauThuGhiBanNhieuNhat(List<CauThu> danhSach) {
        if (danhSach.isEmpty()) return null;

        CauThu max = danhSach.get(0);
        for (CauThu ct : danhSach) {
            if (ct.getSoBanThang() > max.getSoBanThang()) {
                max = ct;
            }
        }
        return max;
    }

    public static CauThu cauThuLonTuoiNhat(List<CauThu> danhSach) {
        if (danhSach.isEmpty()) return null;

        CauThu max = danhSach.get(0);
        for (CauThu ct : danhSach) {
            if (ct.getTuoi() > max.getTuoi()) {
                max = ct;
            }
        }
        return max;
    }

    public static CauThu cauThuCaoNhat(List<CauThu> danhSach) {
        CauThu caoNhat = null;
        double maxChieuCao = -1;

        for (CauThu ct : danhSach) {
            try {
                double chieuCao = Double.parseDouble(ct.getChieuCao());
                if (chieuCao > maxChieuCao) {
                    maxChieuCao = chieuCao;
                    caoNhat = ct;
                }
            } catch (NumberFormatException e) {
                // Bỏ qua nếu chiều cao không hợp lệ
            }
        }

        return caoNhat;
    }

    public static Map<String, Integer> thongKeTheoViTri(List<CauThu> danhSach) {
        Map<String, Integer> ketQua = new HashMap<>();
        for (CauThu ct : danhSach) {
            String viTri = ct.getViTri();
            ketQua.put(viTri, ketQua.getOrDefault(viTri, 0) + 1);
        }
        return ketQua;
    }

    public static Map<String, Integer> thongKeTheoQuocTich(List<CauThu> danhSach) {
        Map<String, Integer> ketQua = new HashMap<>();
        for (CauThu ct : danhSach) {
            String qt = ct.getQuocTich();
            ketQua.put(qt, ketQua.getOrDefault(qt, 0) + 1);
        }
        return ketQua;
    }
}
