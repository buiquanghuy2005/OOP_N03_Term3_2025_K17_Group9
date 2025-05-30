package Main;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserManager userManager = new UserManager();
    private static final List<CauThu> danhSachCauThu = new ArrayList<>();

    public static void main(String[] args) {
        User currentUser = null;

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Thêm cầu thủ (sau khi đăng nhập)");
            System.out.println("4. Hiển thị cầu thủ");
            System.out.println("5. Tính tổng số áo (đệ quy)");
            System.out.println("6. Tìm kiếm cầu thủ");
            System.out.println("7. Thoát");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    dangKy();
                    break;
                case 2:
                    currentUser = dangNhap();
                    break;
                case 3:
                    if (currentUser != null) {
                        themCauThu();
                    } else {
                        System.out.println("Bạn cần đăng nhập trước.");
                    }
                    break;
                case 4:
                    hienThiCauThu();
                    break;
                case 5:
                    tinhTongSoAo();
                    break;
                case 6:
                    timKiemCauThu();
                    break;
                case 7:
                    System.out.println("Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void dangKy() {
        System.out.print("Tên đăng ký: ");
        String username = scanner.nextLine();
        System.out.print("Vai trò (Admin/Coach): ");
        String role = scanner.nextLine();
        System.out.print("Mật khẩu: ");
        String password = scanner.nextLine();
        userManager.register(username, role, password);
    }

    private static User dangNhap() {
        System.out.print("Tên đăng nhập: ");
        String username = scanner.nextLine();
        System.out.print("Mật khẩu: ");
        String password = scanner.nextLine();
        return userManager.login(username, password);
    }

    private static void themCauThu() {
        System.out.print("Mã cầu thủ: ");
        String ma = scanner.nextLine();
        System.out.print("Họ tên: ");
        String ten = scanner.nextLine();
        System.out.print("Tuổi: ");
        int tuoi = Integer.parseInt(scanner.nextLine());
        System.out.print("Vị trí: ");
        String vitri = scanner.nextLine();
        System.out.print("Số áo: ");
        int soAo = Integer.parseInt(scanner.nextLine());
        System.out.print("Quốc tịch: ");
        String qt = scanner.nextLine();

        CauThu ct = new CauThu(ma, ten, tuoi, vitri, soAo, qt);
        danhSachCauThu.add(ct);
        System.out.println("Thêm cầu thủ thành công!");
    }

    private static void hienThiCauThu() {
        if (danhSachCauThu.isEmpty()) {
            System.out.println("Chưa có cầu thủ nào.");
        } else {
            for (CauThu ct : danhSachCauThu) {
                ct.hienThiThongTin();
                System.out.println("--------------");
            }
        }
    }

    private static void tinhTongSoAo() {
        if (danhSachCauThu.isEmpty()) {
            System.out.println("Không có dữ liệu cầu thủ.");
            return;
        }

        List<Integer> soAos = new ArrayList<>();
        for (CauThu ct : danhSachCauThu) {
            soAos.add(ct.getSoAo());
        }

        int tong = Recursion.tongSoAo(soAos, 0);
        System.out.println("Tổng số áo của cầu thủ: " + tong);
    }

    // 🔍 Phương thức tìm kiếm cầu thủ
    private static void timKiemCauThu() {
        if (danhSachCauThu.isEmpty()) {
            System.out.println("Chưa có cầu thủ nào để tìm kiếm.");
            return;
        }

        System.out.print("Nhập tên (Enter để bỏ qua): ");
        String ten = scanner.nextLine().trim();
        ten = ten.isEmpty() ? null : ten;

        System.out.print("Nhập vị trí (Enter để bỏ qua): ");
        String viTri = scanner.nextLine().trim();
        viTri = viTri.isEmpty() ? null : viTri;

        System.out.print("Nhập tuổi tối thiểu (nhập -1 nếu bỏ qua): ");
        int minTuoiInput = Integer.parseInt(scanner.nextLine());
        Integer minTuoi = (minTuoiInput >= 0) ? minTuoiInput : null;

        System.out.print("Nhập tuổi tối đa (nhập -1 nếu bỏ qua): ");
        int maxTuoiInput = Integer.parseInt(scanner.nextLine());
        Integer maxTuoi = (maxTuoiInput >= 0) ? maxTuoiInput : null;

        List<CauThu> ketQua = new ArrayList<>();

        for (CauThu ct : danhSachCauThu) {
            boolean thoaMan = true;

            if (ten != null && !ct.getTen().toLowerCase().contains(ten.toLowerCase())) thoaMan = false;
            if (viTri != null && !ct.getViTri().equalsIgnoreCase(viTri)) thoaMan = false;
            if (minTuoi != null && ct.getTuoi() < minTuoi) thoaMan = false;
            if (maxTuoi != null && ct.getTuoi() > maxTuoi) thoaMan = false;

            if (thoaMan) ketQua.add(ct);
        }

        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy cầu thủ phù hợp.");
        } else {
            System.out.println("\nKết quả tìm kiếm:");
            for (CauThu ct : ketQua) {
                ct.hienThiThongTin();
                System.out.println("--------------");
            }
        }
    }
}
