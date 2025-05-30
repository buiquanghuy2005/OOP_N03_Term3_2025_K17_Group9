package Test;
import model.CauThu;
import model.DanhSachCauThu;
public class TestThemXoa {

    public static void themCauThu(DanhSachCauThu ds, CauThu ct) {
        ds.getDanhSach().add(ct);
        System.out.println("Đã thêm cầu thủ: " + ct.hoTen);
    }

    public static void xoaCauThu(DanhSachCauThu ds, int maCauThu) {
        for (int i = 0; i < ds.getDanhSach().size(); i++) {
            if (ds.getDanhSach().get(i).maCauThu == maCauThu) {
                System.out.println("Đã xóa cầu thủ: " + ds.getDanhSach().get(i).hoTen);
                ds.getDanhSach().remove(i);
                return;
            }
        }
        System.out.println("Không tìm thấy cầu thủ có mã " + maCauThu);
    }
}
