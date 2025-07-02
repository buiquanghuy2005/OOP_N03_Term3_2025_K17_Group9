package com.example.servingwebcontent.manager;

import com.example.servingwebcontent.model.HuanLuyenVien;
import com.example.servingwebcontent.repository.HuanLuyenVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HuanLuyenVienService {

    @Autowired
    private HuanLuyenVienRepository repository;

    public List<HuanLuyenVien> findAll() {
        return repository.findAll();
    }

    public Optional<HuanLuyenVien> findById(int id) {
        return repository.findById(id);
    }

    public HuanLuyenVien save(HuanLuyenVien hlv) {
        // Nếu là thêm mới (id chưa tồn tại)
        if (!repository.existsById(hlv.getId())) {
            return repository.save(hlv);
        }

        // Nếu là cập nhật
        Optional<HuanLuyenVien> existing = repository.findById(hlv.getId());
        if (existing.isPresent()) {
            return repository.save(hlv); // cho phép cập nhật
        }

        // Nếu ID đã tồn tại mà không nằm trong 2 trường hợp trên thì trả lỗi
        throw new IllegalArgumentException("Huấn luyện viên với ID " + hlv.getId() + " đã tồn tại!");
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
