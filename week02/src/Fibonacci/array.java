package Fibonacci;

import java.math.BigInteger; // BigInteger 클래스

public class array {
    public BigInteger bottomUp(int n) {
        BigInteger a[] = new BigInteger[2000];
        a[0] = BigInteger.ZERO; // 0번째 인덱스에 0 저장
        a[1] = BigInteger.ONE; // 1번째 인덱스에 1 저장

        for (int i = 2; i <= n; i++) { // 인덱스 2부터 n까지 반복
            a[i] = a[i - 1].add(a[i - 2]); // 피보나치 수열
        }
        return (a[n]); // 결과 리턴
    }

    public void string(int n) { // 출력 메소드
        for (int i = 0; i <= n; i++) {
            long start = System.nanoTime(); //코드 실행 전 시간
            BigInteger result = bottomUp(i); // bottomUp 메소드 실행
            long end = System.nanoTime(); // 코드 실행 후에 시간
            double time = (double) (end - start) / 1000000000.0; //두 시간에 차 계산
            if (i % 10 == 0)
                System.out.println("----------------------------------------------------------------------");
            System.out.printf("f<%2d> = %-30d  %.12f sec \n", i, result, time);
        }
    }

}
