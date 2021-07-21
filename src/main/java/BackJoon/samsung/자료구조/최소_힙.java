package BackJoon.samsung.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 최소_힙 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 최소힙 객체 생성
        MinHeap mh = new MinHeap();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) {
                System.out.println(mh.delete());
            } else {
                mh.insert(input);
            }
        }
    }
}
class MinHeap {

    List<Integer> list;

    public MinHeap() {
        list = new ArrayList<>();
        // 첫번째 칸은 0으로 넣고 시작하는 것이 계산이 편한다.
        list.add(0);
    }

    public void insert(int val) {
        // 가장 뒤에 붙는다.
        list.add(val);

        int current = list.size() - 1;
        // 부모로 갈 수 있음
        int parent = current / 2;

        while(true) {
            if(parent == 0 || list.get(parent) <= list.get(current)) {
                break;
            }

            // 나와 부모 위치를 바꾸고
            int temp = list.get(parent);
            list.set(parent, list.get(current));
            list.set(current, temp);

            // 부모 위치를 다시 변경해준다
            current = parent;
            parent = current / 2;
        }
    }
    public int delete() {

        // root Node 가져오기

        // 만약 리스트가 비어있을 경우에 대한 방어 코드
        if(list.size() == 1) {
            return 0;
        }
        int top = list.get(1);
        // 리스트의 마지막과 루트를 변경
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentPos = 1;
        while(true) {
            int leftPos = currentPos * 2;
            int rightPos = currentPos * 2 + 1;

            if(leftPos >= list.size()) {
                break;
            }

            int minValue = list.get(leftPos);
            int minPos= leftPos;

            if(rightPos < list.size() && minValue > list.get(rightPos)) {
                minValue = list.get(rightPos);
                minPos = rightPos;
            }

            if(list.get(currentPos) > minValue) {
                int temp = list.get(currentPos);
                list.set(currentPos, list.get(minPos));
                list.set(minPos, temp);
                currentPos = minPos;
            } else {
                break;
            }
        }

        return top;
    }
}
