package Inflearn.section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 씨름_선수_오답 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Human[] human = new Human[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            human[i] = new Human(height, weight);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(i == j)
                    continue;
                if(human[i].weight < human[j].weight && human[i].height < human[j].height) {
                    flag = false;
                    break;
                }
            }

            if(flag == true) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static class Human {
        int height;
        int weight;

        public Human(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }
}
