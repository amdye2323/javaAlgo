import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Test {
    public static void main(String[] args) {
        int[] A = new int[]{-1 , -3};

        int min = 100000;
        int max = -100000;
        int answer = 0;

        Arrays.sort(A);

        for (int i = 0;i<A.length;i++) {
            if (min>=A[i]) {
                min = A[i];
            }

            if (max<=A[i]) {
                max = A[i];
            }
        }

        boolean flag = false;

        for (int i= min ;i<max;i++) {
            flag = false;
            for (int j = 0 ;j<A.length;j++) {
                if (i==A[j]) {
                    flag = true;
                }
            }

            if (!flag) {
                answer = i;
            }
        }

        if (answer == 0) {
            answer = max +1;
        }
        if (answer < 0) {
            answer = 1;
        }

        System.out.println(answer);
    }
}
