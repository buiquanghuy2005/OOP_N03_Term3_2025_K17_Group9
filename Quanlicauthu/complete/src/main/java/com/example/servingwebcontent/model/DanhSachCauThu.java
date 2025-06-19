package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import manager.CauThuService;
public class DanhSachCauThu {
    private ArrayList<CauThu> danhSach = new ArrayList<>();

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
}
    public void timKiemBangNhapTay() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nhập tiêu chí cần tìm (Enter để bỏ qua):");

            System.out.print("Mã cầu thủ: ");
            String ma = sc.nextLine();
            ma = ma.isEmpty() ? null : ma;

            System.out.print("Tên cầu thủ: ");
            String ten = sc.nextLine();
            ten = ten.isEmpty() ? null : ten;

            System.out.print("Vị trí: ");
            String viTri = sc.nextLine();
            viTri = viTri.isEmpty() ? null : viTri;

            System.out.print("Số áo: ");
            String soAoStr = sc.nextLine();
            Integer soAo = null;
            if (!soAoStr.isEmpty()) {
                try {
                    soAo = Integer.parseInt(soAoStr);
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi: Số áo không hợp lệ.");
                }
            }

            System.out.print("Quốc tịch: ");
            String quocTich = sc.nextLine();
            quocTich = quocTich.isEmpty() ? null : quocTich;

            System.out.print("Chiều cao: ");
            String chieuCao = sc.nextLine();
            chieuCao = chieuCao.isEmpty() ? null : chieuCao;

            System.out.print("Cân nặng: ");
            String canNang = sc.nextLine();
            canNang = canNang.isEmpty() ? null : canNang;

            System.out.print("Số bàn thắng: ");
            String sbtStr = sc.nextLine();
            Integer soBanThang = null;
            if (!sbtStr.isEmpty()) {
                try {
                    soBanThang = Integer.parseInt(sbtStr);
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi: Số bàn thắng không hợp lệ.");
                }
            }

            System.out.print("Thẻ vàng: ");
            String tvStr = sc.nextLine();
            Integer theVang = null;
            if (!tvStr.isEmpty()) {
                try {
                    theVang = Integer.parseInt(tvStr);
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi: Số thẻ vàng không hợp lệ.");
                }
            }

            System.out.print("Thẻ đỏ: ");
            String tdStr = sc.nextLine();
            Integer theDo = null;
            if (!tdStr.isEmpty()) {
                try {
                    theDo = Integer.parseInt(tdStr);
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi: Số thẻ đỏ không hợp lệ.");
                }
            }

        List<CauThu> ketQua = CauThuService.timKiem(
            danhSach,
            ma, ten, viTri, soAo, quocTich, chieuCao, canNang,
            soBanThang, theVang, theDo
        );

        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy cầu thủ nào.");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (CauThu ct : ketQua) {
                ct.hienThiThongTin();
                System.out.println("-----------");
            }
        }

    } catch (Exception e) {
        System.out.println("Đã xảy ra lỗi khi tìm kiếm cầu thủ: " + e.getMessage());
    } finally {
        sc.close();
    }
}

    public List<CauThu> getDanhSach() {
        return danhSach;
    }
}