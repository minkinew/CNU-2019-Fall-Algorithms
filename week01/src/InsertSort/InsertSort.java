package InsertSort;

public class InsertSort {
    public void insert(int a[]) {
        int present = 0; // 기준값
        int previous = 0; // 이전값

        for (int i = 1; i <= a.length - 1; i++) {
            System.out.print(i + "단계 :");
            present = a[i]; // 기준값 저장
            previous = i - 1;  // 이전값 저장
            while (previous >= 0 && present < a[previous]) { // 이전값이 기준값보다 크면
                int temp = a[previous + 1]; // swap
                a[previous + 1] = a[previous];
                a[previous] = temp;
                previous--; // 1감소시키면서 반복문 수행
            }

            for (int j = 0; j <= a.length - 1; j++)
                System.out.print("  " + a[j]); // 정렬된 값을 출력
            System.out.println();
        }
        System.out.println();
    }
}