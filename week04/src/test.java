import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class test {
    public static void main(String args[]) throws IOException {
        HashMap<Integer, String> db = new HashMap<>();
        Vector<Integer> heapArray = new Vector<>();
        Priority p = new Priority();

        try {
            File file = new File("./data05.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(filereader);
            heapArray.addElement(Integer.MIN_VALUE);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(", ");
                db.put(Integer.parseInt(str[0]), str[1]);
                heapArray.addElement(Integer.parseInt(str[0]));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.buildMaxHeap(heapArray);

        int number = 0;
        String process;
        Scanner scanner = new Scanner(System.in);
        while (number != 6) {
            System.out.println("*** 현재 우선 순위 큐에 저장되어 있는 작업 대기 목록은 다음과 같습니다. ***");
            for (int i = 1; i < heapArray.size(); i++)  // 대기 목록 보여줌
                System.out.println(heapArray.elementAt(i) + ", " + db.get(heapArray.elementAt(i)));

            System.out.println();
            System.out.println("----------------------------------------------");
            System.out.println("1. 작업 추가   2. 최대값   3. 최대 우선순위 작업 처리");
            System.out.println("4. 원소 키값 증가       5. 작업 제거        6. 종료");
            System.out.println("----------------------------------------------");
            System.out.print("작업 할 번호 : ");
            number = scanner.nextInt();
            switch (number) {
                case 1: // 작업 추가
                    int priority = 0;
                    String processName;
                    System.out.print("추가 할 작업 우선순위 입력 : ");
                    priority = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("추가 할 작업 입력 : ");
                    processName = scanner.nextLine();
                    p.insert(db, heapArray, priority, processName);
                    break;
                case 2: // 최대값
                    System.out.print("현재 최고 우선순위 작업 : ");
                    process = p.max(db, heapArray);
                    System.out.println(process);
                    break;
                case 3: // 최대 우선순위 작업 처리
                    System.out.print("최고 우선순위 작업 처리 완료(");
                    System.out.print(p.extract_Max(db, heapArray));
                    System.out.println(")");
                    break;
                case 4: // 원소 키 값 증가
                    int key = 0, newKey = 0;
                    System.out.print("증가시킬 작업의 우선순위 입력 : ");
                    key = scanner.nextInt();
                    if (!heapArray.contains(key)) {
                        System.out.println("잘못된 우선순위 입니다.");
                        break;
                    }
                    System.out.print("새 우선순위 입력 : ");
                    newKey = scanner.nextInt();
                    System.out.println(p.increaseKey(db, heapArray, key, newKey) + "의 키 값을 " + key + "에서 " + newKey + "로 변경했습니다.");
                    break;
                case 5: // 작업 제거
                    int deleteKey = 0;
                    System.out.print("삭제할 작업의 우선순위 입력 : ");
                    deleteKey = scanner.nextInt();
                    if (!heapArray.contains(deleteKey)) {
                        System.out.println("잘못된 우선순위 입니다.");
                        break;
                    }
                    process = p.delete(db, heapArray, deleteKey);
                    System.out.println(process + " 프로세스가 삭제되었습니다.");
                    break;
                case 6: // 종료
                    break;
                default: // 예외
                    System.out.println("번호를 다시 입력하세요 : \n");
                    break;
            }
        }
    }

}
