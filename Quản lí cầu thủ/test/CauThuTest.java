package test;
import model.CauThu;
import java.time.LocalDate;
public class CauThuTest {
    public static void run() {
        // Tạo đối tượng cầu thủ với thông tin mẫu
        CauThu cauThu = new CauThu(
            "CT01",               // Mã cầu thủ
            "Nguyễn Văn A",       // Họ tên
            "Tiền vệ",            // Vị trí
            10,                   // Số áo
            "Việt Nam",           // Quốc tịch
            "1m75",               // Chiều cao
            "68kg",               // Cân nặng
            15,                   // Số bàn thắng
            3,                    // Thẻ vàng
            1,                    // Thẻ đỏ
            LocalDate.of(2000, 5, 15),       // Ngày sinh
            LocalDate.of(2026, 12, 31)       // Ngày hết hạn hợp đồng
        );
        // Hiển thị thông tin cầu thủ
        cauThu.hienThiThongTin();
    }
}
