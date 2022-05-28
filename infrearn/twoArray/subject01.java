package infrearn.twoArray;

import java.util.ArrayList;

public class subject01 {

    public ArrayList<Integer> solution(int n,int[] a , int m, int[] b ){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0, p2=0;
        while(p1<n && p2<m){
            if(a[p1]<b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        while(p1<n) answer.add(a[p1++]);
        while(p2<m) answer.add(b[p2++]);
        return answer;
    }

    public static void main(String[] args) {
        subject01 sub = new subject01();

    }
}
