package infrearn.twoArray;

public class subject06 {
    public int solution(int n){
        int answer = 0;
        int rt = 0;

        int len = (n%2)==1?n/2+1:n/2;

        int[] list = new int[len];

        for(int i = 1;i<=len;i++){
            list[i-1] = i;
        }

        for(int lt = 0;lt<len;lt++){
            int lossCount = 2;
            while (rt<len){
                rt++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        subject06 sub = new subject06();

        System.out.println(sub.solution(15));
    }
}
