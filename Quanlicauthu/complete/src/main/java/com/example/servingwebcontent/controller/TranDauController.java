package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.TranDau;
import com.example.servingwebcontent.repository.TranDauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/trandau")
public class TranDauController {

    @Autowired
    private TranDauRepository tranDauRepository;

    @GetMapping
    public String danhSachTranDau(Model model) {
        model.addAttribute("dsTranDau", tranDauRepository.findAll());
        return "danhsachtd";
    }

    @GetMapping("/them")
    public String hienFormThem(Model model) {
        model.addAttribute("trandau", new TranDau());
        return "formtd";
    }

    @PostMapping("/luu")
    public String luuTranDau(@ModelAttribute("trandau") TranDau tranDau) {
        tranDauRepository.save(tranDau);
        return "redirect:/trandau";
    }

    @GetMapping("/sua/{id}")
    public String suaTranDau(@PathVariable Long id, Model model) {
        Optional<TranDau> td = tranDauRepository.findById(id);
        if (td.isPresent()) {
            model.addAttribute("trandau", td.get());
            return "formtd";
        } else {
            return "redirect:/trandau";
        }
    }

    @GetMapping("/xoa/{id}")
    public String xoaTranDau(@PathVariable Long id) {
        tranDauRepository.deleteById(id);
        return "redirect:/trandau";
    }
}
