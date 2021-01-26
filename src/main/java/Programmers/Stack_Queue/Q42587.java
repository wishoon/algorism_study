package Programmers.Stack_Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Q42587 {

    public static void main(String[] args) {

        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int answer = 0;
        Queue<Node> print = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            print.add(new Node(priorities[i], i));
        }

        int count = 1;
        while (!print.isEmpty()) {
            Node temp = print.poll();
            Iterator iter = print.iterator();
            boolean check = true;

            while(iter.hasNext()) {
                Node next = (Node)iter.next();
                if(temp.n < next.n) {
                    check = false;
                    break;
                }
            }
            if(!check){
                print.add(temp);
            }
            else {
                if(temp.index == location) {
                    answer = count;
                    break;
                }
                else
                    count++;
            }
        }
        System.out.println(answer);
    }

    static class Node {
        int n;
        int index;

        public Node(int n, int index){
            this.n = n;
            this.index = index;
        }
    }
}
