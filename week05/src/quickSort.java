import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class quickSort {
    public void saveFile(String path, String result) {
        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            fw.write(result);
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void quickSort(int[] a, int p, int r) { // QuickSort 배열[p...r]을 정렬
        if (p < r) {
            int q = partition(a, p, r); // 분할(pivot)
            quickSort(a, p, q - 1); // 왼쪽 부분배열 정렬
            quickSort(a, q + 1, r); // 오른쪽 부분배열 정렬
        }
    }

    // a[r](피봇)값이 자리한 위치를 return한다.
    public int partition(int[] a, int p, int r) { // pivot값을 기준으로 pivot보다 작은 부분과 큰 부분으로 나눔
        int x = a[r]; // pivot
        int i = p - 1; // pivot 보다 작은 값 중에 마지막 값
        for (int j = p; j < r; j++) { // 배열의 처음부터 끝에서 1전까지 반복
            if (a[j] <= x) { // pivot보다 작은 값이면
                i++; // 인덱스 i 증가
                int temp = a[i]; // a[i]와 a[j]의 자리를 교환
                a[i] = a[j];
                a[j] = temp;
            }
        }
        // pivot과 pivot보다 큰 값들 중 맨 처음값과 자리를 바꿔줌
        i++;
        int temp2 = a[i];
        a[i] = a[r];
        a[r] = temp2;
        return i; // pivot 위치 리턴
    }

    public void quickSort_withRandom(int[] a, int p, int r) { // QuickSort 배열[p...r]을 랜덤하게 정렬
        if (p < r) {
            int q1 = randomizedPartition(a, p, r);
            int q2 = randomizedPartition(a, p, r);
            int q3 = randomizedPartition(a, p, r);
            int q;

            // 분할(pivot)
            if ((q1 <= q2 && q2 <= q3) || (q3 <= q2 && q2 <= q1))
                q = q2;
            else if ((q2 <= q1 && q1 <= q3) || (q3 <= q1 && q1 <= q2))
                q = q1;
            else
                q = q3;

            quickSort(a, p, q - 1); // 왼쪽 부분배열 정렬
            quickSort(a, q + 1, r); // 오른쪽 부분배열 정렬
        }
    }

    public int randomizedPartition(int[] a, int p, int r) { // 랜덤하게 partion을 나눔
        Random random = new Random(); // 랜덤 객체 생성
        int i = random.nextInt(r - p + 1) + p; // p, r 사이의 값을 고르고 p와 더해줌
        int temp = a[r]; // swap
        a[r] = a[i];
        a[i] = temp;
        return partition(a, p, r);
    }

}