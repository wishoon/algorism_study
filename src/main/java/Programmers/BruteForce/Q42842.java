package Programmers.BruteForce;

public class Q42842 {
    public static void main(String[] args) {

        int brown = 8;
        int yellow = 1;

        int height = 0;
        int width = 0;

        for(height = 3; height < (brown + 4) / 2; height++){
            width = ((brown + 4) / 2) - height;
            int redCount = (width - 2) * (height - 2);

            if(width >= height && yellow == redCount)
                break;
        }

        int[] answer = new int[] { width, height };

        System.out.println(width + " " + height);
    }
}
