public class InsertionSort {
    public static void printArray(int[] a) {
        for (int i = 0 ; i< a.length ; i++) {
            System.out.printf("[" + a[i] +"]");
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        int[] a = { 90 , 34 , 78 , 12 , 56 };
        int ins, cmp, temp;

        // 정렬 전 배열 표시
        System.out.printf("정렬전 배열 \n");
        printArray(a);
        System.out.printf("\n");

        for( ins = 1;ins <a.length ; ins++) {
            System.out.printf("외부 반복문 : temp <- a[%d] = %d \n" , ins, a[ins]);
            temp = a[ins];

            for (cmp = ins -1 ; cmp >= 0 ; cmp --) {
                System.out.printf("내부 반복문 : ins = %d, cmp = %d, temp = %d \n" , ins, cmp ,temp);

                if (a[cmp] < temp) {
                    a[cmp + 1] = a[cmp];
                } else {
                    System.out.printf("break 중단 \n");
                    break;
                }
            }

            System.out.printf("외부 반복문 : int =%d , cmp = %d , temp %d \n" , ins , cmp , temp);
            System.out.printf("외부 반복문 : 확정된 삽입 위치 = a[%d] <- temp \n\n" , cmp + 1);
            a[cmp + 1] = temp;
        }
        System.out.printf("정렬 후 배열 \n");

        printArray(a);
    }

    
    
}

