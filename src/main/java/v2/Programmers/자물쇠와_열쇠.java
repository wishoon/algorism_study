package v2.Programmers;

public class 자물쇠와_열쇠 {
    public boolean solution(int[][] key, int[][] lock) {

        int size = lock.length - 1;

        for (int d = 0; d < 4; d++) {
            int[][] roundKey = round(d, key);
            int[][] paddedKey = padding(roundKey, size);

            for (int R = 0; R < paddedKey.length - size; R++) {
                for (int C = 0; C < paddedKey[0].length - size; C++) {
                    boolean flag = true;

                    for (int r = 0; r < lock.length; r++) {
                        for (int c = 0; c < lock[0].length; c++) {
                            if(lock[r][c] == paddedKey[R + r][C + c])
                                flag = false;
                        }
                    }
                    if(flag)
                        return true;
                }
            }
        }
        return false;
    }

    // 3배수 확장장
    private int[][] padding(int[][] key, int size) {
        int[][] result = new int[key.length + size * 2][key[0].length + size * 2];

        for (int r = 0; r < key.length; r++) {
            for (int c = 0; c < key[0].length; c++) {
                result[r + size][c + size] = key[r][c];
            }
        }
        return result;
    }

    private int[][] round(int cnt, int[][] key) {
        if(cnt == 0) {
            return key;
        }

        int[][] result = null;
        int[][] origin = copy(key);

        for (int i = 0; i < cnt; i++) {
            result = new int[origin.length][origin[0].length];

            for (int r = 0; r < origin.length; r++) {
                for (int c = 0; c < origin[0].length; c++) {
                    result[c][origin.length - 1 - r] = origin[r][c];
                }
            }
            origin = result;
        }
        return result;
    }

    private int[][] copy(int[][] arr){
        int[][] result = new int[arr.length][arr[0].length];

        for(int r = 0 ; r < arr.length ; ++r) {
            for(int c = 0 ; c < arr[r].length ; ++c) {
                result[r][c] = arr[r][c];
            }
        }

        return result;
    }


}