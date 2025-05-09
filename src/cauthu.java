package model;

public class CauThu {
    private String maCauThu;
    private String hoTen;
    private int tuoi;
    private String viTri;
    private int soAo;
    private String quocTich;

    public CauThu(String ma, String ten, int tuoi, String viTri, int soAo, String qt) {
        this.maCauThu = ma;
        this.hoTen = ten;
        this.tuoi = tuoi;
        this.viTri = viTri;
        this.soAo = soAo;
        this.quocTich = qt;
    }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public String toString() {
        return maCauThu + " - " + hoTen + " - " + tuoi + " tuổi - " + viTri;
    }
}