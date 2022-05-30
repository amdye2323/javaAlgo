package infrearn.twoArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class subject02 {

    public ArrayList<Integer> solution(int n,int m ,int[] a ,int[] b){
        int p1 = 0,p2=0;
        Arrays.sort(a);
        Arrays.sort(b);
        ArrayList<Integer> answer = new ArrayList<>();

        while (p1<n && p2<n){
            if(a[p1] == b[p2]){
                answer.add(a[p1++]);
                p2++;
            }else if(a[p1]<b[p2])p1++;
            else p2++;
        }

        return answer;
    }

    public static void main(String[] args) {
        subject02 sub = new subject02();

        System.out.println(sub.solution(5,5,new int[]{1,3,9,5,2},new int[]{3,2,5,7,8}));
    }
}
