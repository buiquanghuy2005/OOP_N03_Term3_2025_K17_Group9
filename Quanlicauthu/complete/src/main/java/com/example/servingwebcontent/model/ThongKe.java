package com.example.servingwebcontent.model;

public class ThongKe {
    private int tongSoCauThu;
    private double tuoiTrungBinh;
    private int tongSoBanThang;
    private int tongTheVang;
    private int tongTheDo;
    private double tiLeThang; 
    private CauThu cauThuGhiBanNhieuNhat;
    private CauThu cauThuLonTuoiNhat;
    private CauThu cauThuCaoNhat;

    public ThongKe() {
    }

    public ThongKe(int tongSoCauThu, double tuoiTrungBinh, int tongSoBanThang, int tongTheVang, int tongTheDo,
                   double tiLeThang, CauThu cauThuGhiBanNhieuNhat, CauThu cauThuLonTuoiNhat, CauThu cauThuCaoNhat) {
        this.tongSoCauThu = tongSoCauThu;
        this.tuoiTrungBinh = tuoiTrungBinh;
        this.tongSoBanThang = tongSoBanThang;
        this.tongTheVang = tongTheVang;
        this.tongTheDo = tongTheDo;
        this.tiLeThang = tiLeThang;
        this.cauThuGhiBanNhieuNhat = cauThuGhiBanNhieuNhat;
        this.cauThuLonTuoiNhat = cauThuLonTuoiNhat;
        this.cauThuCaoNhat = cauThuCaoNhat;
    }

    public int getTongSoCauThu() {
        return tongSoCauThu;
    }

    public void setTongSoCauThu(int tongSoCauThu) {
        this.tongSoCauThu = tongSoCauThu;
    }

    public double getTuoiTrungBinh() {
        return tuoiTrungBinh;
    }

    public void setTuoiTrungBinh(double tuoiTrungBinh) {
        this.tuoiTrungBinh = tuoiTrungBinh;
    }

    public int getTongSoBanThang() {
        return tongSoBanThang;
    }

    public void setTongSoBanThang(int tongSoBanThang) {
        this.tongSoBanThang = tongSoBanThang;
    }

    public int getTongTheVang() {
        return tongTheVang;
    }

    public void setTongTheVang(int tongTheVang) {
        this.tongTheVang = tongTheVang;
    }

    public int getTongTheDo() {
        return tongTheDo;
    }

    public void setTongTheDo(int tongTheDo) {
        this.tongTheDo = tongTheDo;
    }

    public double getTiLeThang() {
        return tiLeThang;
    }

    public void setTiLeThang(double tiLeThang) {
        this.tiLeThang = tiLeThang;
    }

    public CauThu getCauThuGhiBanNhieuNhat() {
        return cauThuGhiBanNhieuNhat;
    }

    public void setCauThuGhiBanNhieuNhat(CauThu cauThuGhiBanNhieuNhat) {
        this.cauThuGhiBanNhieuNhat = cauThuGhiBanNhieuNhat;
    }

    public CauThu getCauThuLonTuoiNhat() {
        return cauThuLonTuoiNhat;
    }

    public void setCauThuLonTuoiNhat(CauThu cauThuLonTuoiNhat) {
        this.cauThuLonTuoiNhat = cauThuLonTuoiNhat;
    }

    public CauThu getCauThuCaoNhat() {
        return cauThuCaoNhat;
    }

    public void setCauThuCaoNhat(CauThu cauThuCaoNhat) {
        this.cauThuCaoNhat = cauThuCaoNhat;
    }
}
