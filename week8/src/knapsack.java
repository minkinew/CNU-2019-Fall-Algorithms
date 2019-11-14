import static java.lang.StrictMath.max;

public class knapsack {
    int[][] arr;
    int item;
    int weight;
    int[][] opt;

    public knapsack(int[][] arr, int item, int weight) {
        this.arr = arr;
        this.item = item;
        this.weight = weight;
        this.opt = new int[item + 1][weight + 1];
    }

    public void makeTable() {
        for (int i = 0; i < item + 1; i++) {
            for (int j = 0; j < weight + 1; j++) {
                this.opt[i][j] = OPT(i, j, arr);
            }
        }
    }

    public int OPT(int i, int w, int[][] arr) {
        if (i == 0)
            return 0;
        else if (arr[i - 1][2] > w)
            return this.opt[i - 1][w];
        else {
            int vi = arr[i - 1][1];
            int wi = arr[i - 1][2];
            int opt1 = this.opt[i - 1][w];
            int opt2 = vi + this.opt[i - 1][w - wi];
            int result = max(opt1, opt2);

            return result;
        }
    }

    public void showTable() {
        for (int i = 0; i < item + 1; i++) {
            for (int j = 0; j < weight + 1; j++) {
                System.out.print(String.format("%4d", opt[i][j]));
            }
            System.out.println();
        }
    }

    public void findMax() {
        System.out.println("Max : " + opt[item][weight]);
    }

    public void findItems() {
        String s = "";
        for (int i = 0; i <= Math.pow(2, item); i++) {
            int result = 0;
            s = Integer.toBinaryString(i);
            while (s.length() != item)
                s = "0" + s;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1')
                    result += arr[j][1];
            }
            if (result == opt[item][weight]) {
                break;
            }
        }
        System.out.print("Items : ");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                System.out.print(arr[i][0] + " ");
            }
        }
    }

}