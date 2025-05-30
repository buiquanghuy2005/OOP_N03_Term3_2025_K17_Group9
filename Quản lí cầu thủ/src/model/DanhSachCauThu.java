package model;
import java.util.ArrayList;

public class DanhSachCauThu {

    ArrayList<CauThu> danhSach = new ArrayList<>();

    public void themCauThu(CauThu ct) {
        danhSach.add(ct);
        System.out.println(" Đã thêm cầu thủ: " + ct.hoTen);
    }


    public void xoaCauThu(int maCauThu) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).maCauThu == maCauThu) {
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
            System.out.println(" Mã: " + ct.maCauThu + " | Họ tên: " + ct.hoTen + " | Số áo: " + ct.soAo);
        }
    }
    public ArrayList<CauThu> getDanhSach() {
    return danhSach;
}

}
