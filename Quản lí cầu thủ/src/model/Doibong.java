package model;

public class Doibong {
    private String tenDoi;
    private String huanLuyenVien;

    public Doibong(String tenDoi, String hlv) {
        this.tenDoi = tenDoi;
        this.huanLuyenVien = hlv;
    }

    public void hienThiThongTin() {
        System.out.println("Tên đội: " + tenDoi);
        System.out.println("Huấn luyện viên: " + huanLuyenVien);
    }
}
