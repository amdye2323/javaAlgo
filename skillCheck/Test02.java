package skillCheck;

import java.util.*;

public class Test02 {
    public static void main(String[] args) {
        String dartResult = "1D2S0T";

        int answer = solution(dartResult);

        System.out.println(answer);
    }

    public static int solution(String dartResult) {
        String one = dartResult.split("2")[0];
        String two = dartResult.split("3")[0].replace(one,"");
        String three = dartResult.replace(one+two,"");

        ArrayList<String> list = new ArrayList<>();

        list.add(one);
        list.add(two);
        list.add(three);

        int answer = 0;
        int[] arrList = new int[3];

        for (int i = 0;i<list.size();i++) {

            String[] li = list.get(i).split("");
            if (li[0].equals("")) {
                continue;
            }
            int number = Integer.parseInt(li[0]);
            boolean star = false;

            for (int j = 1;j<li.length;j++) {
                switch (li[j]){
                    case "S" : {
                        number = (int) Math.pow(number,1);
                    } break;
                    case "D" : {
                        number = (int) Math.pow(number,2);
                    } break;
                    case "T" : {
                        number = (int) Math.pow(number,3);
                    } break;
                    case "*" : {
                        star = true;
                    } break;
                    case "#" : {
                        number = number * -1;
                    }break;
                }
            }

            arrList[i] = number;

            if (star == true) {
                for(int c = 0;c<arrList.length;c++) {
                    arrList[c] = arrList[c] * 2;
                }
            }
        }

        for (Integer c : arrList) {
            answer = answer + c;
        }

        return answer;
    }
}
