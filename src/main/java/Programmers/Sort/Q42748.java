package Programmers.Sort;

import java.io.IOException;
import java.util.Arrays;

public class Q42748 {
    public static void main(String[] args) throws IOException {

   }

    public static int[] soluction(int[] array, int[][] commands){

        int first;
        int end;
        int index;
        int[] answer = {};

        for(int i=0; i< commands.length; i++) {
            first = commands[i][0];
            end = commands[i][1];
            index = commands[i][2];

            int[] tmp = new int[end - first + 1];
            int k = 0;
            for (int j = first - 1; j < end; j++) {
                tmp[k++] = array[j];
            }
            Arrays.sort(tmp);

            answer[i] = tmp[k - 1];
        }
        return answer;
    }
}
