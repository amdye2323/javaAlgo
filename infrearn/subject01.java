package infrearn;

import java.util.Scanner;

public class subject01 {
    public static void main(String[] args) {
        subject01 sub = new subject01();
        String str = "Computercooler";
        char c = 'c';

        int ans = sub.solution(str,c);

        System.out.println(ans);
    }

    public int solution(String str, char t){
        int answer = 0;

        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        for(char x: str.toCharArray()){
            if (x == t) answer++;
        }

        return answer;
    }
}
