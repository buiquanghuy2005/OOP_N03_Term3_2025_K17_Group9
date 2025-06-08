package model;

import java.util.ArrayList;
import java.util.List;

import controller.CauThuService;

public class DanhSachCauThu {

    private ArrayList<CauThu> danhSach = new ArrayList<>();

    public void themCauThu(CauThu ct) {
        danhSach.add(ct);
        System.out.println("Đã thêm cầu thủ: " + ct.getHoTen());
    }

    public void suaCauThu(String hoTenMoi, int soAoMoi, String maCauThu) {
        for (CauThu ct : danhSach) {
            if (ct.getMa().equals(maCauThu)) {
                // giả sử bạn có thêm setter trong CauThu thì nên gọi setter
                ct = new CauThu(maCauThu, hoTenMoi, ct.getTuoi(), ct.getViTri(), soAoMoi,
                                ct.getQuocTich(), ct.getChieuCao(), ct.getCanNang());
                System.out.println("Đã cập nhật thông tin cầu thủ có mã " + maCauThu);
                return;
            }
        }
        System.out.println("Không tìm thấy cầu thủ có mã " + maCauThu);
    }

    public void xoaCauThu(String maCauThu) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMa().equals(maCauThu)) {
                System.out.println("Đã xóa cầu thủ: " + danhSach.get(i).getHoTen());
                danhSach.remove(i);
                return;
            }
        }
        System.out.println("Không tìm thấy cầu thủ có mã " + maCauThu);
    }

    public void inDanhSachCauThu() {
        System.out.println("Danh sách cầu thủ:");
        for (CauThu ct : danhSach) {
            System.out.println("Mã: " + ct.getMa() + " | Họ tên: " + ct.getHoTen() + " | Số áo: " + ct.getSoAo());
        }
    }
    public void hienThiDanhSachCauThu() {
        if (danhSachCauThu.isEmpty()) {
            System.out.println("Đội bóng chưa có cầu thủ nào.");
        } else {
            System.out.println("Danh sách cầu thủ của đội " + tenDoi + ":");
            for (CauThu ct : danhSachCauThu) {
                ct.hienThiThongTin();  // Gọi hàm hiển thị trong lớp CauThu
                System.out.println("------");
              }
        }
    }

    public List<CauThu> timKiem(String ten, String viTri, Integer minTuoi, Integer maxTuoi) {
        return CauThuService.timKiem(danhSach, ten, viTri, minTuoi, maxTuoi);
    }
}
