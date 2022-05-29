package infrearn.twoArray;

import java.util.ArrayList;
import java.util.Collections;

public class subject02 {

    public ArrayList<Integer> solution(int n,int m ,int[] a ,int[] b){
        ArrayList<Integer> answer = new ArrayList<>();

        for(Integer x:a){
            for(Integer y:b){
                if(x==y){
                    answer.add(x);
                }
            }
        }

        Collections.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        subject02 sub = new subject02();

        System.out.println(sub.solution(5,5,new int[]{1,3,9,5,2},new int[]{3,2,5,7,8}));
    }
}
