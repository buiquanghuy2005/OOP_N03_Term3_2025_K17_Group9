package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.manager.HuanLuyenVienService;
import com.example.servingwebcontent.model.HuanLuyenVien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hlv")
public class HuanLuyenVienController {

    @Autowired
    private HuanLuyenVienService service;

    @GetMapping
    public String danhSach(Model model) {
        model.addAttribute("dsHlv", service.findAll());
        return "danhsachhlv";
    }

    @GetMapping("/them")
    public String themForm(Model model) {
        model.addAttribute("hlv", new HuanLuyenVien());
        return "formhlv";
    }

    @GetMapping("/sua/{id}")
    public String sua(@PathVariable int id, Model model) {
        HuanLuyenVien hlv = service.findById(id).orElse(null);
        if (hlv == null) {
            return "redirect:/hlv";
        }
        model.addAttribute("hlv", hlv);
        return "formhlv";
    }

    @PostMapping("/luu")
    public String luu(@ModelAttribute HuanLuyenVien hlv, Model model) {
        try {
            service.save(hlv);
        } catch (IllegalArgumentException e) {
            model.addAttribute("hlv", hlv);
            model.addAttribute("error", e.getMessage());
            return "formhlv"; 
        }
        return "redirect:/hlv";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(@PathVariable int id) {
        service.deleteById(id);
        return "redirect:/hlv";
    }
}
