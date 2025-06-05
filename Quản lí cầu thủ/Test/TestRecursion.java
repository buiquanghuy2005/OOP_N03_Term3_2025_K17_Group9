package Test;

import java.util.Arrays;
import java.util.List;

public class TestRecursion {
    public static void main(String[] args, Object Recursion) {
        List<Integer> soAo = Arrays.asList(7, 10, 9, 5, 11);

        int tong = ((Object) Recursion).tongSoAo(soAo, 0);

        System.out.println("Tổng số áo: " + tong); 
    }
}
