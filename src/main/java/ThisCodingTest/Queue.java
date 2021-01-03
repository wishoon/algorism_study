package ThisCodingTest;

import java.util.LinkedList;

public class Queue {

    public static void main(String[] args) {
        java.util.Queue<Integer> q = new LinkedList<>();

        q.offer(5);
        q.offer(2);
        q.offer(3);
        q.offer(7);
        q.poll();
        q.offer(1);
        q.offer(4);
        q.poll();

        //먼저 들어온 원소부터 추출
        while(!q.isEmpty()){
            // poll() 메서드를 사용하면 먼저 들어온 데이터를 바로 반환
            System.out.println(q.poll() + " ");
        }
    }


}
