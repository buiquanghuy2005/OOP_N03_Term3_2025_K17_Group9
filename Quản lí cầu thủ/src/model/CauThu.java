package model;

public class CauThu {
    private String maCauThu;
    private String hoTen;
    private int tuoi;
    private String viTri;
    private int soAo;
    private String quocTich;

    public CauThu() {
    }

    public CauThu(String ma, String ten, int tuoi, String viTri, int soAo, String qt) {
        this.maCauThu = ma;
        this.hoTen = ten;
        this.tuoi = tuoi;
        this.viTri = viTri;
        this.soAo = soAo;
        this.quocTich = qt;
    }

    // Getter & Setter
    public String getMaCauThu() {
        return maCauThu;
    }

    public void setMaCauThu(String maCauThu) {
        this.maCauThu = maCauThu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public int getSoAo() {
        return soAo;
    }

    public void setSoAo(int soAo) {
        this.soAo = soAo;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public void hienThiThongTin() {
        System.out.println("Mã cầu thủ: " + maCauThu);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Vị trí: " + viTri);
        System.out.println("Số áo: " + soAo);
        System.out.println("Quốc tịch: " + quocTich);
    }
}
