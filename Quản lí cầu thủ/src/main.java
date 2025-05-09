package view;

import controller.DanhSachCauThu;
import model.CauThu;

public class Main {
    public static void main(String[] args) {
        DanhSachCauThu ds = new DanhSachCauThu();
        ds.them(new CauThu("CT01", "Nguyễn Văn A", 24, "Tiền đạo", 9, "Việt Nam"));
        ds.them(new CauThu("CT02", "Trần Văn B", 28, "Hậu vệ", 4, "Việt Nam"));

        System.out.println("Danh sách cầu thủ:");
        ds.hienThi();
    }
}