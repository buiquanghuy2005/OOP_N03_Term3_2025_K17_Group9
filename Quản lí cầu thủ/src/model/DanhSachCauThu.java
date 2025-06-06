package model;

import java.util.ArrayList;
import java.util.List;

import model.CauThuService;


@SuppressWarnings("unused")
public class DanhSachCauThu {

    ArrayList<CauThu> danhSach = new ArrayList<>();

    public void themCauThu(CauThu ct) {
        danhSach.add(ct);
        System.out.println(" Đã thêm cầu thủ: " + ct.hoTen);
    }

    public void suaCauThu(String hoTenMoi, int soAoMoi, int maCauThu) {
        for (CauThu ct : danhSach) {
            if (ct.soAo == maCauThu) {
                ct.hoTen = hoTenMoi;
                ct.soAo = soAoMoi;
                System.out.println(" Đã cập nhật thông tin cầu thủ có mã " + maCauThu);
                return;
            }
        }
        System.out.println("Không tìm thấy cầu thủ có mã " + maCauThu);
    }

    public void xoaCauThu(int maCauThu) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).soAo == maCauThu) {
                System.out.println(" Đã xóa cầu thủ: " + danhSach.get(i).hoTen);
                danhSach.remove(i);
                return;
            }
        }
        System.out.println(" Không tìm thấy cầu thủ có mã " + maCauThu);
    }

    public void inDanhSachCauThu() {
        System.out.println("Danh sách cầu thủ:");
        for (CauThu ct : danhSach) {
            System.out.println(" Mã: " + ct.soAo + " | Họ tên: " + ct.hoTen + " | Số áo: " + ct.soAo);
        }
    }
    public List<CauThu> timKiem(String ten, String viTri, Integer minTuoi, Integer maxTuoi) {
        return CauThuService.timKiem(danhSach, ten, viTri, minTuoi, maxTuoi);  // GỌI LẠI phương thức tìm kiếm cầu thủ theo yêu cầu .
    }

}
