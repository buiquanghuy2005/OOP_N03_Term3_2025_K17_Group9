package com.example.servingwebcontent.manager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import com.example.servingwebcontent.model.CauThu;
public class CauThuService {
    private static final Scanner scanner = new Scanner(System.in);
    public void themCauThu(List<CauThu> danhSach) {
        System.out.print("Nhập mã: ");
        String ma = scanner.nextLine();
        System.out.print("Nhập họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhập vị trí: ");
        String viTri = scanner.nextLine();
        System.out.print("Nhập số áo: ");
        int soAo = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập quốc tịch: ");
        String quocTich = scanner.nextLine();
        System.out.print("Nhập chiều cao: ");
        String chieuCao = scanner.nextLine();
        System.out.print("Nhập cân nặng: ");
        String canNang = scanner.nextLine();
        System.out.print("Nhập số bàn thắng: ");
        int soBanThang = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập số thẻ vàng: ");
        int theVang = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập số thẻ đỏ: ");
        int theDo = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        LocalDate ngaySinh = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Nhập ngày hết hạn hợp đồng (dd/MM/yyyy): ");
        LocalDate ngayHetHan = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        CauThu ct = new CauThu(ma, hoTen, viTri, soAo, quocTich, chieuCao, canNang, soBanThang, theVang, theDo, ngaySinh, ngayHetHan);
        danhSach.add(ct);
        System.out.println("Thêm cầu thủ thành công.");
    }
    public static void suaCauThu(List<CauThu> danhSach, String ma, String tenMoi, int soAoMoi) {
        for (CauThu ct : danhSach) {
            if (ct.getMa().equals(ma)) {
                ct.setHoTen(tenMoi);
                ct.setSoAo(soAoMoi);
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy cầu thủ để sửa.");
    }
    public static void xoaCauThu(List<CauThu> danhSach, String ma) {
        boolean removed = danhSach.removeIf(ct -> ct.getMa().equals(ma));
        if (removed) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không tìm thấy cầu thủ để xóa.");
        }
    }
    public static List<CauThu> timKiem(
        List<CauThu> danhSach,
        String ma,
        String ten,
        String viTri,
        Integer soAo,
        String quocTich,
        String chieuCao,
        String canNang,
        Integer soBanThang,
        Integer theVang,
        Integer theDo
    ) {
        List<CauThu> ketQua = danhSach.stream().filter(ct ->
            (ma == null || ct.getMa().equalsIgnoreCase(ma)) &&
            (ten == null || ct.getHoTen().toLowerCase().contains(ten.toLowerCase())) &&
            (viTri == null || ct.getViTri().equalsIgnoreCase(viTri)) &&
            (soAo == null || ct.getSoAo() == soAo) &&
            (quocTich == null || ct.getQuocTich().equalsIgnoreCase(quocTich)) &&
            (chieuCao == null || ct.getChieuCao().equalsIgnoreCase(chieuCao)) &&
            (canNang == null || ct.getCanNang().equalsIgnoreCase(canNang)) &&
            (soBanThang == null || ct.getSoBanThang() == soBanThang) &&
            (theVang == null || ct.getTheVang() == theVang) &&
            (theDo == null || ct.getTheDo() == theDo)
        ).collect(Collectors.toList());
        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy cầu thủ nào.");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (CauThu ct : ketQua) {
                ct.hienThiThongTin();
                System.out.println("-----------");
            }
        }
        return ketQua;
    }
    public void hienThiDanhSach(List<CauThu> danhSach) {
    if (danhSach.isEmpty()) {
        System.out.println("Danh sách cầu thủ trống.");
    } else {
        System.out.println("===== Danh sách cầu thủ =====");
        System.out.printf("%-10s %-20s %-5s %-15s %-15s %-15s %-10s %-15s %-15s %-15s%n",
                "Mã", "Tên", "Tuổi", "Vị trí", "Quốc tịch", "CLB", "Số áo", "Bàn thắng", "Thẻ vàng", "Thẻ đỏ");

        for (CauThu ct : danhSach) {
            System.out.printf("%-10s %-20s %-5d %-15s %-15s %-15s %-10s %-15d %-15d %-15d%n",
                    ct.getMa(), ct.getHoTen(), ct.getTuoi(), ct.getViTri(), ct.getQuocTich(),
                    ct.getSoAo(), ct.getSoBanThang(), ct.getTheVang(), ct.getTheDo());
        }
    }
}

}