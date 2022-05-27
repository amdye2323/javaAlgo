package infrearn.array;

public class subject02 {
    public int solution(int c , int[] list){
        int answer = 0;

        int max = 0;

        for(Integer i :list){
            if(max<i){
                answer ++;
                max = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        subject02 sub = new subject02();

        System.out.println(sub.solution(8,new int[]{130 ,135 ,148 ,140 ,145 ,150 ,150 ,153}));
    }
}
