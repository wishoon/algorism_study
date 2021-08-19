package Inflearn.section6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 좌표_정렬 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
}

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) {
            return this.y - o.y;
        } else {
            return this.x - o.x;
        }
    }
}
