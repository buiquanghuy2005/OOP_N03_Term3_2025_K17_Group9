package com.example.servingwebcontent.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "trandau")
public class TranDau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doi_a", nullable = false)
    private String doiA;

    @Column(name = "doi_b", nullable = false)
    private String doiB;

    @Column(name = "ngay_thi_dau", nullable = false)
    private LocalDate ngayThiDau;

    @Column(name = "dia_diem")
    private String diaDiem;

    @Column(name = "ti_so")
    private String tiSo;  // Ví dụ: "2-1"

    // Constructors
    public TranDau() {
    }

    public TranDau(String doiA, String doiB, LocalDate ngayThiDau, String diaDiem, String tiSo) {
        this.doiA = doiA;
        this.doiB = doiB;
        this.ngayThiDau = ngayThiDau;
        this.diaDiem = diaDiem;
        this.tiSo = tiSo;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoiA() {
        return doiA;
    }

    public void setDoiA(String doiA) {
        this.doiA = doiA;
    }

    public String getDoiB() {
        return doiB;
    }

    public void setDoiB(String doiB) {
        this.doiB = doiB;
    }

    public LocalDate getNgayThiDau() {
        return ngayThiDau;
    }

    public void setNgayThiDau(LocalDate ngayThiDau) {
        this.ngayThiDau = ngayThiDau;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getTiSo() {
        return tiSo;
    }

    public void setTiSo(String tiSo) {
        this.tiSo = tiSo;
    }
}
