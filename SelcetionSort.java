public class SelcetionSort {
    public static void printArray(int[] a){
        for (int i = 0;i< a.length;i++) {
            System.out.printf("["+a[i]+"]");
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        int[] a = { 90, 34, 78 ,12 ,56 };

        int ins ,cmp , min, temp;

        System.out.printf("정렬 전 배열\n");
        printArray(a);
        System.out.printf("\n");
 
        for (ins = 0 ;ins < a.length; ins++) { 
            System.out.printf("외부 반복문 : %d회 \n" , ins +1);
            min = ins; // 시작 인덱스 값 저장
            for (cmp = ins + 1; cmp < a.length ; cmp++) {
                if (a[cmp] < a[ins] ) { //시작 값 이 크다면
                    min = cmp;
                    temp = a[ins];
                    a[ins] = a[min];
                    a[min] = temp;
                }
                
            }
        }

        System.out.printf("정렬 후 배열\n");
        printArray(a);
    }
}
