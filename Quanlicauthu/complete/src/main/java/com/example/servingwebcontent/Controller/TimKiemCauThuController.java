package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.CauThu;
import com.example.servingwebcontent.manager.DanhSachCauThu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TimKiemCauThuController {

    DanhSachCauThu danhSach = new DanhSachCauThu(); // hoặc inject nếu dùng @Service

    @GetMapping("/timkiem")
    public String timKiemTheoChieuCao(@RequestParam double chieuCao, Model model) {
        try {
            List<CauThu> ketQua = danhSach.timKiemTheoChieuCao(chieuCao);
            model.addAttribute("ketQua", ketQua);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("thongBao", "Đã xảy ra lỗi khi tìm kiếm.");
        } finally {
            System.out.println("Đã thực hiện xong tìm kiếm chiều cao.");
        }
        return "ketqua"; // file HTML trong /resources/templates/ketqua.html
    }
}
