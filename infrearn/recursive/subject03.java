package infrearn.recursive;

public class subject03 {

    public int solution(int n){
        if(n==1){
            return 1;
        }else {
            return n * solution(n-1);
        }
    }

    public static void main(String[] args) {
        subject03 sub = new subject03();
        System.out.println(sub.solution(5));
    }
}
