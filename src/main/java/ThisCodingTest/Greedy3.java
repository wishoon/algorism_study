package ThisCodingTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Greedy3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int count = 0;
        int group = 0;
        int num = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList();

        for(int i=0; i<num; i++){
            arrayList.add(sc.nextInt());
        }
        // 컬렉션으로 오름차순 정렬
        Collections.sort(arrayList);
        // 컬랙션 내림차순 정렬이 필요할시 - 자바 8
        Collections.sort(arrayList, Comparator.<Integer>reverseOrder());

        for(int i=0; i<num; i++){
            count++;
            if(count == arrayList.get(i)){  // 현재 그룹에 포함된 수가 공포드 이상이라면, 그룹 결성
                group++;
                count = 0;
            }
        }
        System.out.println(group);
    }






}
