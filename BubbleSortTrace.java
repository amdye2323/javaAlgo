public class BubbleSortTrace {
    public static void printArray(int[] a){
        for (int i = 0;i< a.length;i++) {
            System.out.printf("["+a[i]+"]");
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        int[] a = { 90, 34, 78 ,12 ,56 };
        int ins ,cmp , temp;

        System.out.printf("정렬 전 배열\n");
        printArray(a);
        System.out.printf("\n");

        for (ins = 0; ins < a.length; ins ++) {
            System.out.printf("외부 반복문 : %d회 \n" , ins +1);
            for (cmp = 0 ;cmp < a.length - ins -1; cmp++) {
                if (a[cmp] > a[cmp+1]) {
                    temp = a[cmp];
                    a[cmp] = a[cmp + 1];
                    a[cmp + 1] = temp;
                }

                System.out.printf("내부 반복문 : ins = %d , cmp = %d , a[%d] = $d\n",
                ins , cmp , cmp , a[cmp]
                );
                // 내부 반복문 1회 실행 후 정렬 중간 결과 내용을 표시
                printArray(a);

            }

            System.out.printf("외부 반복문 : ins = %d, cmp = %d, a[%d] = %d \n",
            ins , cmp , cmp , a[cmp]
            );
            System.out.printf("외부 반복문 : 확정된 정렬 위치 = a[%d] <- %d\n\n" , cmp , a[cmp]);

            printArray(a);
            System.out.printf("\n");

        }

        System.out.printf("외부 반복문 : 확정된 정렬 위치 = a[%d] <- %d\n\n" , 0 ,a[0]);
        
        System.out.printf("정렬 후 배열 \n");
        printArray(a);

    }
}