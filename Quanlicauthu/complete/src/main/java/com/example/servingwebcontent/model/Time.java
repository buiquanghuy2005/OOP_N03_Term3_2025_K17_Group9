package com.example.servingwebcontent.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Time {
    public static int tinhTuoi(LocalDate ngaySinh) {
        if (ngaySinh == null) return 0; 
        LocalDate hienTai = LocalDate.now();
        return Period.between(ngaySinh, hienTai).getYears();
    }

    public static long soNamConLaiHopDong(LocalDate ngayHetHan) {
        if (ngayHetHan == null) return 0;
        LocalDate hienTai = LocalDate.now();
        if (ngayHetHan.isBefore(hienTai)) {
            return 0;
        }
        return ChronoUnit.YEARS.between(hienTai, ngayHetHan);
    }

    public static Period thoiGianConLai(LocalDate ngayHetHan) {
        if (ngayHetHan == null) return Period.ZERO;
        LocalDate hienTai = LocalDate.now();
        return Period.between(hienTai, ngayHetHan);
    }
}
