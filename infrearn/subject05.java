package infrearn;

import java.util.ArrayList;

public class subject05 {
    public String solution(String str){
        String answer = "";
        char[] s = str.toCharArray();

        int lt = 0 , rt = str.length() -1;

        while (lt<rt){
            if (!Character.isAlphabetic(s[lt])) lt ++;
            else if(!Character.isAlphabetic(s[rt])) rt --;
            else {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt ++;
                rt --;
            }
        }
        answer =String.valueOf(s);
        return answer;
    }
    public static void main(String[] args) {
        subject05 sub = new subject05();

        System.out.println(sub.solution("a#b!GE*T@S"));
    }
}
