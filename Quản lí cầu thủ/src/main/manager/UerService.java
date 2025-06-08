package main;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final List<User> danhSachNguoiDung = new ArrayList<>();

    public void register(String username, String role, String password) {
        danhSachNguoiDung.add(new User(username, role, password));
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
}
