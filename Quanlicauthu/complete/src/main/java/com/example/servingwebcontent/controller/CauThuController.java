package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.CauThu;
import com.example.servingwebcontent.manager.CauThuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CauThuController {

    @Autowired
    private CauThuService danhSach;

    @GetMapping("/")
    public String hienThiTrangChinh(Model model) {
        model.addAttribute("danhSach", danhSach.getDanhSach());
        model.addAttribute("timKiem", new CauThu(null, null, null, 0, null, null, null, 0, 0, 0, null, null));
        return "danhsach"; 
    }
    @GetMapping("/timkiem")
    public String timKiemCauThu(
            @RequestParam(required = false) String ma,
            @RequestParam(required = false) String hoTen,
            @RequestParam(required = false) String viTri,
            @RequestParam(required = false) Integer soAo,
            @RequestParam(required = false) String quocTich,
            @RequestParam(required = false) String chieuCao,
            @RequestParam(required = false) String canNang,
            @RequestParam(required = false) Integer soBanThang,
            @RequestParam(required = false) Integer theVang,
            @RequestParam(required = false) Integer theDo,
            Model model) {

        List<CauThu> ketQua = danhSach.timKiemTheoTieuChi(
                ma, hoTen, viTri, soAo,
                quocTich, chieuCao, canNang,
                soBanThang, theVang, theDo
        );

        model.addAttribute("ketQua", ketQua);
        return "ketqua"; 
    }

    @GetMapping("/them")
    public String formThem(Model model) {
        model.addAttribute("cauthu", new CauThu(null, null, null, 0, null, null, null, 0, 0, 0, null, null));
        return "form";
    }

    @PostMapping("/luu")
    public String luuCauThu(@ModelAttribute CauThu ct) {
        CauThu daCo = danhSach.getDanhSach().stream()
                .filter(c -> c.getMa().equals(ct.getMa()))
                .findFirst()
                .orElse(null);

        if (daCo != null) {
            danhSach.getDanhSach().remove(daCo);
        }
            danhSach.themCauThu(ct);

        return "redirect:/";
    }

    @GetMapping("/sua/{ma}")
    public String formSua(@PathVariable String ma, Model model) {
        CauThu ct = danhSach.getDanhSach().stream()
                .filter(c -> c.getMa().equals(ma))
                .findFirst()
                .orElse(null);
        model.addAttribute("cauthu", ct);
        return "form";
    }

    @GetMapping("/xoa/{ma}")
    public String xoa(@PathVariable String ma) {
        danhSach.xoaCauThu(ma);
        return "redirect:/";
    }
}
