package infrearn.array;

public class subject07 {

    public int solution(int n , int[] list){
        int answer = 0;
        int count = 1;

        for(int i =0;i<n;i++){
            if(list[i] == 1){
                answer = count + answer;
                count++;
            } else {
                count = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        subject07 sub = new subject07();

        int answer = sub.solution(10,new int[]{1,0,1,1,1,0,0,1,1,0});

        System.out.println(answer);
    }
}
