package infrearn.hash;

import java.util.HashMap;

public class subject02 {
    public String solution(String a , String b){
        String answer = "YES";
        HashMap<Character,Integer> leftMap = new HashMap<>();
        HashMap<Character,Integer> rightMap = new HashMap<>();

        for(char x:a.toCharArray()) leftMap.put(x,leftMap.getOrDefault(x,0)+1);
        for(char x:b.toCharArray()) rightMap.put(x,leftMap.getOrDefault(x,0)+1);



        return answer;
    }
    public static void main(String[] args) {
        subject02 sub = new subject02();


    }
}
