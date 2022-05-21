import java.util.ArrayList;
import java.util.Arrays;

public class CodeTest03 {

    public static void main(String[] args) {
        int[] A = new int[]{7,-5,-5,-5,7,-1,7};

        int[] B = new int[A.length];

        for (int i = 0;i<A.length;i++) {
            int a = i;
            boolean seFlag = false;
            B[i] = 1;
            while (true){
                if (a+2<A.length){ // 자기 자신
                    if (A[a+2]==A[i]) {
                        a+=2;
                        B[i] += 2;
                    } else {
                        break;
                    }
                }else {
                    break;
                }
                if(a+1<A.length) { // 옆에
                    if (A[a+1]!=A[i]) {
                        seFlag = true;
                    }
                }
            }

            if (!seFlag) {
                B[i] = B[i]+1;
            }
        }
        Arrays.sort(B);

        int answers = B[B.length-1];
        System.out.println(answers);
    }
}
