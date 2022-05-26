package infrearn.string;

public class subject11 {
    public String solution(String str){
        String answer = "";
        str += " ";
        int cnt = 1;
        for(int i =0;i< str.length()-1;i++){
            if(str.charAt(i)== str.charAt(i+1)) cnt ++;
            else {
                answer+= str.charAt(i);
                if(cnt>1) answer+=String.valueOf(cnt);
                cnt = 1;
            }
        }
//        HashMap<String,Integer> map = new HashMap<>();
//
//        String[] strList = str.split("");
//
//        for(String t:strList){
//            map.put(t,map.getOrDefault(t,0)+1);
//        }
//
//        map.forEach((key,value) -> {
//            System.out.println(key+" "+value);
//        });


        return answer;
    }

    public static void main(String[] args) {
        subject11 sub = new subject11();

        System.out.println(sub.solution("KKHSSSSSSSE"));
    }
}
