package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.TranDau;
import com.example.servingwebcontent.manager.TranDauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/trandau")
public class TranDauController {

    @Autowired
    private TranDauService tranDauService;

    @GetMapping
    public String danhSachTranDau(Model model) {
        model.addAttribute("dsTranDau", tranDauService.getAllTranDau());
        return "danhsachtd";
    }

    @PostMapping("/luu")
    public String luuTranDau(@ModelAttribute("trandau") TranDau tranDau) {
        tranDau.setDoiNha("FC Mặc Định"); // Đảm bảo luôn đúng tên đội nhà
        tranDauService.saveTranDau(tranDau);
        return "redirect:/trandau";
    }


    @GetMapping("/sua/{id}")
    public String suaTranDau(@PathVariable Long id, Model model) {
        Optional<TranDau> td = tranDauService.getTranDauById(id);
        if (td.isPresent()) {
            model.addAttribute("trandau", td.get());
            return "formtd";
        } else {
            return "redirect:/trandau";
        }
    }

    @GetMapping("/them")
    public String hienThiFormThem(Model model) {
        TranDau tranDau = new TranDau();
        tranDau.setDoiNha("FC Mặc Định"); // Đặt tên mặc định
        model.addAttribute("trandau", tranDau);
        return "formtd";
    }


    @GetMapping("/xoa/{id}")
    public String xoaTranDau(@PathVariable Long id) {
        tranDauService.deleteTranDauById(id);
        return "redirect:/trandau";
    }
}
