package com.example.servingwebcontent.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "cauthu")
public class CauThu {

    @Id
    @Column(name = "ma", nullable = false)
    private String ma;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "vi_tri")
    private String viTri;

    @Column(name = "so_ao")
    private int soAo;

    @Column(name = "quoc_tich")
    private String quocTich;

    @Column(name = "chieu_cao")
    private String chieuCao;

    @Column(name = "can_nang")
    private String canNang;

    @Column(name = "so_ban_thang")
    private int soBanThang;

    @Column(name = "the_vang")
    private int theVang;

    @Column(name = "the_do")
    private int theDo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ngay_het_han_hop_dong")
    private LocalDate ngayHetHanHopDong;

    @Transient
    private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public CauThu() {}

    public CauThu(String ma, String hoTen, String viTri, int soAo, String quocTich, String chieuCao,
                  String canNang, int soBanThang, int theVang, int theDo,
                  LocalDate ngaySinh, LocalDate ngayHetHanHopDong) {
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
    }

    // Getters & Setters
    public String getMa() { return ma; }
    public void setMa(String ma) { this.ma = ma; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getViTri() { return viTri; }
    public void setViTri(String viTri) { this.viTri = viTri; }

    public int getSoAo() { return soAo; }
    public void setSoAo(int soAo) { this.soAo = soAo; }

    public String getQuocTich() { return quocTich; }
    public void setQuocTich(String quocTich) { this.quocTich = quocTich; }

    public String getChieuCao() { return chieuCao; }
    public void setChieuCao(String chieuCao) { this.chieuCao = chieuCao; }

    public String getCanNang() { return canNang; }
    public void setCanNang(String canNang) { this.canNang = canNang; }

    public int getSoBanThang() { return soBanThang; }
    public void setSoBanThang(int soBanThang) { this.soBanThang = soBanThang; }

    public int getTheVang() { return theVang; }
    public void setTheVang(int theVang) { this.theVang = theVang; }

    public int getTheDo() { return theDo; }
    public void setTheDo(int theDo) { this.theDo = theDo; }

    public LocalDate getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(LocalDate ngaySinh) { this.ngaySinh = ngaySinh; }

    public LocalDate getNgayHetHanHopDong() { return ngayHetHanHopDong; }
    public void setNgayHetHanHopDong(LocalDate ngayHetHanHopDong) { this.ngayHetHanHopDong = ngayHetHanHopDong; }

    // Tính tuổi từ ngày sinh
    public int getTuoi() {
        return ngaySinh != null ? Period.between(ngaySinh, LocalDate.now()).getYears() : 0;
    }

    // Tính số năm còn lại của hợp đồng
    public int getSoNamConLaiHopDong() {
        return ngayHetHanHopDong != null ? Period.between(LocalDate.now(), ngayHetHanHopDong).getYears() : 0;
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
        System.out.println("Ngày sinh: " + (ngaySinh != null ? ngaySinh.format(df) : "N/A"));
        System.out.println("Hết hạn hợp đồng: " + (ngayHetHanHopDong != null ? ngayHetHanHopDong.format(df) : "N/A"));
        System.out.println("Tuổi: " + getTuoi());
        System.out.println("Năm còn lại hợp đồng: " + getSoNamConLaiHopDong());
    }
}