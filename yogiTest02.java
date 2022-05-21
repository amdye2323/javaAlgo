import java.util.*;

public class yogiTest02 {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,1};

        solution(A);
    }

    public static int solution(int[] A) {
        Arrays.sort(A);

        int count = 0;
        int num = 1;
        int maxCount = A.length;

        for (int i = 0;i<maxCount;i++,num++) {
            if (A[i]!=num) {
                if ((A[i]-num)>=0) {
                    count = count + (A[i]-num);
                } else {
                    count = count + (A[i]-num) * -1;
                }
                // count = count + (A[i]-num);
                A[i] = num;
            }
        }

        return count;
    }
}
