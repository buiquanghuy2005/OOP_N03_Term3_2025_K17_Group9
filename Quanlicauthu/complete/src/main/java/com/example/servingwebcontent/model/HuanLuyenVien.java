package com.example.servingwebcontent.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hlv")
public class HuanLuyenVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten", nullable = false)
    private String ten;

    @Column(name = "tuoi")
    private int tuoi;

    @Column(name = "chuc_vu", nullable = false)
    private String chucVu;

    // Constructors
    public HuanLuyenVien() {
    }

    public HuanLuyenVien(String ten, int tuoi, String chucVu) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.chucVu = chucVu;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
}
