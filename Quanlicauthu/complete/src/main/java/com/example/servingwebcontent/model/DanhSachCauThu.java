package com.example.servingwebcontent.model;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class DanhSachCauThu {
    private ArrayList<CauThu> danhSach = new ArrayList<>();
    private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public void themCauThu(CauThu ct) {
        try {
            danhSach.add(ct);
            System.out.println("Đã thêm cầu thủ: " + ct.getHoTen());
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm cầu thủ: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất thao tác thêm cầu thủ.");
        }
    }

    public void suaCauThu(String maCauThu, String hoTenMoi, int soAoMoi) {
        try {
            for (CauThu ct : danhSach) {
                if (ct.getMa().equals(maCauThu)) {
                    ct.setHoTen(hoTenMoi);
                    ct.setSoAo(soAoMoi);
                    System.out.println("Đã cập nhật thông tin cầu thủ có mã " + maCauThu);
                    return;
                }
            }
            System.out.println("Không tìm thấy cầu thủ có mã " + maCauThu);
        } catch (Exception e) {
            System.out.println("Lỗi khi sửa cầu thủ: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất thao tác sửa cầu thủ.");
        }
    }

    public void xoaCauThu(String maCauThu) {
        try {
            for (int i = 0; i < danhSach.size(); i++) {
                if (danhSach.get(i).getMa().equals(maCauThu)) {
                    System.out.println("Đã xóa cầu thủ: " + danhSach.get(i).getHoTen());
                    danhSach.remove(i);
                    return;
                }
            }
            System.out.println("Không tìm thấy cầu thủ có mã " + maCauThu);
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa cầu thủ: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất thao tác xóa cầu thủ.");
        }
    }

    public void hienThiDanhSachCauThu() {
        try {
            if (danhSach.isEmpty()) {
                System.out.println("Đội bóng chưa có cầu thủ nào.");
            } else {
                System.out.println("Danh sách cầu thủ:");
                for (CauThu ct : danhSach) {
                    ct.hienThiThongTin();
                    System.out.println("------");
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất thao tác hiển thị danh sách.");
        }
    }

    public List<CauThu> timKiemTheoTieuChi(String ma, String ten, String viTri, Integer soAo,
                                           String quocTich, String chieuCao, String canNang,
                                           Integer soBanThang, Integer theVang, Integer theDo) {
        List<CauThu> ketQua = new ArrayList<>();
        for (CauThu ct : danhSach) {
            if ((ma == null || ct.getMa().equalsIgnoreCase(ma)) &&
                (ten == null || ct.getHoTen().equalsIgnoreCase(ten)) &&
                (viTri == null || ct.getViTri().equalsIgnoreCase(viTri)) &&
                (soAo == null || ct.getSoAo() == soAo) &&
                (quocTich == null || ct.getQuocTich().equalsIgnoreCase(quocTich)) &&
                (chieuCao == null || ct.getChieuCao().equalsIgnoreCase(chieuCao)) &&
                (canNang == null || ct.getCanNang().equalsIgnoreCase(canNang)) &&
                (soBanThang == null || ct.getSoBanThang() == soBanThang) &&
                (theVang == null || ct.getTheVang() == theVang) &&
                (theDo == null || ct.getTheDo() == theDo)) {
                ketQua.add(ct);
            }
        }
        return ketQua;
    }

    public List<CauThu> getDanhSach() {
        return danhSach;
    }
    @PostConstruct
    public void khoiTaoDuLieuMau() {
        try {
            CauThu cauThuMau = new CauThu(
                "CT001",
                "Nguyễn Văn A",
                "Tiền đạo",
                9,
                "Việt Nam",
                "1m75",
                "70kg",
                10,
                1,
                0,
                LocalDate.parse("01/01/1995", df),
                LocalDate.parse("31/12/2025", df)
            );
            themCauThu(cauThuMau);
            System.out.println("Đã thêm cầu thủ mẫu khi khởi động ứng dụng.");
        } catch (Exception e) {
            System.out.println("Lỗi khi tạo cầu thủ mẫu: " + e.getMessage());
        }
    }
}
