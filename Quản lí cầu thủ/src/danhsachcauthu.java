package controller;

import model.CauThu;
import java.util.ArrayList;

public class DanhSachCauThu {
    private ArrayList<CauThu> danhSach = new ArrayList<>();

    public void them(CauThu ct) {
        danhSach.add(ct);
    }

    public void hienThi() {
        for (CauThu ct : danhSach) {
            System.out.println(ct);
        }
    }

    public CauThu timTheoTen(String ten) {
        for (CauThu ct : danhSach) {
            if (ct.getHoTen().contains(ten)) return ct;
        }
        return null;
    }
}