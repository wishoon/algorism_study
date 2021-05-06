package v2.Programmers;
import java.util.*;

public class 호텔_방_배정 {
    static HashMap<Long, Long> map = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;

        long[] answer = new long[n];

        for(int i = 0; i < n; i++) {
            answer[i] = findNumber(room_number[i]);
        }
        return answer;
    }

    private long findNumber(long want_number) {
        if(!map.containsKey(want_number)) {
            map.put(want_number, want_number + 1);

            return want_number;
        }

        long next_number = map.get(want_number);
        long empty_number = findNumber(next_number);

        map.put(want_number, empty_number);

        return empty_number;
    }
}
