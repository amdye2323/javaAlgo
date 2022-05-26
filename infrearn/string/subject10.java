package infrearn.string;

public class subject10 {
    public int[] solution(String str , String t){
        int[] answer = new int[str.length()];
        String[] strList = str.split("");

        int number = 100000;

        for(int i = 0 ;i<str.length();i++) {
            if(strList[i].equals(t)){
                number = 0;
                answer[i] = number;
            }else {
                number++;
                answer[i] = number;
            }
        }

        number = 10000;

        for(int i = str.length()-1 ;i>=0;i--) {
            if(strList[i].equals(t)){
                number = 0;
            }else {
                number++;
                answer[i] = Math.min(answer[i],number);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        subject10 sub = new subject10();

        int[] list =  sub.solution("teachermode","e");

        for(int x : list){
            System.out.printf("%d ",x);
        }

    }
}
