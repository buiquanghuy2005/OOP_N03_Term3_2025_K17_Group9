package test;

import manager.UserManager;

public class TestUser {
    public static void main(String[] args) {
        UserManager user = new UserManager("hongnguyen", "Admin", "123456");

        // Test getter
        System.out.println("Username: " + user.getUsername());
        System.out.println("Role: " + user.getRole());
        System.out.println("Password: " + user.getPassword());

        // Test setter
        user.setUsername("nguyenvan");
        user.setRole("Coach");
        user.setPassword("abcdef");

        System.out.println("Sau khi cập nhật:");
        System.out.println("Username: " + user.getUsername());
        System.out.println("Role: " + user.getRole());
        System.out.println("Password: " + user.getPassword());
    }
}
