package infrearn.hash;

import java.util.HashMap;

public class subject02 {
    public String solution(String a , String b){
        String answer = "YES";
        HashMap<Character,Integer> leftMap = new HashMap<>();
        HashMap<Character,Integer> rightMap = new HashMap<>();

        for(char x:a.toCharArray()) leftMap.put(x,leftMap.getOrDefault(x,0)+1);
        for(char x:b.toCharArray()) rightMap.put(x,rightMap.getOrDefault(x,0)+1);

        // 이 방법 이외 지우면서 하는 방법도 가능
        for(char x:leftMap.keySet()){
            boolean flag = false;
            for(char y: rightMap.keySet()){
                if(x==y && leftMap.get(x) == rightMap.get(y)){
                    flag =true;
                }
            }
            if(flag==false){
                return "NO";
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        subject02 sub = new subject02();

        System.out.println(sub.solution("AbaAeCe","baeeACA"));
    }
}
