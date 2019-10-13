import java.util.HashMap;
import java.util.Vector;

public class Priority {
    public void maxHeapify(Vector<Integer> heapArray, int i) {
        int leftChild = 2 * i; // 왼쪽 자식
        int rightChild = 2 * i + 1; // 오른쪽 자식
        int change; // 바뀔 값

        // 왼쪽 자식이 부모보다 클 때
        if (leftChild <= heapArray.size() - 1 && heapArray.elementAt(leftChild) > heapArray.elementAt(i))
            change = leftChild;
        else // 왼쪽 자식보다 부모가 더 클 때
            change = i;

        // 오른쪽 자식이 change값 보다 더 클 때
        if (rightChild <= heapArray.size() - 1 && heapArray.elementAt(rightChild) > heapArray.elementAt(change))
            change = rightChild;

        // change와 i가 같지 않을 때 재귀적으로 maxHepify 실행
        if (change != i) {
            int temp = heapArray.elementAt(i);
            heapArray.setElementAt(heapArray.elementAt(change), i);
            heapArray.setElementAt(temp, change);
            maxHeapify(heapArray, change);
        }
    }

    public void buildMaxHeap(Vector<Integer> heapArray) { // MaxHeap을 만듬
        for (int i = (heapArray.size()) / 2; i >= 1; i--)
            maxHeapify(heapArray, i);
    }

    public void insert(HashMap<Integer, String> db, Vector<Integer> heapArray, int priority, String process) { // 원소를 새로 추가
        db.put(priority, process);
        heapArray.addElement(priority);
        buildMaxHeap(heapArray);
    }

    public String max(HashMap<Integer, String> db, Vector<Integer> heapArray) { // 키 값이 최대인 원소를 리턴
        String s = db.get(heapArray.elementAt(1));
        return s;
    }

    public String extract_Max(HashMap<Integer, String> db, Vector<Integer> heapArray) { // 키 값이 최대인 원소를 재고고
        String s = db.remove(heapArray.elementAt(1));
        heapArray.remove(1);
        buildMaxHeap(heapArray);
        return s;
    }

    public String increaseKey(HashMap<Integer, String> db, Vector<Integer> heapArray, int key, int newKey) { // 키 값을 증가시킴
        String s = db.get(key);
        db.remove(key);
        heapArray.remove(heapArray.indexOf(key));
        heapArray.add(newKey);
        db.put(newKey, s);
        buildMaxHeap(heapArray);
        return s;
    }

    public String delete(HashMap<Integer, String> db, Vector<Integer> heapArray, int key) { // 제거
        String s = db.remove(key);
        heapArray.remove(heapArray.indexOf(key));
        return s;
    }

}