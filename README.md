📌 Giới thiệu dự án: Hệ thống quản lý cầu thủ bằng Java
Dự án "Quản lý cầu thủ bóng đá" được xây dựng bằng ngôn ngữ lập trình Java theo mô hình hướng đối tượng. Hệ thống hỗ trợ người dùng lưu trữ, cập nhật và quản lý thông tin cầu thủ trong đội bóng, từ đó giúp việc quản lý trở nên hiệu quả và khoa học hơn. Giao diện sử dụng console, thích hợp cho sinh viên học lập trình Java cơ bản đến trung cấp.

🧩 Phân tích 3 đối tượng chính trong hệ thống
1. Lớp CauThu (Player)
Đại diện cho thông tin một cầu thủ.

Thuộc tính: mã cầu thủ, họ tên, tuổi, số áo, vị trí, quốc tịch.

Phương thức: khởi tạo, getter/setter, toString().

2. Lớp DanhSachCauThu
Quản lý danh sách các cầu thủ bằng ArrayList.

Chức năng: thêm cầu thủ, xóa, hiển thị, tìm kiếm.

3. Lớp Main
Giao diện console tương tác với người dùng.

Hiển thị menu, tiếp nhận input và gọi các chức năng từ DanhSachCauThu.

📁 Cấu trúc thư mục dự án
plaintext
Sao chép
Chỉnh sửa
PlayerManagement/
├── src/
│   ├── model/             # Lớp dữ liệu (CauThu)
│   │   └── CauThu.java
│   ├── controller/        # Quản lý nghiệp vụ (DanhSachCauThu)
│   │   └── DanhSachCauThu.java
│   ├── view/              # Giao diện người dùng (Main.java)
│   │   └── Main.java
├── test/                  # Kiểm thử lớp
│   ├── CauThuTest.java
│   └── DanhSachCauThuTest.java
└── README.md              # Mô tả dự án
🧱 Viết 3 class chính (Câu 4)
1. CauThu.java

package model;

public class CauThu {
    private String ma;
    private String hoTen;
    private int tuoi;
    private int soAo;
    private String viTri;
    private String quocTich;

    public CauThu(String ma, String hoTen, int tuoi, int soAo, String viTri, String quocTich) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.soAo = soAo;
        this.viTri = viTri;
        this.quocTich = quocTich;
    }

    public String getHoTen() { return hoTen; }
    public String getMa() { return ma; }
    public String toString() {
        return ma + " - " + hoTen + " - " + tuoi + " tuổi - Vị trí: " + viTri;
    }
}
2. DanhSachCauThu.java

package controller;

import model.CauThu;
import java.util.ArrayList;

public class DanhSachCauThu {
    private ArrayList<CauThu> danhSach = new ArrayList<>();

    public void them(CauThu ct) {
        danhSach.add(ct);
    }

    public void hienThi() {
        for (CauThu ct : danhSach) {
            System.out.println(ct);
        }
    }

    public CauThu timTheoMa(String ma) {
        for (CauThu ct : danhSach) {
            if (ct.getMa().equals(ma)) return ct;
        }
        return null;
    }
}
3. Main.java

package view;

import controller.DanhSachCauThu;
import model.CauThu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DanhSachCauThu ds = new DanhSachCauThu();
        Scanner sc = new Scanner(System.in);

        ds.them(new CauThu("CT01", "Nguyễn Văn A", 25, 10, "Tiền đạo", "Việt Nam"));
        ds.hienThi();
    }
}
✅ Kiểm định (Câu 5): 01–03 class test
1. CauThuTest.java

package test;

import model.CauThu;

public class CauThuTest {
    public static void main(String[] args) {
        CauThu ct = new CauThu("CT02", "Test Player", 24, 7, "Hậu vệ", "Pháp");
        assert ct.getHoTen().equals("Test Player");
        System.out.println("✅ Test CauThu passed.");
    }
}
2. DanhSachCauThuTest.java

package test;

import controller.DanhSachCauThu;
import model.CauThu;

public class DanhSachCauThuTest {
    public static void main(String[] args) {
        DanhSachCauThu ds = new DanhSachCauThu();
        ds.them(new CauThu("CT03", "Cầu thủ test", 22, 5, "Tiền vệ", "Italia"));
        assert ds.timTheoMa("CT03") != null;
        System.out.println("✅ Test DanhSachCauThu passed.");
    }
}
