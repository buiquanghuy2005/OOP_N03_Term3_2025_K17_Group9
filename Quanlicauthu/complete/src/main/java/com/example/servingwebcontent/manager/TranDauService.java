package com.example.servingwebcontent.manager;

import com.example.servingwebcontent.model.TranDau;
import com.example.servingwebcontent.repository.TranDauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TranDauService {

    @Autowired
    private TranDauRepository tranDauRepository;

    // Lấy danh sách tất cả trận đấu
    public List<TranDau> getAllTranDau() {
        return tranDauRepository.findAll();
    }

    // Lưu hoặc cập nhật một trận đấu
    public void saveTranDau(TranDau tranDau) {
        tranDauRepository.save(tranDau);
    }

    // Tìm trận đấu theo ID
    public Optional<TranDau> getTranDauById(Long id) {
        return tranDauRepository.findById(id);
    }

    // Xoá trận đấu theo ID
    public void deleteTranDauById(Long id) {
        tranDauRepository.deleteById(id);
    }
}
