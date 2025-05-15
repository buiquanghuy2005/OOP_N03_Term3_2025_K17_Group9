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

    public void hienThiThongTin() {
        System.out.println("Mã cầu thủ: " + maCauThu);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Vị trí: " + viTri);
        System.out.println("Số áo: " + soAo);
        System.out.println("Quốc tịch: " + quocTich);
    }
}
