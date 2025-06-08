package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

public class Time {

    public static int tinhTuoi(LocalDate ngaySinh) {
        LocalDate hienTai = LocalDate.now();
        return Period.between(ngaySinh, hienTai).getYears();
    }

    public static boolean laNamNhuan(int nam) {
        return Year.isLeap(nam);
    }


    public static int tinhSoNgay(LocalDate start, LocalDate end) {
        return Period.between(start, end).getDays();
    }
}
