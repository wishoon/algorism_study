package Inflearn.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 중복을 제거하면서 오름차순, 내림차순 하는 경우에는 TreeSet을 사용하면 좋다.
public class K번째_큰_수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N, K;

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;

		TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {

			}
		}

	}
}
