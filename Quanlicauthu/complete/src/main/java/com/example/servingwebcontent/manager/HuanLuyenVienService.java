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
        return repository.save(hlv);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
