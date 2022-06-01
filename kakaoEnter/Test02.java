package kakaoEnter;
import java.io.*;
import java.util.*;

public class Test02 {
    static HashMap<String,Integer> map = new HashMap<>();

    public static String solution(int n,String str){
        String answer = "";

        ArrayList<String> list = new ArrayList<>();

        for(int i =0;i<n;i+=2){
            list.add(str.substring(i,i+2));
            //answer += map.get(str.substring(i,i+2));
            if(i+3<n){
                String searchValue = str.substring(i+1,i+3);
                if(map.containsKey(searchValue)){
                    list.add(searchValue);
                    //answer += map.get(searchValue);
                }
            }
        }

        for(String s:list){
            answer+=map.get(s);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mapSetting();
        int n = Integer.valueOf(br.readLine());
        String line = br.readLine();

        System.out.println(solution(n,line));
    }

    public static void mapSetting(){
        map.put("qw",1);
        map.put("as",2);
        map.put("zx",3);
        map.put("we",4);
        map.put("sd",5);
        map.put("xc",6);
        map.put("er",7);
        map.put("df",8);
        map.put("cv",9);
        map.put("ze",0);
    }
}
