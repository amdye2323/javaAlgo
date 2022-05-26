package infrearn.string;

public class subject09 {
    public int solution (String s) {
        String answer = "";

        for(char x :s.toCharArray()){
//            if(x>=48 && x<=57) answer = answer*10 + (x-48);
            if(Character.isDigit(x)) answer+=x;
        }

        return Integer.parseInt(answer);
    }
    public static void main(String[] args) {
        subject09 sub = new subject09();

        System.out.println(sub.solution("g0ejdf2ad1120"));
    }
}
