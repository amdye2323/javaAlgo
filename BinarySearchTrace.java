import java.util.Scanner;

public class BinarySearchTrace {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] a = { 39,41,52,56,57,69,72 ,81,92 };

        int x , pos, left , right , middle;

        x = scn.nextInt();

        pos = -1;
        left = 0;
        right = a.length -1;
        
        while(pos == -1 && left <= right) {
            middle = (left + right) / 2;

            if (a[middle] == x) {
                pos = middle;
            }else if(a[middle] > x) {
                right = middle - 1;
            }else {
                left = middle + 1;
            } 

            System.out.printf(
                "반복 실행 중 : pos = %d , left = %d , middle = %d, right = %d \n",
                pos, left , middle, right
            );
        }
        System.out.printf("pos = %d" ,pos);
    }
}