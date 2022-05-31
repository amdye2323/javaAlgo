package infrearn.twoArray;

import java.util.ArrayList;

public class subject03 {

    public int solution(int n , int m, int[] arr){
        int answer = 0;
        int maxValue = 0;

        for(int i =0;i<m;i++){
            maxValue += arr[i];
        }

        answer = maxValue;

        for(int i =0, j = m;j<n;i++,j++){
            maxValue = maxValue - arr[i] + arr[j];
            answer = Math.max(answer,maxValue);
        }

        return answer;
    }

    public static void main(String[] args) {
        subject03 sub = new subject03();

        System.out.println(sub.solution(10,3,new int[]{12,15,11,20 ,25 ,10, 20, 19, 13, 15}));
    }
}
