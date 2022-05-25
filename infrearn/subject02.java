package infrearn;

public class subject02 {
    public String soution(String str){
        String answer = "";
        for(char x: str.toCharArray()){
            // if(Character.isLowerCase(x)) answer+=Character.toUpperCase(x);
            // else answer+=Character.toLowerCase(x);
            if(x>=65 &&  x<= 90) answer+=(char)(x+32);
            else answer+=(char)(x-32);
        }
        return answer;
    }
    public static void main(String[] args) {
        subject02 sub = new subject02();
        String str = "sTUdy";
        String ans = sub.soution(str);
        System.out.println(ans);
    }
}
