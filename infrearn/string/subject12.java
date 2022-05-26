package infrearn.string;

public class subject12 {
    public String solution(int n , String str){
        String answer = "";

        for(int i = 0,j=0;i<n;i++,j+=7){
            String tmp = str.substring(j,j+7).replace("#","1").replace("*","0");
            char a = (char) Integer.parseInt(tmp,2);
            answer += String.valueOf(a);
        }

        return answer;
    }

    public static void main(String[] args) {
        subject12 sub = new subject12();


        System.out.println(sub.solution(4,"#****###**#####**#####**##** "));
    }
}
