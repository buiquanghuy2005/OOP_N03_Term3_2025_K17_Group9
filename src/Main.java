public class Main {
    public static void main(String[] args) {
        CauThu ct1 = new CauThu("CT01", "Nguyễn Văn A", 24, "Tiền đạo", 9, "Việt Nam");
        CauThu ct2 = new CauThu("CT02", "Lê Văn B", 27, "Hậu vệ", 5, "Việt Nam");

        System.out.println("Thông tin cầu thủ 1:");
        ct1.hienThiThongTin();

        System.out.println("\nThông tin cầu thủ 2:");
        ct2.hienThiThongTin();
    }
}
