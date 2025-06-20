package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.model.CauThu;
import com.example.servingwebcontent.model.DanhSachCauThu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TimKiemCauThuController {

    DanhSachCauThu danhSach = new DanhSachCauThu(); 

    @GetMapping("/timkiem")
    public String timKiemTheoChieuCao(@RequestParam double chieuCao, Model model) {
        try {
            List<CauThu> ketQua = danhSach.timKiemTheoTieuChi(
            null, null, null, null,
            null, String.valueOf(chieuCao), null,
            null, null, null
        );

            model.addAttribute("ketQua", ketQua);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("thongBao", "Đã xảy ra lỗi khi tìm kiếm.");
        } finally {
            System.out.println("Đã thực hiện xong tìm kiếm chiều cao.");
        }
        return "ketqua"; 

    }
    @GetMapping("/")
public String hienThiForm() {
    return "timkiem"; 
}
}
