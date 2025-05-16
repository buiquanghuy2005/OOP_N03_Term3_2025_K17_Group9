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
            System.out.println("6. Thoát");
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
}
