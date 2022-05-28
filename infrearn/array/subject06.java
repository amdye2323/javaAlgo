package infrearn.array;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class subject06 {
    public boolean isPrime(int num){
        if(num == 1) return false;
        for(int i = 2;i<num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
    public ArrayList<Integer> solution(int n, int[] list){
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i =0;i<n;i++){
            String tmp = new StringBuilder(list[i]+"").reverse().toString();
            int pareInt = Integer.parseInt(tmp);

            boolean flag = pareInt==1?false:true;

            for(int j = 2;(j*j)<pareInt;j++){
               if(pareInt % j == 0){
                    flag = false;
               }
            }

            if(flag == true){
                answer.add(pareInt);
            }
        }

        return answer;
    }

    public ArrayList<Integer> solution1(int n,int[] arr){
        ArrayList<Integer> answer  = new ArrayList<>();

        for(int i = 0;i<n;i++){
            int tmp = arr[i]; //250
            int res = 0;
            while (tmp>0){
                int t = tmp%10; // 0
                res = res*10+t; // 0
                tmp = tmp/10; // 3 0
            }

            if(isPrime(res)) answer.add(res);
        }

        return answer;
    }

    public static void main(String[] args) {
        subject06 sub = new subject06();

        ArrayList<Integer> answer = sub.solution1(9,new int[]{32, 55, 62, 20, 250, 370, 200, 30, 100});

        answer.forEach(
                (item) -> {
                    System.out.println(item);
                }
        );
    }
}
