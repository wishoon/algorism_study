package v2.Programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class 오픈체팅방 {



    public static void main(String[] args) {

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        System.out.println(solution(record).toString());
    }

    public static String[] solution(String[] record) {

        ArrayList<String> chatLog = new ArrayList<>();
        HashMap<String, String> nickMap = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            String[] word = record[i].split(" ");

            if(word[0].equals("Enter")) {
                nickMap.put(word[1], word[2]);
                chatLog.add(word[1]+"님이 들어왔습니다.");
            } else if(word[0].equals("Leave")) {
                chatLog.add(word[1]+"님이 나갔습니다.");
            } else if(word[0].equals("Change")) {
                nickMap.put(word[1], word[2]);
            }
        }

        String[] answer = new String[chatLog.size()];

        int count = 0;
        for (String str : chatLog) {
            int next_index = str.indexOf("님");
            String userId = str.substring(0, next_index);
            String message = str.substring(next_index);

            String log = nickMap.get(userId) + message;

            answer[count] = log;
            count++;
        }

        return answer;
    }


}
