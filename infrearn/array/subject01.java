package infrearn.array;

import java.util.ArrayList;

public class subject01 {
    public ArrayList<Integer> solution(int[] list){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(list[0]);

        for(int i =1;i<list.length;i++){
            if(list[i-1]<list[i]){
                answer.add(list[i]);
            }
        }

        for(int i : answer){
            System.out.println(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        subject01 sub = new subject01();
        sub.solution(new int[]{7,3,9,5,6,12});
    }
}
