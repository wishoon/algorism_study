package v3.implemention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        String st = br.readLine();

        for (int i = 0; i < str.length; i++) {
            if(st.contains(str[i])) {
                st = st.replace(str[i], "!");
            }
        }
        System.out.println(st.length());
    }
}
