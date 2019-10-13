package Fibonacci;

import java.math.BigInteger;

public class r_squaring {
    public BigInteger recv_sqr(BigInteger n) {
        BigInteger one = BigInteger.ONE; // 1
        BigInteger zero = BigInteger.ZERO; // 0
        BigInteger[][] A = {{one, one}, {one, zero}}; // A행렬 { {1,1}, {1,0} }
        if (n.equals(BigInteger.ZERO)) // n이 0이면 0출력
            return BigInteger.ZERO;
        else if (n.equals(BigInteger.ONE)) // n이 1이면 1출력
            return BigInteger.ONE;
        else // pow메소드 실행
            return pow(A, n)[0][1]; // Fn의 값 (0,1)
    }

    public BigInteger[][] pow(BigInteger[][] A, BigInteger n) {
        BigInteger two = new BigInteger("2"); // 2
        if (n.equals(BigInteger.ONE)) // n이 1이면 A행렬 리턴
            return A;

        BigInteger[][] calcResult = new BigInteger[2][2];
        boolean flag = false; // flag변수, 처음에 false
        if (n.equals(n.divide(two).multiply(two))) { // n이 짝수일 때
            calcResult = pow(A, n.divide(two));
        } else { // n이 홀수일 때
            calcResult = pow(A, n.subtract(BigInteger.ONE).divide(two));
            flag = true; // true로 바꿈
        }
        BigInteger a = calcResult[0][0]; // (0,0)
        BigInteger b = calcResult[0][1]; // (0,1)
        BigInteger c = calcResult[1][0]; // (1,0)
        BigInteger d = calcResult[1][1]; // (1,1)
        BigInteger[][] newCalcResult = {{a.multiply(a).add(b.multiply(c)), b.multiply(a.add(d))}, {c.multiply(a.add(d)), d.multiply(d).add(c.multiply(b))}}; // 행렬곱
        if (flag) { // 홀수일 때
            a = newCalcResult[0][0]; // (0,0)
            b = newCalcResult[0][1]; // (0,1)
            c = newCalcResult[1][0]; // (1,1)
            d = newCalcResult[1][1]; // (1,1)
            BigInteger[][] additionalCalcResult = {{a.add(b), a}, {c.add(d), c}}; // { {ab, a}, {cd, c} }
            return additionalCalcResult;
        }
        return newCalcResult;
    }

    public void string(long n) { // 출력 메소드
        for (int i = 0; i <= n; i++) {
            long start = System.nanoTime(); //코드 실행 전 시간
            BigInteger result = recv_sqr(new BigInteger(Integer.toString(i))); // recv_sqr 메소드 실행
            long end = System.nanoTime(); // 코드 실행 후에 시간
            double time = (double) (end - start) / 1000000000.0; //두 시간에 차 계산
            if (i % 10 == 0)
                System.out.println("----------------------------------------------------------------------");
            System.out.printf("f<%2d> = %-30d  %.12f sec \n", i, result, time);
        }
    }
    
}
