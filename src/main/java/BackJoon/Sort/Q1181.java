package BackJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

public class Q1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> arr1 = new HashSet<String>();

        for (int i = 0; i < N; i++) {
            arr1.add(br.readLine());
        }

        Iterator<String> it = arr1.iterator();

        int index = 0;
        String[] arr = new String[arr1.size()];
        while(it.hasNext()){
            arr[index] = it.next();
            index++;
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return 1;
                else if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                return -1;
            }
        });

        for (int i = 0; i < arr1.size(); i++){
            System.out.println(arr[i]);
        }
    }
}
