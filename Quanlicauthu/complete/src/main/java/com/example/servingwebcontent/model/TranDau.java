package com.example.servingwebcontent.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "trandau")
public class TranDau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doi_nha", nullable = false)
    private String doiNha;

    @Column(name = "doi_khach", nullable = false)
    private String doiKhach;

    @Column(name = "ban_thang_nha")
    private int banThangNha;

    @Column(name = "ban_thang_khach")
    private int banThangKhach;

    @Column(name = "ngay_thi_dau") 
    private LocalDate ngayThiDau;


    @Column(name = "san_van_dong")
    private String sanVanDong;

    @Column(name = "vong_dau")
    private String vongDau;

    @Column(name = "giai_dau")
    private String giaiDau;

    @Column(name = "ghi_chu")
    private String ghiChu;

    public TranDau() {
    }

    public TranDau(String doiNha, String doiKhach, int banThangNha, int banThangKhach,
                   LocalDate ngayThiDau, String sanVanDong, String vongDau,
                   String giaiDau, String ghiChu) {
        this.doiNha = doiNha;
        this.doiKhach = doiKhach;
        this.banThangNha = banThangNha;
        this.banThangKhach = banThangKhach;
        this.ngayThiDau = ngayThiDau;
        this.sanVanDong = sanVanDong;
        this.vongDau = vongDau;
        this.giaiDau = giaiDau;
        this.ghiChu = ghiChu;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoiNha() {
        return doiNha;
    }

    public void setDoiNha(String doiNha) {
        this.doiNha = doiNha;
    }

    public String getDoiKhach() {
        return doiKhach;
    }

    public void setDoiKhach(String doiKhach) {
        this.doiKhach = doiKhach;
    }

    public int getBanThangNha() {
        return banThangNha;
    }

    public void setBanThangNha(int banThangNha) {
        this.banThangNha = banThangNha;
    }

    public int getBanThangKhach() {
        return banThangKhach;
    }

    public void setBanThangKhach(int banThangKhach) {
        this.banThangKhach = banThangKhach;
    }

    public LocalDate getNgayThiDau() {
        return ngayThiDau;
    }


    public void setNgayThiDau(LocalDate ngayThiDau) {
        this.ngayThiDau = ngayThiDau;
    }

    public String getSanVanDong() {
        return sanVanDong;
    }

    public void setSanVanDong(String sanVanDong) {
        this.sanVanDong = sanVanDong;
    }

    public String getVongDau() {
        return vongDau;
    }

    public void setVongDau(String vongDau) {
        this.vongDau = vongDau;
    }

    public String getGiaiDau() {
        return giaiDau;
    }

    public void setGiaiDau(String giaiDau) {
        this.giaiDau = giaiDau;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
