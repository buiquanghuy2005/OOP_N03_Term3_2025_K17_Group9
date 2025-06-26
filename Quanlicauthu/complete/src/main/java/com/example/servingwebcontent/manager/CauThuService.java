package com.example.servingwebcontent.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.servingwebcontent.model.CauThu;
import com.example.servingwebcontent.repository.CauThuRepository;

import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Component
public class CauThuService {

    @Autowired
    private CauThuRepository cauThuRepository;

    private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void themCauThu(CauThu ct) {
        try {
            cauThuRepository.save(ct);
            System.out.println("Đã thêm cầu thủ: " + ct.getHoTen());
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm cầu thủ: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất thao tác thêm cầu thủ.");
        }
    }

    public void suaCauThu(String maCauThu, String hoTenMoi, int soAoMoi) {
        try {
            Optional<CauThu> optional = cauThuRepository.findById(maCauThu);
            if (optional.isPresent()) {
                CauThu ct = optional.get();
                ct.setHoTen(hoTenMoi);
                ct.setSoAo(soAoMoi);
                cauThuRepository.save(ct);
                System.out.println("Đã cập nhật thông tin cầu thủ có mã " + maCauThu);
            } else {
                System.out.println("Không tìm thấy cầu thủ có mã " + maCauThu);
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi sửa cầu thủ: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất thao tác sửa cầu thủ.");
        }
    }

    public void xoaCauThu(String maCauThu) {
        try {
            Optional<CauThu> optional = cauThuRepository.findById(maCauThu);
            if (optional.isPresent()) {
                System.out.println("Đã xóa cầu thủ: " + optional.get().getHoTen());
                cauThuRepository.deleteById(maCauThu);
            } else {
                System.out.println("Không tìm thấy cầu thủ có mã " + maCauThu);
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa cầu thủ: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất thao tác xóa cầu thủ.");
        }
    }

    public void hienThiDanhSachCauThu() {
        try {
            List<CauThu> danhSach = cauThuRepository.findAll();
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
        List<CauThu> ketQua = cauThuRepository.findAll();

        return ketQua.stream().filter(ct ->
            stringMatch(ma, ct.getMa()) &&
            stringMatch(ten, ct.getHoTen()) &&
            stringMatch(viTri, ct.getViTri()) &&
            stringMatch(quocTich, ct.getQuocTich()) &&
            stringMatch(chieuCao, ct.getChieuCao()) &&
            stringMatch(canNang, ct.getCanNang()) &&
            (soAo == null || ct.getSoAo() == soAo) &&
            (soBanThang == null || ct.getSoBanThang() == soBanThang) &&
            (theVang == null || ct.getTheVang() == theVang) &&
            (theDo == null || ct.getTheDo() == theDo)
        ).toList();
    }

    // Hàm hỗ trợ: so sánh chứa gần đúng, không phân biệt hoa thường, bỏ khoảng trắng
    private boolean stringMatch(String keyword, String actual) {
        return keyword == null || keyword.isBlank()
                || (actual != null && actual.toLowerCase().contains(keyword.trim().toLowerCase()));
    }
    

    public List<CauThu> getDanhSach() {
        return cauThuRepository.findAll();
    }

    @PostConstruct
    public void khoiTaoDuLieuMau() {
        try {
            if (!cauThuRepository.existsById("CT001")) {
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
                cauThuRepository.save(cauThuMau);
                System.out.println("Đã thêm cầu thủ mẫu khi khởi động ứng dụng.");
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi tạo cầu thủ mẫu: " + e.getMessage());
        }
    }

    public List<CauThu> timKiem(String ma, String ten, String viTri, Integer tuoi, String quocTich, Integer soAo,
                                 Integer banThang, Integer theVang, Integer theDo) {
        throw new UnsupportedOperationException("Unimplemented method 'timKiem'");
    }

    public Object findById(String string) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
