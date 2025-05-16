package model;

import java.util.List;

public class Recursion {


    public static long giaiThua(int n) {
        if (n == 0 || n == 1) return 1;
        return n * giaiThua(n - 1);
    }


    public static int tongSoAo(List<Integer> soAos, int index) {
        if (index >= soAos.size()) return 0;
        return soAos.get(index) + tongSoAo(soAos, index + 1);
    }


    public static int demSoAoLe(List<Integer> soAos, int index) {
        if (index >= soAos.size()) return 0;
        int dem = (soAos.get(index) % 2 != 0) ? 1 : 0;
        return dem + demSoAoLe(soAos, index + 1);
    }
}
