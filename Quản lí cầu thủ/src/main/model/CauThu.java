package model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class CauThu {
    private String ma;
    private String hoTen;
    private String viTri;
    private int soAo;
    private String quocTich;
    private String chieuCao;
    private String canNang;
    private int soBanThang;
    private int theVang;
    private int theDo;
    private LocalDate ngaySinh;
    private LocalDate ngayHetHanHopDong;
    private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public CauThu(String ma, String hoTen, String viTri, int soAo, String quocTich, String chieuCao, String canNang,int soBanThang, int theVang, int theDo,LocalDate ngaySinh, LocalDate ngayHetHanHopDong) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.viTri = viTri;
        this.soAo = soAo;
        this.quocTich = quocTich;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
        this.soBanThang = soBanThang;
        this.theVang = theVang;
        this.theDo = theDo;
        this.ngaySinh = ngaySinh;
        this.ngayHetHanHopDong = ngayHetHanHopDong;
        Time.tinhTuoi(ngaySinh);
    }
    public void setHoTen(String hoTen) {
    this.hoTen = hoTen;
    }
    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
    public void setSoAo(int soAo) {
        this.soAo = soAo;
    }
    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }
    public void setChieuCao(String chieuCao) {
        this.chieuCao = chieuCao;
    }    
    public void setCanNang(String canNang) {
        this.canNang = canNang;
    }
    public void setSoBanThang(int soBanThang) {
        this.soBanThang = soBanThang;
    }
    public void setTheVang(int theVang) {
        this.theVang = theVang;
    }
    public void setTheDo(int theDo) {
        this.theDo = theDo;
    }
    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public void setNgayHetHanHopDong(LocalDate ngayHetHanHopDong) {
        this.ngayHetHanHopDong = ngayHetHanHopDong;
    }
    public String getMa() {
        return ma;
    }
    public String getHoTen() {
        return hoTen;
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
    public int getSoBanThang() { 
        return soBanThang;
    }
    public int getTheVang() { 
        return theVang; 
    }
    public int getTheDo() {
        return theDo; 
    }
    public LocalDate getNgaySinh() { 
        return ngaySinh; 
    }
    public int getTuoi() {
        return Time.tinhTuoi(ngaySinh);
}

    public LocalDate getNgayHetHanHopDong() { 
        return ngayHetHanHopDong; 
    }
    public void hienThiThongTin() {
        System.out.println("Mã: " + ma);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Vị trí: " + viTri);
        System.out.println("Số áo: " + soAo);
        System.out.println("Quốc tịch: " + quocTich);
        System.out.println("Chiều cao: " + chieuCao);
        System.out.println("Cân nặng: " + canNang);
        System.out.println("Số bàn thắng: " + soBanThang);
        System.out.println("Thẻ vàng: " + theVang);
        System.out.println("Thẻ đỏ: " + theDo);
        System.out.println("Hợp đồng hết hạn: " + ngayHetHanHopDong.format(df));
        System.out.println("Số năm còn lại trong hợp đồng: " + Time.soNamConLaiHopDong(ngayHetHanHopDong));
    }
}