package com.example.servingwebcontent.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Time {

    // Tính tuổi từ ngày sinh
    public static int tinhTuoi(LocalDate ngaySinh) {
        LocalDate hienTai = LocalDate.now();
        return Period.between(ngaySinh, hienTai).getYears();
    }

    // Tính số năm còn lại của hợp đồng (nếu đã hết hạn thì trả về 0)
    public static long soNamConLaiHopDong(LocalDate ngayHetHan) {
        LocalDate hienTai = LocalDate.now();
        if (ngayHetHan.isBefore(hienTai)) {
            return 0;
        }
        return ChronoUnit.YEARS.between(hienTai, ngayHetHan);
    }

    // Trả về chi tiết thời gian còn lại của hợp đồng (năm, tháng, ngày)
    public static Period thoiGianConLai(LocalDate ngayHetHan) {
        LocalDate hienTai = LocalDate.now();
        return Period.between(hienTai, ngayHetHan);
    }
}
