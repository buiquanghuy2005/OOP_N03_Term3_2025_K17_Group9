package com.example.servingwebcontent.repository;
import com.example.servingwebcontent.model.CauThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CauThuRepository extends JpaRepository<CauThu, String> {
    List<CauThu> findByHoTenIgnoreCase(String hoTen);
    List<CauThu> findByHoTenContainingIgnoreCase(String hoTen);
    List<CauThu> findByViTri(String viTri);
    List<CauThu> findBySoAo(int soAo);
    List<CauThu> findByQuocTich(String quocTich);
    List<CauThu> findBySoBanThangGreaterThan(int soBanThang);
    List<CauThu> findByTheDoGreaterThan(int theDo);
    List<CauThu> findByNgayHetHanHopDongBefore(java.time.LocalDate date);
}
