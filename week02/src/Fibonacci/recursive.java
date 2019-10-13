package Fibonacci;

import java.math.BigInteger; // BigInteger 클래스

public class recursive {
    public BigInteger recv(int n) {
        if (n == 0) // n이 0이면 0출력
            return BigInteger.ZERO;
        else if (n == 1) // n이 1이면 1출력
            return BigInteger.ONE;
        else // n이 2이상이면 재귀를 돌며 피보나치 값 구함
            return recv(n - 1).add(recv(n - 2));
    }

    public void string(int n) { // 출력 메소드
        for (int i = 0; i <= n; i++) {
            long start = System.nanoTime(); //코드 실행 전 시간
            BigInteger result = recv(i); // recv 메소드 실행
            long end = System.nanoTime(); // 코드 실행 후에 시간
            double time = (double) (end - start) / 1000000000.0; //두 시간에 차 계산
            if (i % 10 == 0)
                System.out.println("----------------------------------------------------------------------");
            System.out.printf("f<%2d> = %-30d  %.12f sec \n", i, result, time);
        }
    }

}
