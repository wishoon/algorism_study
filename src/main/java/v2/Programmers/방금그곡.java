package v2.Programmers;

public class 방금그곡 {
    public static void main(String[] args) {

        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicinfos));
    }
    // musicinfos -> 곡 정보를 담고 있는 배열들 1 ~ 100개 이하의 곡 정보를 담고 있음.
    // 각 음악 정보에는 시작시간, 종료시간, 음악 제목, 멜로디 전부를 담고 있음. (각 멜로리는 1개당 1분임)
    // m 찾고자 하는 음악의 멜로리 정보를 담고 있음

    public static String solution(String m, String[] musicinfos) {

        String answer = "";
        int maxRunningTime = 0;

        m = replaceCord(m);

        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");

            int hour = Integer.parseInt(info[1].split(":")[0]) - Integer.parseInt(info[0].split(":")[0]);
            int minute = Integer.parseInt(info[1].split(":")[1]) - Integer.parseInt(info[0].split(":")[1]);
            int runningTime = hour * 60 + minute;

            String cord = replaceCord(info[3]);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < runningTime; i++) {
                sb.append(cord.charAt(i % cord.length()));
            }

            cord = sb.toString();

            if(cord.contains(m)) {
                if(maxRunningTime < cord.length()) {
                    maxRunningTime = cord.length();
                    answer = info[2];
                }
            }
        }

        if(answer.equals("")) {
            return "(None)";
        }

        return answer;
    }


    private static String replaceCord(String m) {
        return m.replace("C#", "c")
                .replace("D#", "d")
                .replace("E#", "e")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }
}
