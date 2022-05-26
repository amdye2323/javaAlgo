package infrearn.string;

import java.util.ArrayList;

public class subject04 {
    public ArrayList<String> solution(int n,String[] str){
        ArrayList<String> answer = new ArrayList<>();
//        for(String x : str) {
//            String tmp = new StringBuilder(x).reverse().toString();
//            answer.add(tmp);
//        }
        for (String x: str) {
            char[] s = x.toCharArray();
            int lt = 0 , rt = x.length()-1;
            while (lt<rt){
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt ++;
                rt --;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
        return answer;
    }
    public static void main(String[] args) {
        subject04 sub = new subject04();
        int n = 3;
        String [] str = new String[]{"good","Time","Big"};

        ArrayList<String> list =  sub.solution(n,str);

        for(String s :list) System.out.println(s);
    }
}
