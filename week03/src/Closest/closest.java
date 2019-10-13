package Closest;

public class closest {
    public double closestPair(double[] x, double y[], int n) { // closest pair을 찾음
        double min = Double.MAX_VALUE;

        // 좌표 수가 3이하면 Brute force로 계산
        if (n <= 3) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (distance(x[i], y[i], x[j], y[j]) <= min) {
                        min = distance(x[i], y[i], x[j], y[j]);
                    }
                }
            }
            return min;
        }

        // 좌표 갯수의 n/2에 해당하는 지점을 기준으로 두 개의 부분으로 나눔
        int q = (n - 1) / 2;
        double[] px = new double[q + 1];
        double[] py = new double[q + 1];
        double[] rx = new double[n - 1 - q];
        double[] ry = new double[n - 1 - q];

        // 복사
        for (int i = 0; i < px.length; i++) {
            px[i] = x[i];
            py[i] = y[i];
        }
        for (int i = 0; i < rx.length; i++) {
            rx[i] = x[i + px.length];
            ry[i] = y[i + px.length];
        }

        // 각 구역에서 점들의 최단거리 계산
        double pMin = closestPair(px, py, px.length);
        double rMin = closestPair(rx, ry, rx.length);
        double result = (pMin < rMin) ? pMin : rMin;

        // window를 씌움
        int wpNum = 0;
        int wrNum = x.length - 1;
        for (int i = q; i >= 0; i--) {
            if (x[q] - x[i] > result)
                wpNum = i;
        }
        for (int i = q; i < x.length; i++) {
            if (x[i] - x[q] > result)
                wrNum = i;
        }
        double[] wpArray = new double[wrNum - wpNum + 1];
        double[] wrArray = new double[wrNum - wpNum + 1];
        for (int i = wpNum; i <= wrNum; i++) {
            wpArray[i - wpNum] = x[i];
            wrArray[i - wpNum] = y[i];
        }

        // y값 기준으로 정렬
        quickSort(wrArray, wpArray, 0, wrArray.length - 1);

        // window 내부에서 최단거리 계산
        for (int i = 0; i < wrArray.length - 1; i++) {
            if (wrArray[i + 1] - wrArray[i] < result)
                result = (result < distance(wpArray[i], wrArray[i], wpArray[i + 1], wrArray[i + 1])) ?
                        result : distance(wpArray[i], wrArray[i], wpArray[i + 1], wrArray[i + 1]);
        }
        return result;
    }

    public double distance(double x1, double y1, double x2, double y2) { // 두 점 사이의 거리
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public int partition(double[] xA, double[] yA, int p, int r) { // partition
        double x = xA[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (xA[j] <= x) {
                i++;
                double tmpX = xA[i];
                xA[i] = xA[j];
                xA[j] = tmpX;

                double tmpY = yA[i];
                yA[i] = yA[j];
                yA[j] = tmpY;
            }
        }
        i++;
        double tmpX2 = xA[i];
        xA[i] = xA[r];
        xA[r] = tmpX2;

        double tmpY2 = yA[i];
        yA[i] = yA[r];
        yA[r] = tmpY2;
        return i;
    }

    public void quickSort(double[] xA, double[] yA, int p, int r) { // quickSort
        if (p < r) {
            int q = partition(xA, yA, p, r);
            quickSort(xA, yA, p, q - 1);
            quickSort(xA, yA, q + 1, r);
        }
    }

}
