package model;

public class DoiBong {
    private String tenDoi;
    private String huanLuyenVien;

    public DoiBong() {
    }

    public DoiBong(String tenDoi, String hlv) {
        this.tenDoi = tenDoi;
        this.huanLuyenVien = hlv;
    }

    public String getTenDoi() {
        return tenDoi;
    }

    public void setTenDoi(String tenDoi) {
        this.tenDoi = tenDoi;
    }

    public String getHuanLuyenVien() {
        return huanLuyenVien;
    }

    public void setHuanLuyenVien(String huanLuyenVien) {
        this.huanLuyenVien = huanLuyenVien;
    }

    public void hienThiThongTin() {
        System.out.println("Tên đội: " + tenDoi);
        System.out.println("Huấn luyện viên: " + huanLuyenVien);
    }
}
