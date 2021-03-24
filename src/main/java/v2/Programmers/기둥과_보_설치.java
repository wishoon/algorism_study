//package v2.Programmers;
//
//public class 기둥과_보_설치 {
//    public static void main(String[] args) {
//
//    }
//
//
//    static boolean[][] pillars, beams;  // 기둥, 보
//
//    public int[][] solution(int n, int[][] build_frame) {
//        /**
//         * 조건
//         * 기둥은 바닥 위에 있거나 보의 한쪽 끝 부분에 있거나, 또는 다른 기둥 위에 있어야 함.
//         * 보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 함.
//         * */
//
//        /**
//         * 주어진 파라미터
//         * x, y는 기둥, 보를 설치 또는 삭제할 교차점의 좌표. [가로, 세로]
//         * a는 설치 또는 삭제할 구조물의 종류를 나타내며, 0은 기둥, 1은 보를 나타냅니다.
//         * b는 구조물읋 설치할 지, 혹은 삭제할 지를 나타내며 0은 삭제, 1은 설치를 나타냅니다.*/
//
//        /**
//         * 최종 리턴 값
//         * x, y는 기둥, 보의 교차점 좌표, 위와 동일
//         * a는 구조물의 종류를 나타내며 위와 동일
//         * return 배열은 x좌표 기준으로 오름차순 정렬하며, 같을 경우 y좌표 오르마순 정렬*/
//
//        int col = build_frame.length;
//        int row = build_frame[0].length;
//
//
//        for (int i = 0; i < col; i++) {
//            int[] temp = build_frame[i];
//
//            for (int j = 0; j < row; j++) {
//                int x = temp[0];
//                int y = temp[1];
//                int a = temp[2];
//                int b = temp[3];
//
//                // 구조물을 설치해야 하는 경우
//                if(b == 1) {
//                    // 보를 설치해야 하는 경우
//                    if(a == 1 && isPillarsCheck(x, y)) {
//                        pillars[y][x] = true;
//                    } else if(a == 0 && isBeamsCheck(x, y)) { // 기둥을 설치해야 하는 경우
//                        beams[y][x] = true;
//                    }
//                    if(isDestruct(x, y, b, n)) {
//                        if(a == 1) {
//                            pillars[y][x] = false;
//                        } else if(a == 0) {
//                            beams[y][x] = false;
//                        }
//                    }
//                } else if(b == 0) {    // 구조물을 삭제해야 하는 경우
//                    if(a == 1)
//                        pillars[y][x] = false;
//                    else if(a == 0)
//                        beams[y][x] = false;
//
//                    if(isDestruct(x, y, b, n)) {
//                        if(a == 1) {
//                            pillars[y][x] = true;
//                        } else if(a == 0) {
//                            beams[y][x] = true;
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    // 설치 및 삭제 후 조건에 맞는지 검증 로직
//    private boolean isDestruct(int x, int y, int b, int n) {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//
//            }
//        }
//        return true;
//    }
//
//    // 보를 설치 할 수 있는 경우
//    static boolean isPillarsCheck(int x, int y) {
//        if(beams[y - 1][x] == true || beams[y - 1][x + 1] == true || (pillars[y][x - 1] == true && pillars[y][x + 1] == true)) {
//            return true;
//        }
//        return false;
//    }
//
//    // 기둥을 설치 할 수 있는 경우
//    // 1. 땅바닥일 경우 2. 왼쪽 밑에 보가 있을 경우 3. y 밑에 기둥이 있을 경우
//    private boolean isBeamsCheck(int x, int y) {
//        if(y == 0 || beams[y][x - 1] == true || pillars[y - 1][x] == true) {
//            return true;
//        }
//        return false;
//    }
//
//}
