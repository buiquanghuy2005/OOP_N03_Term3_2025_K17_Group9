package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.manager.DoiBongService;
import com.example.servingwebcontent.model.DoiBong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoiBongController {

    @Autowired
    private DoiBongService doiBongService;

    @GetMapping("/doibong")
    public String hienThiThongTin(Model model) {
        DoiBong doiBong = doiBongService.getDoiBong();
        model.addAttribute("doiBong", doiBong);
        return "doibong";
    }
}
