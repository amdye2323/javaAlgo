package infrearn.array;
import java.util.*;
import java.util.stream.Collectors;

public class subject08 {

    public ArrayList<Integer> solution(int n , int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0;i<n;i++){
            int count = 1;
            for(int j = 0;j<n;j++){
                if(j!=i && arr[i]<arr[j]){
                    count++;
                }
            }

            answer.add(count);
        }

        return answer;
    }

    public static void main(String[] args) {
        subject08 sub = new subject08();

        ArrayList<Integer> list = sub.solution(5,new int[]{92 ,89, 92, 100, 76});


    }
}
