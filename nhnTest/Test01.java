package nhnTest;
import java.util.*;

public class Test01 {
    public static int solution(int[][] cards1 , int[][] cards2){
        int answer = 0;

        for(int i =0;i< cards1.length;i++){

            HashSet<Integer> leftSet = new HashSet<>();
            HashSet<Integer> rightSet = new HashSet<>();

            for(int j = 0;j<5;j++){

                int leftCard = cards1[i][j];
                leftSet.add(leftCard);
                leftSet.add(leftCard);

                int rightCard = cards2[i][j];
                rightSet.add(rightCard);
            }

            if(leftSet.size()<4 || rightSet.size()< 4){
                answer ++;
                continue;
            }

            boolean flag = true;
            //card1 card2 비교
            for(Integer x:leftSet){
                if(rightSet.contains(x)){
                    flag = false;
                }
            }

            if(!flag){
                answer++;
                continue;
            }

            if(i>0){
                int leftCount = 0;
                int rightCount = 0;
                for(int j = 0;j<5;j++){
                    //card1 card1 이전 비교
                    if(leftSet.contains(cards1[i-1][j])){
                        leftCount++;
                    }
                    //card2 card2 이전 비교
                    if(rightSet.contains(cards2[i-1][j])){
                        rightCount++;
                    }
                }

                if(leftCount>=2 || rightCount>=2){
                    answer++;
                    continue;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int answer = solution(new int[][]{{4, 5, 6, 7, 54}, {6, 9, 23, 41, 56}},new int[][]{{11, 15, 23, 51, 54}, {9,11, 23, 51, 54}});
        System.out.println(answer);
    }
}
