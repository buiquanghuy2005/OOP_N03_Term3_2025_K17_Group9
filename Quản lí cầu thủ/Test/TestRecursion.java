package Test;

import model.Recursion;

import java.util.Arrays;
import java.util.List;

public class TestRecursion {
    public static void main(String[] args) {
        List<Integer> soAo = Arrays.asList(7, 10, 9, 5, 11);

        int tong = Recursion.tongSoAo(soAo, 0);

        System.out.println("Tổng số áo: " + tong); 
    }
}
