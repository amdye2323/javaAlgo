package infrearn;

public class subject03 {
    public String solution(String str){
        String answer = "";
        int m = Integer.MIN_VALUE , pos;

        while ((pos = str.indexOf(' ')) !=-1){
            String tmp = str.substring(0,pos);
            int len = tmp.length();
            if(len>m){
                m = len;
                answer = tmp;
            }

            str = str.substring(pos+1);
        }

        if(str.length()>m) answer=str;

//        String[] s = str.split(" ");
//
//        for(String x : s){
//            System.out.println(x);
//            int len = x.length();
//            if(len>m) {
//                m = len;
//                answer = x;
//            }
//        }

        return answer;
    }

    public static void main(String[] args) {
        subject03 sub = new subject03();
        String str = "it is time to study";
        String ans = sub.solution(str);

        System.out.println(ans);
    }
}
