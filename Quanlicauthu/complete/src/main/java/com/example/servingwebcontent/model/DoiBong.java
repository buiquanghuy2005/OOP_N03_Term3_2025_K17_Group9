package com.example.servingwebcontent.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doibong")  // 👈 Quan trọng: map chính xác tên bảng trong MySQL
public class DoiBong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenDoi;
    private String sanNha;
    private String hlvTruong;
    private int namThanhLap;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenDoi() {
        return tenDoi;
    }

    public void setTenDoi(String tenDoi) {
        this.tenDoi = tenDoi;
    }

    public String getSanNha() {
        return sanNha;
    }

    public void setSanNha(String sanNha) {
        this.sanNha = sanNha;
    }

    public String getHlvTruong() {
        return hlvTruong;
    }

    public void setHlvTruong(String hlvTruong) {
        this.hlvTruong = hlvTruong;
    }

    public int getNamThanhLap() {
        return namThanhLap;
    }

    public void setNamThanhLap(int namThanhLap) {
        this.namThanhLap = namThanhLap;
    }
}
