package infrearn.array;

import java.util.ArrayList;
import java.util.Collections;

public class subject09 {
    public int solution(int n , int[][] arr){
        ArrayList<Integer> list = new ArrayList<>();

        int left = 0;
        int right = 0;

        for(int i = 0;i<n;i++){

            int horizon = 0;
            int vertical = 0;

            for(int j = 0;j<n;j++){
                horizon += arr[i][j];
                vertical += arr[j][i];
            }
            left += arr[i][i];
            right += arr[n-i-1][n-i-1];

            list.add(horizon);
            list.add(vertical);
        }

        list.add(left);
        list.add(right);
        Collections.reverse(list);

        return list.get(0);
    }

    // 가으이
    public int solution1(int n, int[][] arr){
        int answer=-2147000000;
        int sum1=0, sum2=0;
        for(int i=0; i<n; i++){
            sum1=sum2=0;
            for(int j=0; j<n; j++){
                sum1+=arr[i][j];
                sum2+=arr[j][i];
            }
            answer=Math.max(answer, sum1);
            answer=Math.max(answer, sum2);
        }
        sum1=sum2=0;
        for(int i=0; i<n; i++){
            sum1+=arr[i][i];
            sum2+=arr[i][n-i-1];
        }
        answer=Math.max(answer, sum1);
        answer=Math.max(answer, sum2);
        return answer;

    }

    public static void main(String[] args) {
        subject09 sub = new subject09();

        int[][] list = new int[][]{
                {10 ,13, 10, 12, 15} ,
                {12, 39, 30, 23, 11} ,
                {11, 25, 50, 53, 15} ,
                {19, 27, 29, 37, 27} ,
                {19, 13, 30, 13, 19}
        };

        int answer = sub.solution(5,list);

        System.out.println(answer);
    }
}
