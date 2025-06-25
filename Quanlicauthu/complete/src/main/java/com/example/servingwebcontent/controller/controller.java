package com.example.servingwebcontent.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.servingwebcontent.manager.CauThuService;
import com.example.servingwebcontent.model.CauThu;

public class controller {
    @RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private CauThuService cauThuService;

    @GetMapping("/tatca")
    public List<CauThu> getAllCauThu() {
        return cauThuService.getDanhSach(); // nếu database kết nối thành công, sẽ trả về list
    }
}
   
}
