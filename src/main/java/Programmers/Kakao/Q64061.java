package Programmers.Kakao;

import java.util.Stack;

public class Q64061 {
    public static void main(String[] args) {

        int[] moves = {1,5,3,5,1,2,1,4};
        int[][] board = {{0,0,0,0,0},
                         {0,0,1,0,3},
                         {0,2,5,0,1},
                         {4,2,4,4,2},
                         {3,5,1,3,1}};

        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        int size = moves.length;
        int count = 0;
        while (count != size){
            int move = moves[count];
            move = move - 1;
            int i = 0;
            int temp = 0;
            while(i<board.length){
                if(board[i][move] != 0){
                    temp = board[i][move];
                    board[i][move] = 0;
                    break;
                }
                i++;
            }
            if(!basket.isEmpty()){
                if(basket.peek() == temp) {
                    basket.pop();
                    answer++;
                } else if(temp != 0){
                    basket.push(temp);
                }
            } else {
                if(temp != 0){
                    basket.push(temp);
                }
            }
            count++;
        }
        System.out.println(answer * 2);
    }

}
