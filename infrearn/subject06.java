package infrearn;

public class subject06 {
    public String solution(String str){
        String answer = "";
        for(int i =0;i<str.length();i++){
            int indexOf = str.indexOf(str.charAt(i));
            // System.out.println(str.charAt(i)+ " "+ i + " " + indexOf);
            if (indexOf == i){
                answer += str.charAt(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        subject06 sub = new subject06();

        System.out.println(sub.solution("ksekkset"));


    }
}
