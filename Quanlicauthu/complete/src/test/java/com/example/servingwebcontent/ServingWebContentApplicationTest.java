package com.example.servingwebcontent;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.servingwebcontent.controller.CauThuController;
import com.example.servingwebcontent.model.CauThu;
import com.example.servingwebcontent.manager.CauThuService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.when;

@WebMvcTest(controllers = CauThuController.class)
public class ServingWebContentApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CauThuService cauThuService;

    @Test
    public void homePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Tìm kiếm cầu thủ"))); // Đã sửa cho đúng nội dung thực tế
    }

    @Test
    public void hienThiFormThem() throws Exception {
        mockMvc.perform(get("/them"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Thêm cầu thủ")));
    }

    @Test
    public void hienThiFormSua() throws Exception {
        // Tạo đối tượng CauThu
        CauThu ct = new CauThu(
                "CT01",
                "Nguyễn Văn A",
                "Tiền đạo",
                10,
                "Việt Nam",
                "1.75",
                "65",
                5,
                1,
                0,
                LocalDate.of(2000, 1, 1),
                LocalDate.of(2030, 1, 1)
        );

        when(cauThuService.findById("CT01")).thenReturn(Optional.of(ct));

        mockMvc.perform(get("/sua/CT01"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Nguyễn Văn A")))
                .andExpect(content().string(containsString("Cập nhật cầu thủ"))); // Kiểm tra luôn phần tiêu đề form
    }
}
