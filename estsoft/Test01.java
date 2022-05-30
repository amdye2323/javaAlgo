package estsoft;

import java.util.*;

public class Test01 {

    public static int solution(ArrayList<Integer> list){

        int totalBlackCount = 0;
        int totalBlueCount = 0;
        int blueCount = 0;
        int blackCount = 0;
        boolean startFlag = false;
        boolean expandFlag = false;

        for(int i = 0 ;i<list.size();i++){
            if(list.get(i)==2){
                if(i == 0){
                    startFlag = true;
                    blackCount++;
                }
                if(blueCount>=1){
                    totalBlueCount ++;
                    if(i !=0){
                        expandFlag = true;
                    }
                }
                blueCount = 0;
                blackCount++;
            }else if(list.get(i)==1){
                if(blackCount>=1){
                    if(expandFlag){
                       totalBlackCount--;
                    }else {
                        totalBlackCount ++;
                    }

                }
                blueCount++;
                blackCount = 0;
            }
            else if(list.get(i)==0 ){
                if(list.get(i-1)==2 && blackCount>=1){
                    totalBlackCount+= blackCount;
                }else if(list.get(i-1)==1 &&blueCount>=1){
                    totalBlueCount ++;
                }
                break;
            }
            if(i==list.size()-1){
                if(list.get(i)==2 && blackCount>=1){
                    totalBlackCount+= blackCount;
                } else if(list.get(i) == 1 && blueCount>=1) {
                    totalBlueCount ++;
                }
            }

        }
        if(startFlag && totalBlueCount>=1){
            totalBlackCount --;
        }

        System.out.println((totalBlackCount+totalBlueCount));

        return (totalBlackCount+totalBlueCount);
    }

    public static void main(String[] args) {
        int[][] histogram = new int[][]{
                {0,0,0,0,0},
                {0,0,0,0,0},
                {2,2,0,0,0},
                {1,0,1,0,0},
                {2,1,2,2,2},
                {2,1,2,2,2},
        };

        int answer = 1;

        for(int i = 0;i<histogram[0].length;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = histogram.length-1;j>=0 ;j--){
                list.add(histogram[j][i]);
            }
            answer = (answer*solution(list));
        }

        System.out.println(answer);
    }
}
