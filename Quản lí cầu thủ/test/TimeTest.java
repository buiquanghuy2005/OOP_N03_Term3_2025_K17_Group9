package test;
import model.Time;
import java.time.LocalDate;
import java.time.Period;
public class TimeTest {
    public static void run() {
        // Dữ liệu mẫu
        LocalDate ngaySinh = LocalDate.of(2000, 7, 15);
        LocalDate ngayHetHan = LocalDate.of(2027, 12, 31);
        // Gọi hàm từ Time.java
        int tuoi = Time.tinhTuoi(ngaySinh);
        long namConLai = Time.soNamConLaiHopDong(ngayHetHan);
        Period chiTiet = Time.thoiGianConLai(ngayHetHan);
        // Hiển thị kết quả
        System.out.println("Tuổi cầu thủ: " + tuoi);
        System.out.println("Số năm còn lại hợp đồng: " + namConLai);
        System.out.println("Chi tiết còn lại: " +
            chiTiet.getYears() + " năm, " +
            chiTiet.getMonths() + " tháng, " +
            chiTiet.getDays() + " ngày");
    }
}