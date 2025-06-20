package com.example.servingwebcontent.manager;


import com.example.servingwebcontent.model.User;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class UserService {
    private final List<User> danhSachNguoiDung = new ArrayList<>();
    private static final String FILE_NAME = "user.txt";

    public UserService() {
        loadFromFile(); // Đọc từ file khi khởi tạo
    }

    public void register(String username, String role, String password) {
        danhSachNguoiDung.add(new User(username, role.toLowerCase(), password));
        saveToFile();
        System.out.println("Đăng ký thành công!");
    }

    public User login(String username, String password) {
        for (User u : danhSachNguoiDung) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                System.out.println("Đăng nhập thành công!");
                return u;
            }
        }
        System.out.println("Sai thông tin đăng nhập.");
        return null;
    }

    public void hienThiMenuTheoVaiTro(User user) {
        if (user == null) return;
        String role = user.getRole();

        System.out.println("===== MENU (" + role.toUpperCase() + ") =====");
        System.out.println("1. Xem danh sách cầu thủ");
        
        if (role.equals("admin") || role.equals("coach")) {
            System.out.println("2. Thêm cầu thủ");
            System.out.println("3. Sửa thông tin cầu thủ");
            System.out.println("4. Xóa cầu thủ");
            System.out.println("5. Tìm kiếm cầu thủ");
        }

        System.out.println("0. Đăng xuất");
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User u : danhSachNguoiDung) {
                writer.write(u.getUsername() + "," + u.getRole() + "," + u.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    danhSachNguoiDung.add(new User(parts[0], parts[1].toLowerCase(), parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }
}
