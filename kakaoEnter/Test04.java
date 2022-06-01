package kakaoEnter;

import java.io.*;

public class Test04 {

    public static int solution(int n , char[] originRumerList){
        int answer = 0;

        char[] rumerList = new char[originRumerList.length];

        for(int i = 0;i<n;i++){
            int rumer = originRumerList[i];
            int compare = (rumer+(i+1));
            if(compare>122){
                compare = ((compare) % 122) % 26;
                int input = (compare +96);
                char in =(char) input;
                rumerList[i] = in;
            } else {
                char input = (char) (compare);
                rumerList[i] = input;
            }
        }

        for(int i =0;i<rumerList.length;i++){
           if(originRumerList[i]<=rumerList[i]){
                answer++;
           }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        String rumer = br.readLine();
        char[] rumerList = rumer.toCharArray();

        System.out.println(solution(n,rumerList));
    }
}
