package kakaoEnter;
import java.io.*;
import java.util.*;

public class Test03 {

    public static int solution(int n){
        int answer = 0;

        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 0;i<n-1;i++){
            int[] line = new int[n-i];
            for(int j = 0;j<line.length;j++){
                line[j] = 1;
            }
            list.add(line);
        }

        for(int i = 1;i<=list.get(1).length;i++){
            LinkedList<Integer> perList = new LinkedList<>();
            int[] checkList = new int[n];
            permu(n,i,perList,checkList,list.get(1));
        }

        return answer;
    }

    public static void permu(int n,int r, LinkedList<Integer> perList , int[] checkList, int[] arr){
        if(perList.size() == r){
            for(int i : perList){
                System.out.print(i + " ");
            }
            System.out.println("");
            return;
        }
        for(int i = 0;i<n;i++){
            if(checkList[i] == 0){
                perList.add(arr[i]);
                checkList[i] = 1;
                permu(n,r,perList,checkList,arr);
                checkList[i] = 0;
                perList.removeLast();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        solution(n);
    }
}
