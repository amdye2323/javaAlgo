import java.util.*;
import java.util.HashMap;

public class CodeTest01 {

    public static class person {
        String firName ;
        String midName ;
        String lasName ;

        String fullName ;
        person(String firName , String midName , String lasName , String fullName){
            this.firName = firName;
            this.midName = midName;
            this.lasName = lasName;
            this.fullName = fullName;
        }
    }

    public static void main(String[] args) {
        String S = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String C = "Example.com";

        String[] strList = (S.replace(", ",",")).split(",");

        ArrayList<person> arrList = new ArrayList<>();

        ArrayList<String> checkList = new ArrayList<>();

        for(String a:strList){
            String[] spName = a.split(" ");
            if (spName.length>=3){ // 이름이 3가지일때(미들 네임 존재)
                String fir = spName[0];
                String mid = spName[1];
                String las = spName[2];

                int len = las.replace("-" ,"").length();

                if (len >= 8) {
                    len = 8;
                }

                String perLas = las.toLowerCase().replace("-" ,"").substring(0,len);

                String ful = (fir.substring(0,1).toLowerCase()) + (mid.substring(0,1).toLowerCase()) +perLas;

                checkList.add(ful);

                int count = 0;

                for (String s : checkList) {
                    if (s.equals(ful)) {
                        count ++;
                    }
                }

                if (count>=2) {
                    ful += count;
                }

                person per = new person(fir,mid,las,ful);

                arrList.add(per);
            } else { // 이름이 2가지 일때
                String fir = spName[0];
                String las = spName[1];

                int len = las.replace("-" ,"").length();

                if (len >= 8) {
                    len = 8;
                }

                String perLas = las.toLowerCase().replace("-" ,"").substring(0,len);
                String ful = (fir.substring(0,1).toLowerCase())  + perLas;

                int count = 0;

                checkList.add(ful);

                for (String s : checkList) {
                    if (s.equals(ful)) {
                        count ++;
                    }
                }

                if (count>=2) {
                    ful += count;
                }

                person per = new person(fir,"",las,ful);

                arrList.add(per);
            }
        }

        String answer = "";

        for (person p : arrList) {
            if (p.midName.equals("")){ // 미들네임이 없는경우
                answer += p.firName + " ";
                answer += p.lasName + " ";
                answer += "<"+p.fullName+"@"+C.toLowerCase()+">, ";
            }else {
                answer += p.firName + " ";
                answer += p.midName + " ";
                answer += p.lasName + " ";
                answer += "<"+p.fullName+"@"+C.toLowerCase()+">, ";
            }
        }

        answer =  answer.substring(0,answer.length()-2);
        System.out.println(answer);

    }


}
