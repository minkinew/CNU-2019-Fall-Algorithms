package Inversion;

public class inversion {
    // p는 시작 인덱스, r는 끝 인덱스, q는 중간 인덱스
    public int mergeSort(int a[], int p, int r) {
        int count = 0;
        if (p < r) {
            int q = (p + r) / 2; // 중간 지점
            int pCount = mergeSort(a, p, q); // 전반부 정렬
            int qCount = mergeSort(a, q + 1, r); // 후반부 정렬
            int mergeCount = merge(a, p, q, r); // 합병
            count = pCount + qCount + mergeCount;
        }
        // p가 r보다 크거나 같다면 데이터가 갯수가 0, 1이므로 정렬할 필요가 없음.
        return count;
    }

    public int merge(int[] a, int p, int q, int r) { // 정렬된 두 배열을 합하여 하나의 정렬된 배열을 만듬
        int i = p;
        int j = q + 1;
        int k = p;
        int count = 0;
        int temp[] = new int[a.length]; // 새로 정렬할 배열


        while (i <= q && j <= r) {
            if (a[i] <= a[j]) // 전반부 원소가 더 작을 경우
                temp[k++] = a[i++]; // 다음 원소로 이동하고 새로운 배열에 추가
            else {// 후반부 원소가 더 작을 경우
                temp[k++] = a[j++]; // 다음 원소로 이동하고 새로운 배열에 추가
                count = count + (q - i + 1);
            }
        }
        while (i <= q)  // 전반부에 남아있는 원소가 있을 때
            temp[k++] = a[i++]; // 순서대로 새로운 배열에 정렬
        while (j <= r) // 후반부에 남아있는 원소가 있을 때
            temp[k++] = a[j++]; // 순서대로 새로운 배열에 정렬
        for (int n = p; n <= r; n++)
            a[n] = temp[n]; // 새로운 배열에 정렬된 데이터들을 원래 배열로 이동

        return count;
    }
}
