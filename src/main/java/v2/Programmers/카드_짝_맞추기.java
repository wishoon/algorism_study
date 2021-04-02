//package v2.Programmers;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//
//public class 카드_짝_맞추기 {
//
//    static int[] log = new int[3];
//    static ArrayList<Node> cases = new ArrayList<>();
//
//    public static void main(String[] args) {
//
//        int[][] board = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
//        int r = 1;
//        int c = 0;
//
//        System.out.println(solution(board, r, c));
//    }
//
//    public static int solution (int[][] board, int r, int c){
//        int answer = 0;
//
//        int col = board.length;
//        int row = board[1].length;
//
//        HashSet<Integer> set = new HashSet<>();
//
//        for (int i = 0; i < col; i++) {
//            for (int j = 0; j < row; j++) {
//                if(board[i][j] == 0)
//                    continue;
//                set.add(board[i][j]);
//            }
//        }
//
//        int[] arr = new int[set.size()];
//
//        int count = 0;
//        for (Integer integer : set) {
//            arr[count++] = integer;
//        }
//
//        boolean[] visited = new boolean[set.size()];
//
//        combination(arr, visited, 0, set.size(), 0);
//
//        // 각 경우의 수마다 확인
//        for (int i = 0; i < cases.size(); i++) {
//
//            System.out.println(cases.get(i).getArr_case());
//            // bfs()를 돌릴수 있는 경우의 수가 2개이다.
//        }
//
//        return answer;
//    }
//
//    public static void bfs() {
//
//        // 만약 경로에 도달하였다면 경로 값 반환후 종료
//
//
//        // a 쪽으로 갈지 b쪽으로 갈지를 확인
//        String[] route = new String[2];
//        // 해당 번째 수의 위치 확인
//        // 배열 저장
//
//        // 탐색
//            // 만약 가로 줄 끝에 값이 0 일 경우 끝으로 이동
//
//    }
//
//    public static String position_check() {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < col; i++) {
//            for (int j = 0; j < row; j++) {
//                if(board[i][j] == ) {
//                    sb.append(i + "," + j);
//                }
//            }
//            System.out.println(sb.append("::"));
//        }
//
//        return sb.toString();
//    }
//
//    private static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
//
//        if(r == arr.length) {
//            print(arr, visited, n);
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            if(visited[i] == false) {
//                visited[i] = true;
//                log[r] = arr[i];
//                combination(arr, visited, i + 1, n, r + 1);
//                visited[i] = false;
//            }
//        }
//    }
//
//    private static void print(int[] arr, boolean[] visited, int n) {
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < n; i++) {
//            sb.append(log[i]);
//        }
//
//        cases.add(new Node(sb.toString()));
//    }
//
//    static class Node {
//        String arr_case;
//
//        public Node(String arr_case) {
//            this.arr_case = arr_case;
//        }
//
//        public String getArr_case() {
//            return arr_case;
//        }
//    }
//}
