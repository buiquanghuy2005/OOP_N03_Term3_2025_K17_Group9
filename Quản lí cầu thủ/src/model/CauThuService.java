package model;
import java.util.ArrayList;
import java.util.List;

import model.CauThu;

@SuppressWarnings("unused")
public class CauThuService {
    public static List<CauThu> timKiem(List<CauThu> danhSach, String ten, String viTri, Integer minTuoi, Integer maxTuoi) {
        List<CauThu> ketQua = new ArrayList<>();

        for (CauThu ct : danhSach) {
            boolean thoaMan = true;

            if (ten != null && !ct.getTen().toLowerCase().contains(ten.toLowerCase())) {
                thoaMan = false;
            }
            if (viTri != null && !ct.getViTri().equalsIgnoreCase(viTri)) {
                thoaMan = false;
            }
            if (minTuoi != null && ct.getTuoi() < minTuoi) {
                thoaMan = false;
            }
            if (maxTuoi != null && ct.getTuoi() > maxTuoi) {
                thoaMan = false;
            }

            if (thoaMan) {
                ketQua.add(ct);
            }
        }

        return ketQua;
    }
}