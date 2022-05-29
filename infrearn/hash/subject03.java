package infrearn.hash;

import java.util.*;

public class subject03 {
    public ArrayList<Integer> solution(int n , int k , int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<k-1;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        int lt = 0;
        for(int rt=k-1;rt<n;rt++){
            map.put(arr[rt],map.getOrDefault(arr[rt],0)+1);
            answer.add(map.size());
            map.put(arr[lt],map.get(arr[lt])-1);
            if(map.get(arr[lt])==0){
                map.remove(arr[lt]);
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        subject03 sub = new subject03();

        System.out.println(sub.solution(7,4,new int[]{20 ,12 ,20 ,10, 23, 17, 10}));
    }
}
