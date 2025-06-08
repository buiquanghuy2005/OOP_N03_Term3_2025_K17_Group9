package model;

public class CauThu {
    private String ma;
    private String hoTen;
    private int tuoi;
    private String viTri;
    private int soAo;
    private String quocTich;
    private String chieuCao;
    private String canNang;

    public CauThu(String ma, String hoTen, int tuoi, String viTri, int soAo, String quocTich, String chieuCao, String canNang) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.viTri = viTri;
        this.soAo = soAo;
        this.quocTich = quocTich;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
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

    public String getViTri() {
        return viTri;
    }

    public int getSoAo() {
        return soAo;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public String getChieuCao() {
        return chieuCao;
    }

    public String getCanNang() {
        return canNang;
    }

    public void hienThiThongTin() {
        System.out.println("Mã: " + ma);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Vị trí: " + viTri);
        System.out.println("Số áo: " + soAo);
        System.out.println("Quốc tịch: " + quocTich);
        System.out.println("Chiều cao: " + chieuCao);
        System.out.println("Cân nặng: " + canNang);
    }
}
