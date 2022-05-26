package infrearn.string;

public class subject08 {
    public String solution(String s){
        String answer = "NO";
        s = s.toUpperCase().replaceAll("[^A-Z]","");

        String tmp = new StringBuilder(s).reverse().toString();
        if(s.equals(tmp)) answer = "YES";
        return answer;
    }
    public static void main(String[] args) {
       subject08 sub = new subject08();

       System.out.println(sub.solution("found7, time: study; Yduts; emit, 7Dnuof"));
    }
}
