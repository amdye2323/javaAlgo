package infrearn.twoArray;

public class subject03 {
    public int solution(int n , int m,int[] arr){
        int maxValue = Integer.MIN_VALUE;

        for (int i=0;i<n-m+1;i++){
            int compareValue = 0;
            for(int j=i;j<i+3;j++){
                compareValue += arr[j];
            }
            if(maxValue<compareValue){
                maxValue = compareValue;
            }
        }

        return maxValue;
    }

    public int solution1(int n , int m,int[] arr){
        int answer = 0;

        int maxValue = 0;

        for(int i = 0;i<m;i++){
            maxValue += arr[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        subject03 sub = new subject03();

        System.out.println(sub.solution(10,3,new int[]{12,15,11,20 ,25 ,10, 20, 19, 13, 15}));
    }
}
