package model;

public class CauThu {
    private String ma;         
    String hoTen;     
    private int tuoi;        
    private String viTri;  
    int soAo;        
    private String quocTich;  

    public CauThu(String ma, String hoTen, int tuoi, String viTri, int soAo, String quocTich) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.viTri = viTri;
        this.soAo = soAo;
        this.quocTich = quocTich;
    }


    public String getMa() {
        return ma;
    }

    public String getTen() {
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


    public void hienThiThongTin() {
        System.out.println("Mã: " + ma);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Vị trí: " + viTri);
        System.out.println("Số áo: " + soAo);
        System.out.println("Quốc tịch: " + quocTich);
    }
}
