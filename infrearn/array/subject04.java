package infrearn.array;

public class subject04 {
    public int favo(int n){
        if(n==1 || n == 2){
            return 1;
        }else {

            return favo(n-1) + favo(n-2);
        }
    }

    public void solution(int n){
        int a = 1, b = 1 , c ;

        System.out.print(a+" "+b+" ");

        for(int i = 2;i<n;i++){
            c = a+b;
            System.out.print(c+" ");
            a = b;
            b = c;

        }
    }


    public static void main(String[] args) {
        subject04 sub = new subject04();

        System.out.println(sub.favo(10));
        sub.solution(10);
    }
}
