public class MinHeap {
    private int heapMaxSize;
    private int currentSize;
    private int[][] array;

    public MinHeap() {
        this.heapMaxSize = 10;
        array = new int[heapMaxSize][2];
    }

    public MinHeap(int size) {
        this.heapMaxSize = size;
        array = new int[heapMaxSize][2];
    }

    public int getHeapMaxSize() {
        return heapMaxSize;
    }

    public void setHeapMaxSize(int heapMaxSize) {
        this.heapMaxSize = heapMaxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public int[][] getArray() {
        return array;
    }

    public void setArray(int[][] array) {
        this.array = array;
    }

    private void checkSize() {
        if (this.currentSize == this.heapMaxSize)
            this.increaseSize();
    }

    private void increaseSize() {
        int[][] newArray = new int[heapMaxSize * 2][2];
        System.arraycopy(this.array, 0, newArray, 0, this.currentSize);
        array = newArray;
    }

    public void buildMinHeap() {
        for (int index = (this.currentSize - 1) / 2; index >= 0; --index)
            heapify(index);
    }

    public int size() {
        return this.currentSize;
    }

    public void setElement(int index, int[] element) {
        this.array[index] = element;
    }

    public void heapify(int index) {
        int minIndex = index;
        if ((index * 2 + 1 < this.currentSize) && this.array[index][1] > this.array[index * 2 + 1][1])
            minIndex = index * 2 + 1;

        if ((index * 2 + 2 < this.currentSize) && this.array[minIndex][1] > this.array[index * 2 + 2][1])
            minIndex = index * 2 + 2;

        if (minIndex != index) {
            int[] temp = array[minIndex];
            array[minIndex] = array[index];
            array[index] = temp;
            if (index != 0)
                heapify((index - 1) / 2);
        }
    }

    public void add(int[] element) {
        if (element.length != 2)
            return;

        this.checkSize();
        this.array[currentSize++] = element;
        heapify((this.currentSize - 2) / 2);
    }

    public int[] delete() {
        if (this.currentSize == 0)
            return null;

        int[] deleteElement = this.array[0];
        this.array[0] = this.array[currentSize - 1];
        this.array[--currentSize] = null;
        this.buildMinHeap();

        return deleteElement;
    }
}
