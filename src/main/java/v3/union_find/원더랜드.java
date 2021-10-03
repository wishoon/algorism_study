package v3.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 원더랜드 {

    static int[] uf;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V, E;
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // union 배열 만들기
        uf = new int[V + 1];
        for (int i = 1; i < V; i++) {
            uf[i] = i;
        }

        List<City> pq = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new City(a, b, c));
        }

        Collections.sort(pq);

        int answer = 0;

        for (City city : pq) {
            int fv1 = find(city.start);
            int fv2 = find(city.end);

            if(fv1 != fv2) {
                answer += city.cost;
                union(fv1, fv2);
            }
        }

        System.out.println(answer);
    }

    public static void union(int v1, int v2) {

        int f1 = find(v1);
        int f2 = find(v2);

        if(f1 != f2) {
            uf[f1] = f2;
        }
    }

    public static int find(int n) {
        if(n == uf[n]) {
            return uf[n];
        } else {
            return uf[n] = find(uf[n]);
        }
    }

    static class City implements Comparable<City>{
        int start;
        int end;
        int cost;

        public City(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(City city) {
            return this.cost - city.cost;
        }
    }
}
