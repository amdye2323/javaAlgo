package infrearn.hash;

import java.util.*;

public class subject01 {
    public String solution(int n,String str){
        String answer = "";

        HashMap<String,Integer> map = new HashMap<>();

        for(String c:str.split("")){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int maxVal = Integer.MIN_VALUE;

        Iterator<String> keys = map.keySet().iterator();

        while (keys.hasNext()){
            String key = keys.next();

            if(maxVal<map.get(key)){
                maxVal = map.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        subject01 sub = new subject01();

        System.out.println(sub.solution(15,"BACBACCACCBDEDE"));

    }
}
