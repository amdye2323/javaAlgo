package infrearn.twoArray;

import java.util.ArrayList;

public class subject05 {
    public int solution(int n){
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1;i<=n;i++){
            list.add(i);
        }

        int lt = 0 ,rt =1;

        int maxValue = list.get(lt) + list.get(rt);

        while (true){
            if(rt>=n-1) break;

            if(maxValue==n) {
                answer++;
                rt++;
                maxValue += list.get(rt);
            } else if(maxValue>n){
                maxValue -= list.get(lt);
                lt ++;
            } else if(maxValue<n){
                rt++;
                maxValue += list.get(rt);
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        subject05 sub = new subject05();
        System.out.println(sub.solution(15));
    }
}
