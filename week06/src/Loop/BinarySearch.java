package Loop;

public class BinarySearch {
    static int arr[] = {17, 28, 43, 67, 88, 92, 100};
    public int BSearch(int a[], int target) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] == target) {
                System.out.println(target + "을 찾았습니다.");
                return mid;
            }
            else if (a[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        System.out.println("target이 없습니다.");
        return 0;
    }
    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        b.BSearch(arr, 28);
    }
}
