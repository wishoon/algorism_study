package Programmers.Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Q42583 {

    public static void main(String[] args) {

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights ={10,10,10,10,10,10,10,10,10,10};

        int answer = 0;
        int c_weight = 0;
        Queue<Integer> bridge = new LinkedList<>();

        for (int cur: truck_weights) {
            while (true){
                if(bridge.isEmpty()) {
                    bridge.add(cur);
                    c_weight += cur;
                    answer++;
                    break;
                } else if(bridge.size() == bridge_length){
                    c_weight -= bridge.poll();
                } else {
                    if(c_weight + cur > weight){
                        bridge.add(0);
                        answer++;
                    } else{
                        bridge.add(cur);
                        c_weight += cur;
                        answer++;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
        System.out.println(answer + bridge_length);
    }
}

// while (!bridge.isEmpty()){
//         if(weight < c_weight + truck_weights[i]){
//        bridge.add(truck_weights[i]);
//        c_weight += truck_weights[i];
//        i++;
//        place++;
//        } else{
//        if(place >= bridge_length){
//        c_weight -= bridge.poll();
//        } else {
//        place++;
//        }
//        }
//        answer++;
//        }