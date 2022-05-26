package infrearn;

public class subject07 {
    public String solution(String str){
        String answer = "NO";
//        str = str.toUpperCase();
//
//        int len =  str.length();
//        for(int i =0;i<len;i++){
//            if(str.charAt(i)!=str.charAt(len-i-1)) return "NO";
//        }

        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)) return "YES";

        return answer;
    }

    public static void main(String[] args) {
        subject07 sub = new subject07();

        System.out.println(sub.solution("ddadD"));
    }
}
