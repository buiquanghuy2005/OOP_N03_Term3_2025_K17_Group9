package model;
import java.util.ArrayList;
public class DoiBong {
    private String maDoi;
    private String tenDoi;
    private String sanNha;
    private HuanLuyenVien huanLuyenVien;
    private ArrayList<CauThu> danhSachCauThu;
    public DoiBong(String maDoi, String tenDoi, String sanNha, HuanLuyenVien hlv) {
        this.maDoi = maDoi;
        this.tenDoi = tenDoi;
        this.sanNha = sanNha;
        this.huanLuyenVien = hlv;
        this.danhSachCauThu = new ArrayList<>();
    }
    public String getMaDoi() {
        return maDoi;
    }
    public String getTenDoi() {
        return tenDoi;
    }
    public String getSanNha() {
        return sanNha;
    }
    public HuanLuyenVien getHuanLuyenVien() {
        return huanLuyenVien;
    }
    public ArrayList<CauThu> getDanhSachCauThu() {
        return danhSachCauThu;
    }
    public void themCauThu(CauThu ct) {
        danhSachCauThu.add(ct);
        System.out.println("Đã thêm cầu thủ " + ct.getHoTen() + " vào đội " + tenDoi);
    }
    public void hienThiThongTinDoiBong() {
        System.out.println("Mã đội: " + maDoi);
        System.out.println("Tên đội: " + tenDoi);
        System.out.println("Sân nhà: " + sanNha);
        System.out.println("Huấn luyện viên: " + huanLuyenVien.getHoTen());
        System.out.println("Danh sách cầu thủ:");
        for (CauThu ct : danhSachCauThu) {
            System.out.println("- " + ct.getHoTen() + " | Số áo: " + ct.getSoAo() + " | Vị trí: " + ct.getViTri());
        }
    }
}