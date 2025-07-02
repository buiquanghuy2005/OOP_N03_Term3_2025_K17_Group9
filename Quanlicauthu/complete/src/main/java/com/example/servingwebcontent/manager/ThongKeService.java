package com.example.servingwebcontent.manager;

import com.example.servingwebcontent.model.CauThu;
import com.example.servingwebcontent.model.ThongKe;
import com.example.servingwebcontent.model.TranDau;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ThongKeService {

    public ThongKe thongKe(List<CauThu> danhSach, List<TranDau> tranDauList, String tenDoiMacDinh) {
        ThongKe tk = new ThongKe();
        if (danhSach == null || danhSach.isEmpty()) return tk;

        tk.setTongSoCauThu(danhSach.size());

        int tongTuoi = 0, tongBanThang = 0, tongTheVang = 0, tongTheDo = 0;
        CauThu maxBanThang = danhSach.get(0);
        CauThu maxTuoi = danhSach.get(0);
        CauThu caoNhat = null;
        double maxChieuCao = -1;

        for (CauThu ct : danhSach) {
            tongTuoi += ct.getTuoi();
            tongBanThang += ct.getSoBanThang();
            tongTheVang += ct.getTheVang();
            tongTheDo += ct.getTheDo();

            if (ct.getSoBanThang() > maxBanThang.getSoBanThang()) {
                maxBanThang = ct;
            }

            if (ct.getTuoi() > maxTuoi.getTuoi()) {
                maxTuoi = ct;
            }

            try {
                double chieuCao = Double.parseDouble(ct.getChieuCao());
                if (chieuCao > maxChieuCao) {
                    maxChieuCao = chieuCao;
                    caoNhat = ct;
                }
            } catch (NumberFormatException ignored) {}
        }

        int soTranThamGia = 0;
        int soTranThang = 0;

        for (TranDau tran : tranDauList) {
            boolean laDoiNha = tran.getDoiNha().equalsIgnoreCase(tenDoiMacDinh);
            boolean laDoiKhach = tran.getDoiKhach().equalsIgnoreCase(tenDoiMacDinh);

            if (laDoiNha || laDoiKhach) {
                soTranThamGia++;

                int banThangMacDinh = laDoiNha ? tran.getBanThangNha() : tran.getBanThangKhach();
                int banThangConLai = laDoiNha ? tran.getBanThangKhach() : tran.getBanThangNha();

                if (banThangMacDinh > banThangConLai) {
                    soTranThang++;
                }
            }
        }

        double tiLeThang = soTranThamGia > 0 ? ((double) soTranThang / soTranThamGia) * 100 : 0;

        tk.setTuoiTrungBinh((double) tongTuoi / danhSach.size());
        tk.setTongSoBanThang(tongBanThang);
        tk.setTongTheVang(tongTheVang);
        tk.setTongTheDo(tongTheDo);
        tk.setCauThuGhiBanNhieuNhat(maxBanThang);
        tk.setCauThuLonTuoiNhat(maxTuoi);
        tk.setCauThuCaoNhat(caoNhat);
        tk.setTiLeThang(tiLeThang);

        return tk;
    }

    public Map<String, Integer> thongKeTheoViTri(List<CauThu> ds) {
        Map<String, Integer> result = new LinkedHashMap<>();
        for (CauThu ct : ds) {
            String vt = ct.getViTri();
            result.put(vt, result.getOrDefault(vt, 0) + 1);
        }
        return result;
    }

    public Map<String, Integer> thongKeTheoQuocTich(List<CauThu> ds) {
        Map<String, Integer> result = new LinkedHashMap<>();
        for (CauThu ct : ds) {
            String qt = ct.getQuocTich();
            result.put(qt, result.getOrDefault(qt, 0) + 1);
        }
        return result;
    }

    public Map<String, Integer> thongKeThePhat(List<CauThu> ds) {
        int vang = 0, do_ = 0;
        for (CauThu ct : ds) {
            vang += ct.getTheVang();
            do_ += ct.getTheDo();
        }
        Map<String, Integer> result = new LinkedHashMap<>();
        result.put("Thẻ vàng", vang);
        result.put("Thẻ đỏ", do_);
        return result;
    }

    public Map<String, Integer> thongKeTiLeThang(double tiLeThang) {
        Map<String, Integer> result = new LinkedHashMap<>();
        result.put("Thắng", (int) tiLeThang);
        result.put("Khác", 100 - (int) tiLeThang);
        return result;
    }

    public Map<String, Integer> thongKeTiLeKetQua(List<TranDau> tranDauList, String tenDoiMacDinh) {
        int thang = 0, hoa = 0, thua = 0;

        for (TranDau tran : tranDauList) {
            boolean laDoiNha = tran.getDoiNha().equalsIgnoreCase(tenDoiMacDinh);
            boolean laDoiKhach = tran.getDoiKhach().equalsIgnoreCase(tenDoiMacDinh);

            if (laDoiNha || laDoiKhach) {
                int banThangMacDinh = laDoiNha ? tran.getBanThangNha() : tran.getBanThangKhach();
                int banThangDoiConLai = laDoiNha ? tran.getBanThangKhach() : tran.getBanThangNha();

                if (banThangMacDinh > banThangDoiConLai) {
                    thang++;
                } else if (banThangMacDinh == banThangDoiConLai) {
                    hoa++;
                } else {
                    thua++;
                }
            }
        }

        Map<String, Integer> result = new LinkedHashMap<>();
        result.put("Thắng", thang);
        result.put("Hòa", hoa);
        result.put("Thua", thua);

        return result;
    }
}
