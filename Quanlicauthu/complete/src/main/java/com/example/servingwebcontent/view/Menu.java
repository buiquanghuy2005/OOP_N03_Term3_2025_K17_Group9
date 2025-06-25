package com.example.servingwebcontent.view;

import com.example.servingwebcontent.model.CauThu;
import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.manager.CauThuService;
import com.example.servingwebcontent.manager.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = new UserService();
    private static final CauThuService cauThuService = new CauThuService();
    private static final List<CauThu> danhSachCauThu = new ArrayList<>();

    public void hienThiDanhSach(List<CauThu> danhSach) {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách cầu thủ trống.");
        } else {
            System.out.println("===== Danh sách cầu thủ =====");
            System.out.printf("%-10s %-20s %-5s %-15s %-15s %-10s %-15s %-15s %-15s%n",
                    "Mã", "Tên", "Tuổi", "Vị trí", "Quốc tịch", "Số áo", "Bàn thắng", "Thẻ vàng", "Thẻ đỏ");

            for (CauThu ct : danhSach) {
                System.out.printf("%-10s %-20s %-5d %-15s %-15s %-10d %-15d %-15d %-15d%n",
                        ct.getMa(), ct.getHoTen(), ct.getTuoi(), ct.getViTri(), ct.getQuocTich(), ct.getSoAo(),
                        ct.getSoBanThang(), ct.getTheVang(), ct.getTheDo());
            }
        }
    }

    public static void hienThiMenu() {
        User currentUser = null;
        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Thêm cầu thủ");
            System.out.println("4. Sửa thông tin cầu thủ");
            System.out.println("5. Xóa cầu thủ");
            System.out.println("6. Tìm kiếm cầu thủ");
            System.out.println("7. Hiển thị danh sách cầu thủ");
            System.out.println("8. Thoát");
            System.out.print("Chọn: ");

            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số.");
                continue;
            }

            switch (choice) {
                case 1:
                    dangKy();
                    break;
                case 2:
                    currentUser = dangNhap();
                    break;
                case 3:
                    if (isLoggedIn(currentUser)) {
                        System.out.print("Mã cầu thủ: ");
                        String ma = scanner.nextLine();
                        System.out.print("Họ tên: ");
                        String hoTen = scanner.nextLine();
                        System.out.print("Vị trí: ");
                        String viTri = scanner.nextLine();
                        System.out.print("Số áo: ");
                        int soAo = Integer.parseInt(scanner.nextLine());
                        System.out.print("Quốc tịch: ");
                        String quocTich = scanner.nextLine();
                        System.out.print("Chiều cao: ");
                        String chieuCao = scanner.nextLine();
                        System.out.print("Cân nặng: ");
                        String canNang = scanner.nextLine();
                        System.out.print("Số bàn thắng: ");
                        int soBanThang = Integer.parseInt(scanner.nextLine());
                        System.out.print("Số thẻ vàng: ");
                        int theVang = Integer.parseInt(scanner.nextLine());
                        System.out.print("Số thẻ đỏ: ");
                        int theDo = Integer.parseInt(scanner.nextLine());
                        System.out.print("Ngày sinh (yyyy-MM-dd): ");
                        LocalDate ngaySinh = LocalDate.parse(scanner.nextLine());
                        System.out.print("Ngày hết hạn hợp đồng (yyyy-MM-dd): ");
                        LocalDate ngayHetHanHopDong = LocalDate.parse(scanner.nextLine());

                        CauThu ct = new CauThu(ma, hoTen, viTri, soAo, quocTich, chieuCao, canNang,
                                soBanThang, theVang, theDo, ngaySinh, ngayHetHanHopDong);
                        cauThuService.themCauThu(ct);
                        danhSachCauThu.add(ct);
                    }
                    break;

                case 4:
                    if (isLoggedIn(currentUser)) {
                        System.out.print("Nhập mã cầu thủ cần sửa: ");
                        String ma = scanner.nextLine();
                        System.out.print("Nhập tên mới: ");
                        String tenMoi = scanner.nextLine();
                        System.out.print("Nhập số áo mới: ");
                        int soAoMoi = Integer.parseInt(scanner.nextLine());
                        cauThuService.suaCauThu(ma, tenMoi, soAoMoi);
                    }
                    break;

                case 5:
                    if (isLoggedIn(currentUser)) {
                        System.out.print("Nhập mã cầu thủ cần xoá: ");
                        String ma = scanner.nextLine();
                        cauThuService.xoaCauThu(ma);
                        danhSachCauThu.removeIf(ct -> ct.getMa().equals(ma));
                    }
                    break;

                case 6:
                    if (isLoggedIn(currentUser)) {
                        System.out.println("Nhập thông tin tìm kiếm (để trống nếu không lọc theo tiêu chí đó):");
                        System.out.print("Mã: ");
                        String ma = scanner.nextLine();
                        System.out.print("Tên: ");
                        String ten = scanner.nextLine();
                        System.out.print("Vị trí: ");
                        String viTri = scanner.nextLine();
                        System.out.print("Tuổi: ");
                        String tuoiStr = scanner.nextLine();
                        Integer tuoi = tuoiStr.isEmpty() ? null : Integer.parseInt(tuoiStr);
                        System.out.print("Quốc tịch: ");
                        String quocTich = scanner.nextLine();
                        System.out.print("Số áo: ");
                        String soAoStr = scanner.nextLine();
                        Integer soAo = soAoStr.isEmpty() ? null : Integer.parseInt(soAoStr);
                        System.out.print("Số bàn thắng: ");
                        String banThangStr = scanner.nextLine();
                        Integer banThang = banThangStr.isEmpty() ? null : Integer.parseInt(banThangStr);
                        System.out.print("Số thẻ vàng: ");
                        String theVangStr = scanner.nextLine();
                        Integer theVang = theVangStr.isEmpty() ? null : Integer.parseInt(theVangStr);
                        System.out.print("Số thẻ đỏ: ");
                        String theDoStr = scanner.nextLine();
                        Integer theDo = theDoStr.isEmpty() ? null : Integer.parseInt(theDoStr);

                        List<CauThu> ketQua = cauThuService.timKiem(ma, ten, viTri, tuoi, quocTich, soAo, banThang, theVang, theDo);
                        new Menu().hienThiDanhSach(ketQua);
                    }
                    break;

                case 7:
                    new Menu().hienThiDanhSach(danhSachCauThu);
                    break;

                case 8:
                    System.out.println("Tạm biệt!");
                    running = false;
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
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
        userService.register(username, role, password);
    }

    private static User dangNhap() {
        System.out.print("Tên đăng nhập: ");
        String username = scanner.nextLine();
        System.out.print("Mật khẩu: ");
        String password = scanner.nextLine();
        return userService.login(username, password);
    }

    private static boolean isLoggedIn(User user) {
        if (user == null) {
            System.out.println("Bạn cần đăng nhập trước.");
            return false;
        }
        return true;
    }
}
