package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.HuanLuyenVien;
import com.example.servingwebcontent.manager.HuanLuyenVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hlv")
public class HuanLuyenVienController {

    @Autowired
    private HuanLuyenVienService service;

    // Hiển thị danh sách HLV
    @GetMapping
    public String danhSach(Model model) {
        model.addAttribute("dsHlv", service.findAll());
        return "danhsachhlv"; // ✅ Tên file HTML là danhsachhlv.html
    }

    // Hiển thị form thêm HLV
    @GetMapping("/them")
    public String themForm(Model model) {
        model.addAttribute("hlv", new HuanLuyenVien());
        return "formhlv"; // ✅ Tên file HTML là formhlv.html
    }

    // Lưu HLV mới hoặc đã chỉnh sửa
    @PostMapping("/luu")
    public String luu(@ModelAttribute HuanLuyenVien hlv) {
        service.save(hlv);
        return "redirect:/hlv";
    }

    // Hiển thị form chỉnh sửa HLV
    @GetMapping("/sua/{id}")
    public String sua(@PathVariable int id, Model model) {
        HuanLuyenVien hlv = service.findById(id).orElse(null);
        model.addAttribute("hlv", hlv);
        return "formhlv"; // ✅ Dùng lại formhlv.html
    }

    // Xóa HLV theo ID
    @GetMapping("/xoa/{id}")
    public String xoa(@PathVariable int id) {
        service.deleteById(id);
        return "redirect:/hlv";
    }
}
