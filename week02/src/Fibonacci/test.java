package Fibonacci;

import java.util.Scanner;

public class test {
    static int number = 50;
    public static void main(String[] args) {
        System.out.println("방법");
        System.out.println("1 : Recursion");
        System.out.println("2 : Array");
        System.out.println("3 : Recursive squaring");
        Scanner scanner = new Scanner(System.in); // Scanner 클래스
        int n = scanner.nextInt(); // 방법 선택

        switch (n) {
            case 1: // Recursion 방법
                recursive r = new recursive();
                r.string(number);
                break;
            case 2: // Array 방법
                array b = new array();
                b.string(number);
                break;
            case 3: // Recursion Squaring 방법
                r_squaring rsq = new r_squaring();
                rsq.string(number);
                break;
            default:
                break;
        }
    }

}
