package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.HuanLuyenVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuanLuyenVienRepository extends JpaRepository<HuanLuyenVien, Integer> {
}
