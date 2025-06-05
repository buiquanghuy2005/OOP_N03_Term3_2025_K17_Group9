package test;

import model.CauThu;
import model.CauThuService;

import java.util.ArrayList;
import java.util.List;

public class TestCauThuService {
    public static void runTests() {
        System.out.println("==== KIỂM THỬ: timKiem ====");

        List<CauThu> danhSach = new ArrayList<>();
        danhSach.add(new CauThu("Nguyen Van A", "CT01", 25, "Tiền vệ", 8, "Việt Nam"));
        danhSach.add(new CauThu("Le Van B", "CT02", 22, "Hậu vệ", 5, "Thái Lan"));
        danhSach.add(new CauThu("Tran Van C", "CT03", 28, "Tiền đạo", 9, "Việt Nam"));

        // Test: tìm theo tên
        List<CauThu> ketQua1 = CauThuService.timKiem(danhSach, "Van", null, null, null);
        System.out.println("Tìm tên 'Van': " + ketQua1.size() + " kết quả");

        // Test: theo vị trí
        List<CauThu> ketQua2 = CauThuService.timKiem(danhSach, null, "Tiền vệ", null, null);
        System.out.println("Tìm vị trí 'Tiền vệ': " + ketQua2.size() + " kết quả");

        // Test: theo tuổi
        List<CauThu> ketQua3 = CauThuService.timKiem(danhSach, null, null, 23, 30);
        System.out.println("Tìm tuổi từ 23 đến 30: " + ketQua3.size() + " kết quả");
    }
}

