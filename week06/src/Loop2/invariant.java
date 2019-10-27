package Loop2;


public class invariant {
    public static int sort(int[] a, int[] b) {
        int low = 0;
        int high = a.length;
        int i = 0;
        int j = 0;

        while (low <= high) {
            i = (low + high) / 2;
            j = a.length - i;

            if (i > low && a[i - 1] > b[j]) {
                high = i - 1;
            } else if (i < high && b[j - 1] > a[i]) {
                low = i + 1;
            } else
                break;
        }
        return Math.max(a[i - 1], b[j - 1]);
    }

}