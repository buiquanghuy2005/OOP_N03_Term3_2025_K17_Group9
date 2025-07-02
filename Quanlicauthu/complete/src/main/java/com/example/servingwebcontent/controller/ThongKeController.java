package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.CauThu;
import com.example.servingwebcontent.model.ThongKe;
import com.example.servingwebcontent.model.TranDau;
import com.example.servingwebcontent.repository.CauThuRepository;
import com.example.servingwebcontent.repository.TranDauRepository;
import com.example.servingwebcontent.manager.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ThongKeController {

    @Autowired
    private CauThuRepository cauThuRepository;

    @Autowired
    private TranDauRepository tranDauRepository;

    @Autowired
    private ThongKeService thongKeService;

    @GetMapping("/thongke")
    public String hienThiThongKe(Model model) {
        List<CauThu> danhSachCauThu = cauThuRepository.findAll();
        List<TranDau> tranDauList = tranDauRepository.findAll();
        String tenDoiMacDinh = "FC Song Châu";
        ThongKe thongKe = thongKeService.thongKe(danhSachCauThu, tranDauList, tenDoiMacDinh);

        Map<String, Integer> viTriData = thongKeService.thongKeTheoViTri(danhSachCauThu);
        Map<String, Integer> quocTichData = thongKeService.thongKeTheoQuocTich(danhSachCauThu);
        Map<String, Integer> thePhatData = thongKeService.thongKeThePhat(danhSachCauThu);
    
        Map<String, Integer> ketQuaData = thongKeService.thongKeTiLeKetQua(tranDauList, tenDoiMacDinh);

        model.addAttribute("thongKe", thongKe);
        model.addAttribute("viTriData", viTriData);
        model.addAttribute("quocTichData", quocTichData);
        model.addAttribute("thePhatData", thePhatData);
        model.addAttribute("ketQuaData", ketQuaData); 

        return "thongke";
    }
}
