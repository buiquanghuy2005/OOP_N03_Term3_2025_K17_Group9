package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.TranDau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranDauRepository extends JpaRepository<TranDau, Long> {
}
