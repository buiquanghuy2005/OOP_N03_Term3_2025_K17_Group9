package model;

public class CauThu {
    public int maCauThu; 
    public String hoTen;
    public int tuoi;
    public String viTri;
    public int soAo;
    public String quocTich;

    public CauThu(int ma, String ten, int tuoi, String viTri, int soAo, String qt) {
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
