package model;

public class HuanLuyenVien {
    private String ma;
    private String hoTen;
    private int tuoi;
    private String quocTich;

    public HuanLuyenVien(String ma, String hoTen, int tuoi, String quocTich) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.quocTich = quocTich;
    }

    public String getMa() {
        return ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public String getQuocTich() {
        return quocTich;
    }
}
